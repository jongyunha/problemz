package io.jongyun.learndgs.datsource.problemz.repository

import io.jongyun.learndgs.datsource.problemz.entity.Solutionz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface SolutionzRepository : JpaRepository<Solutionz, Long?> {

    @Query(nativeQuery = true, value = "select * from solutionz where upper(content) like upper(:keyword)")
    fun findByKeyword(@Param("keyword") keyword: String): ArrayList<Solutionz>
}