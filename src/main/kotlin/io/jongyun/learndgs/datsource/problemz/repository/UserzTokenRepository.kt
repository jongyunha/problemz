package io.jongyun.learndgs.datsource.problemz.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserzTokenRepository : JpaRepository<UserzRepository, UUID> {
}