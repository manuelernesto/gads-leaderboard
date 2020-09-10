package io.github.manuelernesto.gadsleaderboard.ui.submit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.manuelernesto.gadsleaderboard.R
import kotlinx.android.synthetic.main.activity_submit.*

class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        setSupportActionBar(toolbar)
    }
}