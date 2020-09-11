package io.github.manuelernesto.gadsleaderboard.ui.submit

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import io.github.manuelernesto.gadsleaderboard.data.repository.ProjectSubmitRepository
import io.github.manuelernesto.gadsleaderboard.util.ApiExeption
import io.github.manuelernesto.gadsleaderboard.util.Coroutines

class SubmitViewModel(
    private val repository: ProjectSubmitRepository
) : ViewModel() {

    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var link: String? = null

    var submitListener: SubmitListener? = null


    fun onSubmitButtonClick(view: View) {
        submitListener?.onStarted()
        Log.e("GOOGLE", "message")
        if (
            firstName.isNullOrEmpty() || lastName.isNullOrEmpty() ||
            email.isNullOrEmpty() || link.isNullOrEmpty()
        ) {
            submitListener?.onFailure("Blank fields not allowed")
            return
        }

        Coroutines.main {
            try {
                val response = repository.saveForm(firstName!!, lastName!!, email!!, link!!)
                response.let {
                    submitListener?.onSuccess("Submission Successful")
                }
                submitListener?.onFailure("Submission not Successful")
            } catch (e: ApiExeption) {
                submitListener?.onFailure("Submission not Successful")
            }
        }
    }

}