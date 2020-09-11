package io.github.manuelernesto.gadsleaderboard.data.repository

import io.github.manuelernesto.gadsleaderboard.data.network.GFormAPI
import io.github.manuelernesto.gadsleaderboard.data.network.SafeAPIRequest

class ProjectSubmitRepository(
    private val api: GFormAPI
) : SafeAPIRequest() {

    suspend fun saveForm(
        firstName: String,
        lastName: String,
        email: String,
        link: String
    ) = apiRequest { api.saveForm(firstName, lastName, email, link) }
}
