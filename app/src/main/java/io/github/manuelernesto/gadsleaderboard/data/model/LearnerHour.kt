package io.github.manuelernesto.gadsleaderboard.data.model

data class LearnerHour(
    val name: String,
    val hours: Int,
    val country: String,
    val badgeUrl: String
) {
    fun description(): String {
        return "$hours learning hours, $country"
    }
}