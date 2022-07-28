package io.jongyun.learndgs.datsource.problemz.repository

import io.jongyun.learndgs.datsource.problemz.entity.Userz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserzRepository : JpaRepository<Userz, UUID?> {
}