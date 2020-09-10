package io.github.manuelernesto.gadsleaderboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import io.github.manuelernesto.gadsleaderboard.R
import io.github.manuelernesto.gadsleaderboard.ui.hours.HourFragment
import io.github.manuelernesto.gadsleaderboard.ui.skilliq.SkillFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var hourFragment: HourFragment
    private lateinit var skiFragment: SkillFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        hourFragment = HourFragment()
        skiFragment = SkillFragment()


        tab_layout.setupWithViewPager(view_pager)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, 0)
        viewPagerAdapter.addFragment(hourFragment, "Learning Leaders")
        viewPagerAdapter.addFragment(skiFragment, "Skill IQ Leaders")
        view_pager.adapter = viewPagerAdapter

        btn_submit.setOnClickListener {

        }
    }

}