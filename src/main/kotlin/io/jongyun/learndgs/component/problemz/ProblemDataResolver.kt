package io.jongyun.learndgs.component.problemz

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.DgsConstants
import io.jongyun.learndgs.service.query.ProblemzQueryService
import io.jongyun.learndgs.types.Problem
import io.jongyun.learndgs.types.ProblemCreateInput
import io.jongyun.learndgs.types.ProblemResponse
import io.jongyun.learndgs.util.mapToGraphql
import org.springframework.web.bind.annotation.RequestHeader
import reactor.core.publisher.Flux
import java.util.*

@DgsComponent
class ProblemDataResolver(
    val problemzQueryService: ProblemzQueryService
) {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.ProblemLatestList)
    fun getProblemLatestLIst(): List<Problem> {
        return problemzQueryService.problemzLatestList().map { mapToGraphql(it) }
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.ProblemDetail)
    fun getProblemDetail(@InputArgument(name = "id") problemId: String): Problem {
        return mapToGraphql(problemzQueryService.problemDetail(UUID.fromString(problemId)))
    }

    @DgsData(parentType = DgsConstants.MUTATION.TYPE_NAME, field = DgsConstants.MUTATION.ProblemCreate)
    fun createProblem(
        @RequestHeader(name = "authToken", required = true) authToken: String,
        @InputArgument(name = "problem") problemCreateInput: ProblemCreateInput
    ): ProblemResponse? {
        return null
    }

    @DgsData(parentType = DgsConstants.Subscription_TYPE, field = DgsConstants.SUBSCRIPTION.ProblemAdded)
    fun subscribeProblemAdded(): Flux<Problem>? {
        return null
    }
}