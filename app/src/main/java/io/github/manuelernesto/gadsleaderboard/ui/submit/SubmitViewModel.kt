package io.github.manuelernesto.gadsleaderboard.ui.submit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import io.github.manuelernesto.gadsleaderboard.R
import io.github.manuelernesto.gadsleaderboard.data.repository.ProjectSubmitRepository
import io.github.manuelernesto.gadsleaderboard.util.ApiExeption
import io.github.manuelernesto.gadsleaderboard.util.Coroutines
import kotlinx.android.synthetic.main.custom_confirm_layout.view.*

class SubmitViewModel(
    private val repository: ProjectSubmitRepository
) : ViewModel() {

    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var link: String? = null

    var submitListener: SubmitListener? = null


    fun onSubmitButtonClick(view: View) {
        confirmDialog(view.context)

    }

    private fun confirmDialog(context: Context) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        val view = LayoutInflater.from(context).inflate(R.layout.custom_confirm_layout, null)

        builder.setView(view)
        val alertDialog: AlertDialog = builder.create()

        view.btn_ok.setOnClickListener {
            submit()
            alertDialog.dismiss()
        }
        view.btn_close.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()

    }

    private fun submit() {
        Coroutines.main {
            submitListener?.onStarted()
            if (
                firstName.isNullOrEmpty() || lastName.isNullOrEmpty() ||
                email.isNullOrEmpty() || link.isNullOrEmpty()
            ) {
                submitListener?.onFailure("Blank fields not allowed")
                return@main
            }
            try {
                val response = repository.saveForm(firstName!!, lastName!!, email!!, link!!)
                response.let {
                    submitListener?.onSuccess("Submission Successful")
                }
            } catch (e: ApiExeption) {
                submitListener?.onFailure("Submission not Successful")
            }
        }
    }
}