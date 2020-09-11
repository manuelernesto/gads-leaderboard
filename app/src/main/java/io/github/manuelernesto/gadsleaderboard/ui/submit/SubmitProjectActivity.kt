package io.github.manuelernesto.gadsleaderboard.ui.submit

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.manuelernesto.gadsleaderboard.R
import kotlinx.android.synthetic.main.submit_project_activity.*

class SubmitProjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.submit_project_activity)

        setSupportActionBar(toolbar)

        val backArrow: Drawable = resources.getDrawable(R.drawable.ic_arrow, null)
        supportActionBar?.setHomeAsUpIndicator(backArrow)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SubmitProjectFragment())
                .commitNow()
        }
    }
}