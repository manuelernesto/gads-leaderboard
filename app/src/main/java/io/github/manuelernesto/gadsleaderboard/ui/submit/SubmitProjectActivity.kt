package io.github.manuelernesto.gadsleaderboard.ui.submit

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.manuelernesto.gadsleaderboard.R
import kotlinx.android.synthetic.main.activity_submit.*

class SubmitProjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.submit_project_activity)

        setSupportActionBar(toolbar)
        toolbar.navigationIcon?.setColorFilter(
            resources.getColor(R.color.colorCustom),
            PorterDuff.Mode.SRC_ATOP
        );
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SubmitProjectFragment.newInstance())
                .commitNow()
        }
    }
}