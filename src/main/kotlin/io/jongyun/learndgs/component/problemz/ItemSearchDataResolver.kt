package io.jongyun.learndgs.component.problemz

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.DgsConstants
import io.jongyun.learndgs.service.query.ProblemzQueryService
import io.jongyun.learndgs.service.query.SolutionQueryService
import io.jongyun.learndgs.types.SearchItemFilter
import io.jongyun.learndgs.types.SearchableItem
import io.jongyun.learndgs.util.mapToGraphql

@DgsComponent
class ItemSearchDataResolver(
    private val problemzQueryService: ProblemzQueryService,
    private val solutionzQueryService: SolutionQueryService
) {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.ItemSearch)
    fun searchItems(
        @InputArgument(
            name = "filter",
            collectionType = SearchItemFilter::class
        ) searchItemFilter: SearchItemFilter
    ): List<SearchableItem> {
        val problemzByKeyword = problemzQueryService.problemzByKeyword(searchItemFilter.keyword)
            .map { mapToGraphql(it) }
        val solutionzByKeyword = solutionzQueryService.solutionByKeyword(searchItemFilter.keyword)
            .map { mapToGraphql(it) }
        val result: List<SearchableItem> = listOf(problemzByKeyword).flatten()
        result.plus(solutionzByKeyword)
       
        return result
    }
}