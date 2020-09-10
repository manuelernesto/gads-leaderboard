package io.github.manuelernesto.gadsleaderboard.data.repository

import io.github.manuelernesto.gadsleaderboard.data.network.AppAPI
import io.github.manuelernesto.gadsleaderboard.data.network.SafeAPIRequest

class LearnerSkillRepository(
    private val api: AppAPI
) : SafeAPIRequest() {

    suspend fun getLearnerPerSkill() = apiRequest { api.getLearnerPerSkillIQ() }
}
