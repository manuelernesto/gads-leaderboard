package io.github.manuelernesto.gadsleaderboard.ui.skilliq

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerHourRepository
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerSkillRepository

class SkillViewModelFactory(
    private val repository: LearnerSkillRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SkillViewModel(
            repository
        ) as T
    }
}