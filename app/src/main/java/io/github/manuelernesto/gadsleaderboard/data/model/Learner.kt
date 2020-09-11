package io.github.manuelernesto.gadsleaderboard.data.model

data class Learner(
    val name: String,
    val score: Int,
    val hours: Int,
    val country: String,
    val badgeUrl: String
) {
    fun description(): String {
        if (hours != 0)
            return "$hours learning hours, $country"

        return "$score skill IQ Score, $country"
    }
}

