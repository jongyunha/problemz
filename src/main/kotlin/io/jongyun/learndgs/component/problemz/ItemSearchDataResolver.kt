package io.jongyun.learndgs.component.problemz

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.DgsConstants
import io.jongyun.learndgs.types.SearchItemFilter

@DgsComponent
class ItemSearchDataResolver {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.ItemSearch)
    fun searchItems(
        @InputArgument(
            name = "filter",
            collectionType = SearchItemFilter::class
        ) searchItemFilter: SearchItemFilter
    ) {

    }
}