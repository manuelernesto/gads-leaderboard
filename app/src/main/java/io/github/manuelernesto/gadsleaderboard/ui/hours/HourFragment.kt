package io.github.manuelernesto.gadsleaderboard.ui.hours

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.manuelernesto.gadsleaderboard.R
import io.github.manuelernesto.gadsleaderboard.data.network.AppAPI
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerHourRepository
import kotlinx.android.synthetic.main.hour_fragment.*

class HourFragment : Fragment() {

    private lateinit var factory: HourViewModelFactory
    private lateinit var viewModel: HourViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hour_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = AppAPI()
        val repository = LearnerHourRepository(api)

        factory = HourViewModelFactory(repository)

        viewModel = ViewModelProviders.of(this, factory).get(HourViewModel::class.java)
        viewModel.getLearnerPerHour()

        viewModel.learnerPerHour.observe(viewLifecycleOwner, Observer { learnersPerHour ->
            rv_hour.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    HourAdapter(learnersPerHour)
            }
        })

    }

}