package io.jongyun.learndgs.datsource.problemz.entity

import org.hibernate.annotations.CreationTimestamp
import java.net.URL
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "userz")
class Userz(
    id: UUID?,
    var username: String,
    var email: String,
    var hashedPassword: String,
    var avatar: URL,
    @CreationTimestamp
    var createdAt: LocalDateTime,
    var active: Boolean
) {

    @Id
    var id: UUID? = id
}