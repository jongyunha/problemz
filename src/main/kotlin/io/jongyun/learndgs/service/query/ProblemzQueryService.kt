package io.jongyun.learndgs.service.query

import io.jongyun.learndgs.datsource.problemz.entity.Problemz
import io.jongyun.learndgs.datsource.problemz.repository.ProblemzRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class ProblemzQueryService(
    private val problemzRepository: ProblemzRepository
) {

    @Transactional(readOnly = true)
    fun problemzLatestList(): List<Problemz> {
        return problemzRepository.findAllByOrderByCreatedAtDesc()
    }

    fun problemDetail(problemId: UUID): Problemz {
        return problemzRepository.findById(problemId) ?: throw IllegalArgumentException("잘못된 ID 입니다 ID: $problemId")
    }

    fun problemzByKeyword(keyword: String): ArrayList<Problemz> {
        return problemzRepository.findByKeyword("%$keyword%")
    }
}