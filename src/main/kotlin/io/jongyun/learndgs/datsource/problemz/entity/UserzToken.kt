package io.jongyun.learndgs.datsource.problemz.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "userz_token")
class UserzToken(
    userId: UUID?,
    var authToken: String,
    var expiryAt: LocalDateTime,
    @CreationTimestamp
    var createdAt: LocalDateTime
) {

    @Id
    var userId: UUID? = userId
}