package io.github.manuelernesto.gadsleaderboard.ui.hours

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.manuelernesto.gadsleaderboard.data.model.Learner
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerHourRepository
import io.github.manuelernesto.gadsleaderboard.util.Coroutines
import kotlinx.coroutines.Job

class HourViewModel(
    private val repository: LearnerHourRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _hours = MutableLiveData<List<Learner>>()
    val learnerPerHour: LiveData<List<Learner>>
        get() = _hours


    fun getLearnerPerHour() {
        job = Coroutines.ioThenMan(
            { repository.getLearnerPerHour() },
            { _hours.value = it }
        )
    }


    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}



