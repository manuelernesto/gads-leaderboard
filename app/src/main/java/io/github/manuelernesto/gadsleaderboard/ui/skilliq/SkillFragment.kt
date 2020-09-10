package io.github.manuelernesto.gadsleaderboard.ui.skilliq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.manuelernesto.gadsleaderboard.R
import kotlinx.android.synthetic.main.hour_fragment.*
import kotlinx.android.synthetic.main.skill_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class SkillFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private val factory: SkillViewModelFactory by instance()
    private lateinit var viewModel: SkillViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.skill_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory).get(SkillViewModel::class.java)

        viewModel.getLearnerPerSkill()

        viewModel.learnerPerSkill.observe(viewLifecycleOwner, Observer { learnersPerSkill ->

            progressBarSkill.visibility = ProgressBar.INVISIBLE

            rv_skill.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    SkillAdapter(learnersPerSkill)
            }

        })
    }

}