package io.github.manuelernesto.gadsleaderboard.data.repository

import io.github.manuelernesto.gadsleaderboard.data.network.AppAPI
import io.github.manuelernesto.gadsleaderboard.data.network.SafeAPIRequest

class LearnerHourRepository(
    private val api: AppAPI
) : SafeAPIRequest() {

    suspend fun getLearnerPerHour() = apiRequest { api.getLearnerPerHour() }
}
