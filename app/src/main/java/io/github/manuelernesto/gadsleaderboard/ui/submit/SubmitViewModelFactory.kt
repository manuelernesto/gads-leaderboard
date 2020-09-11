package io.github.manuelernesto.gadsleaderboard.ui.submit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.manuelernesto.gadsleaderboard.data.repository.ProjectSubmitRepository

class SubmitViewModelFactory(
    private val repository: ProjectSubmitRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SubmitViewModel(
            repository
        ) as T
    }
}