package io.jongyun.learndgs.datsource.fake

import com.github.javafaker.Faker
import com.netflix.dgs.codegen.generated.types.Cat
import com.netflix.dgs.codegen.generated.types.Dog
import com.netflix.dgs.codegen.generated.types.Pet
import com.netflix.dgs.codegen.generated.types.PetFoodType
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class FakePetDataSource(
    val faker: Faker
) {

    companion object {
        val PET_LIST = ArrayList<Pet>();
    }

    @PostConstruct
    private fun postConstruct() {
        (1..10).forEach { i ->
            val animal = when (i % 2) {
                0 -> Dog(
                    name = faker.dog().name(),
                    food = PetFoodType.OMNIVORE,
                    breed = faker.dog().breed(),
                    size = faker.dog().size(),
                    coatLength = faker.dog().coatLength()
                )
                else -> Cat(
                    name = faker.cat().name(),
                    food = PetFoodType.CARNIVORE,
                    breed = faker.cat().breed(),
                    registry = faker.cat().registry()
                )
            }
            PET_LIST.add(animal)
        }
    }
}