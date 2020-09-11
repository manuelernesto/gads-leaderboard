package io.github.manuelernesto.gadsleaderboard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.manuelernesto.gadsleaderboard.R
import io.github.manuelernesto.gadsleaderboard.ui.hours.HourFragment
import io.github.manuelernesto.gadsleaderboard.ui.skilliq.SkillFragment
import io.github.manuelernesto.gadsleaderboard.ui.submit.SubmitProjectActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        tab_layout.setupWithViewPager(view_pager)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, 0).also {
            it.addFragment(HourFragment(), "Learning Leaders")
            it.addFragment(SkillFragment(), "Skill IQ Leaders")
        }

        view_pager.adapter = viewPagerAdapter

        btn_submit.setOnClickListener {
            Intent(this, SubmitProjectActivity::class.java).also {
                startActivity(it)
            }
        }
    }

}