package io.github.manuelernesto.gadsleaderboard.ui.skilliq

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.manuelernesto.gadsleaderboard.data.model.Learner
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerSkillRepository
import io.github.manuelernesto.gadsleaderboard.util.Coroutines
import kotlinx.coroutines.Job

class SkillViewModel(
    private val repository: LearnerSkillRepository
) : ViewModel() {

    private lateinit var job: Job


    private val _skills = MutableLiveData<List<Learner>>()
    val learnerPerSkill: LiveData<List<Learner>>
        get() = _skills


    fun getLearnerPerSkill() {
        job = Coroutines.ioThenMan(
            { repository.getLearnerPerSkill() },
            { _skills.value = it }
        )
    }


    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}