package io.github.manuelernesto.gadsleaderboard.ui.skilliq

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.manuelernesto.gadsleaderboard.R
import io.github.manuelernesto.gadsleaderboard.data.network.AppAPI
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerHourRepository
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerSkillRepository
import io.github.manuelernesto.gadsleaderboard.ui.hours.HourAdapter
import io.github.manuelernesto.gadsleaderboard.ui.hours.HourViewModelFactory
import kotlinx.android.synthetic.main.hour_fragment.*
import kotlinx.android.synthetic.main.skill_fragment.*

class SkillFragment : Fragment() {

    private lateinit var factory: SkillViewModelFactory
    private lateinit var viewModel: SkillViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.skill_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = AppAPI()
        val repository = LearnerSkillRepository(api)

        factory = SkillViewModelFactory(repository)

        viewModel = ViewModelProviders.of(this, factory).get(SkillViewModel::class.java)

        viewModel.getLearnerPerSkill()

        viewModel.learnerPerSkill.observe(viewLifecycleOwner, Observer { learnersPerSkill ->
            rv_skill.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    SkillAdapter(learnersPerSkill)
            }
        })
    }

}