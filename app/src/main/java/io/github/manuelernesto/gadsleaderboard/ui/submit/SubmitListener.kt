package io.github.manuelernesto.gadsleaderboard.ui.submit

interface SubmitListener {
    fun onStarted()
    fun onFailure(message: String)
    fun onSuccess(message: String)
}