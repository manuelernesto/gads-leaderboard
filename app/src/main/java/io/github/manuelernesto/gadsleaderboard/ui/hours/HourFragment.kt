package io.github.manuelernesto.gadsleaderboard.ui.hours

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
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class HourFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private val factory: HourViewModelFactory by instance()
    private lateinit var viewModel: HourViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hour_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory).get(HourViewModel::class.java)
        viewModel.getLearnerPerHour()

        viewModel.learnerPerHour.observe(viewLifecycleOwner, Observer { learnersPerHour ->

            progressBar.visibility = ProgressBar.INVISIBLE

            rv_hour.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    HourAdapter(learnersPerHour)
            }
        })

    }

}