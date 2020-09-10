package io.github.manuelernesto.gadsleaderboard.data.model

data class LearnerHour(
    val name: String,
    val hours: Int,
    val country: String,
    val badgeUrl: String
) {
    fun descrption(): String {
        return "$hours learning hours, $country"
    }
}