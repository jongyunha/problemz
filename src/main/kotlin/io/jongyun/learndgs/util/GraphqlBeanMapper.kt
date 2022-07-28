package io.jongyun.learndgs.util

import io.jongyun.learndgs.datsource.problemz.entity.Problemz
import io.jongyun.learndgs.datsource.problemz.entity.Solutionz
import io.jongyun.learndgs.datsource.problemz.entity.Userz
import io.jongyun.learndgs.datsource.problemz.entity.UserzToken
import io.jongyun.learndgs.types.*
import java.time.ZoneOffset

val ZONE_OFFSET = ZoneOffset.ofHours(9)


fun mapToGraphql(original: Userz): User {
    return User(
        avatar = original.avatar,
        createdAt = original.createdAt.atOffset(ZONE_OFFSET),
        displayName = original.displayName,
        email = original.email,
        id = original.id.toString(),
        username = original.username
    )
}

fun mapToGraphql(original: Problemz): Problem {
    return Problem(
        id = original.id.toString(),
        createdAt = original.createdAt.atOffset(ZONE_OFFSET),
        title = original.title,
        content = original.content,
        tags = original.tsgs.split(","),
        solutionCount = original.solutionzList.count(),
        author = mapToGraphql(original.createdBy),
        solutions = original.solutionzList.map { mapToGraphql(it) }
    )
}

fun mapToGraphql(original: Solutionz): Solution {
    return Solution(
        createdAt = original.createdAt.atOffset(ZONE_OFFSET),
        author = mapToGraphql(original.createdBy),
        category = if (original.category == SolutionCategory.EXPLANTATION.toString())
            SolutionCategory.EXPLANTATION else SolutionCategory.REFERENCE,
        content = original.content,
        id = original.id.toString(),
        voteAsGoodCount = original.voteGoodCount,
        voteAsBadCount = original.votBadCount
    )
}

fun mapToGraphql(original: UserzToken): UserAuthToken {
    return UserAuthToken(
        authToken = original.authToken,
        expiryTime = original.expiryAt.atOffset(ZONE_OFFSET)
    )
}