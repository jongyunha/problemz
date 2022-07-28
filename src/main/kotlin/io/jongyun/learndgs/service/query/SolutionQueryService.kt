package io.jongyun.learndgs.service.query

import io.jongyun.learndgs.datsource.problemz.entity.Solutionz
import io.jongyun.learndgs.datsource.problemz.repository.SolutionzRepository
import org.springframework.stereotype.Service

@Service
class SolutionQueryService(
    private val solutionzRepository: SolutionzRepository
) {

    fun solutionByKeyword(keyword: String): ArrayList<Solutionz> {
        return solutionzRepository.findByKeyword("%$keyword%")
    }
}