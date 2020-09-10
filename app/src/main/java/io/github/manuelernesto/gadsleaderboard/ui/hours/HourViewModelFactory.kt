package io.github.manuelernesto.gadsleaderboard.ui.hours

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerHourRepository

class HourViewModelFactory(
    private val repository: LearnerHourRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HourViewModel(
            repository
        ) as T
    }
}