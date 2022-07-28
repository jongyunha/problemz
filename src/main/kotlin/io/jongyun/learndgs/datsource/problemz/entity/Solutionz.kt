package io.jongyun.learndgs.datsource.problemz.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "solutionz")
class Solutionz(
    id: UUID,
    var content: String,
    var category: String,
    var voteGoodCount: Int,
    var votBadCount: Int,
    createdBy: Userz,
    problem: Problemz,
    @CreationTimestamp
    var createdAt: LocalDateTime
) {

    @Id
    var id: UUID = id

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    var createdBy: Userz = createdBy

    @ManyToOne
    @JoinColumn(name = "problem", nullable = false)
    var problem: Problemz = problem
}