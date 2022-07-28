package io.jongyun.learndgs.datsource.problemz.repository

import io.jongyun.learndgs.datsource.problemz.entity.Problemz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProblemzRepository : JpaRepository<Problemz, Long?> {

    fun findAllByOrderByCreatedAtDesc(): List<Problemz>

    fun findById(id: UUID): Problemz?

    @Query(
        nativeQuery = true,
        value = """select * from problemz p 
                where upper(content) like upper(:keyword)
                or upper(title) like upper(:keyword)
                or upper(tags) like upper(:keyword)
                """
    )
    fun findByKeyword(@Param(value = "keyword") keyword: String): ArrayList<Problemz>
}