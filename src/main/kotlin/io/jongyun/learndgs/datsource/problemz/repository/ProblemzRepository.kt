package io.jongyun.learndgs.datsource.problemz.repository

import io.jongyun.learndgs.datsource.problemz.entity.Problemz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProblemzRepository : JpaRepository<Problemz, Long?> {

    fun findAllByOrderByCreatedAtDesc(): List<Problemz>

    fun findById(id: UUID): Problemz?
}