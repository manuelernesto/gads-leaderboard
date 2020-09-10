package io.github.manuelernesto.gadsleaderboard.data.model

data class LearnerSkill(
    val name: String,
    val score: Int,
    val country: String,
    val badgeUrl: String
) {
    fun description(): String {
        return "$score skill IQ Score, $country"
    }
}