package io.jongyun.learndgs.component.problemz

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import io.jongyun.learndgs.DgsConstants
import io.jongyun.learndgs.types.Solution
import io.jongyun.learndgs.types.SolutionCreateInput
import io.jongyun.learndgs.types.SolutionResponse
import io.jongyun.learndgs.types.SolutionVoteInput
import org.springframework.web.bind.annotation.RequestHeader
import reactor.core.publisher.Flux

@DgsComponent
class SolutionDataResolver {

    @DgsData(parentType = DgsConstants.MUTATION.TYPE_NAME, field = DgsConstants.MUTATION.SolutionCreate)
    fun createResponse(
        @RequestHeader(name = "authToken") authToken: String,
        @InputArgument(name = "newSolution") solutionCreateInput: SolutionCreateInput
    ): SolutionResponse? {
        return null
    }

    @DgsData(parentType = DgsConstants.MUTATION.TYPE_NAME, field = DgsConstants.MUTATION.SolutionVote)
    fun createSolutionVote(
        @RequestHeader(name = "authToken") authToken: String,
        @InputArgument(name = "newVote") voteInput: SolutionVoteInput
    ): SolutionResponse? {
        return null
    }

    @DgsData(parentType = DgsConstants.Subscription_TYPE, field = DgsConstants.SUBSCRIPTION.SolutionVoteChanged)
    fun subscribeSolutionVote(@InputArgument(name = "id") solutionId: String): Flux<Solution>? {
        return null
    }
}