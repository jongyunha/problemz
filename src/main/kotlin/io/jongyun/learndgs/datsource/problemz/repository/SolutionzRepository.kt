package io.jongyun.learndgs.datsource.problemz.repository

import io.jongyun.learndgs.datsource.problemz.entity.Solutionz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SolutionzRepository : JpaRepository<Solutionz, Long> {
}