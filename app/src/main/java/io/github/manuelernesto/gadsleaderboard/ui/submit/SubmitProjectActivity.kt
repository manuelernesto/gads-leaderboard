package io.github.manuelernesto.gadsleaderboard.ui.submit

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import io.github.manuelernesto.gadsleaderboard.R
import io.github.manuelernesto.gadsleaderboard.databinding.SubmitProjectActivityBinding
import io.github.manuelernesto.gadsleaderboard.util.customDialog
import io.github.manuelernesto.gadsleaderboard.util.hide
import io.github.manuelernesto.gadsleaderboard.util.show
import kotlinx.android.synthetic.main.submit_project_activity.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SubmitProjectActivity : AppCompatActivity(), KodeinAware, SubmitListener {

    override val kodein: Kodein by kodein()

    private val factory: SubmitViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.submit_project_activity)

        val binding: SubmitProjectActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.submit_project_activity)
        val viewModel: SubmitViewModel =
            ViewModelProviders.of(this, factory).get(SubmitViewModel::class.java)

        binding.viewModel = viewModel
        viewModel.submitListener = this

        setSupportActionBar(toolbar)

        val backArrow: Drawable = resources.getDrawable(R.drawable.ic_arrow, null)
        supportActionBar?.setHomeAsUpIndicator(backArrow)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    override fun onStarted() {
        progressBar_Submit.show()
    }

    override fun onFailure(message: String) {
        progressBar_Submit.hide()
        customDialog(this, message, R.drawable.ic_warning)
    }

    override fun onSuccess(message: String) {
        progressBar_Submit.hide()
        customDialog(this, message, R.drawable.ic_check)
    }

}