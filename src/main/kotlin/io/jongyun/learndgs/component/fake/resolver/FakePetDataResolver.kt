package io.jongyun.learndgs.component.fake.resolver

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.DgsConstants
import io.jongyun.learndgs.datsource.fake.FakePetDataSource
import io.jongyun.learndgs.types.Cat
import io.jongyun.learndgs.types.Dog
import io.jongyun.learndgs.types.Pet
import io.jongyun.learndgs.types.PetFilter
import org.apache.commons.lang3.StringUtils

@DgsComponent
class FakePetDataResolver {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Pets)
    fun getPets(@InputArgument(name = "petFilter", collectionType = PetFilter::class) filter: PetFilter?): List<Pet> {
        return if (filter == null) {
            FakePetDataSource.PET_LIST
        } else {
            FakePetDataSource.PET_LIST.filter { matchFilter(petFilter = filter, pet = it) }
        }
    }
}

fun matchFilter(petFilter: PetFilter, pet: Pet): Boolean {
    return when {
        StringUtils.isBlank(petFilter.petType) -> true
        petFilter.petType.equals(Dog::class.simpleName) -> pet is Dog
        petFilter.petType.equals(Cat::class.simpleName) -> pet is Cat
        else -> false
    }
}