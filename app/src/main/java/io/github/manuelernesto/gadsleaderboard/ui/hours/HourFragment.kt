package io.github.manuelernesto.gadsleaderboard.ui.hours

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.manuelernesto.gadsleaderboard.R

class HourFragment : Fragment() {

    companion object {
        fun newInstance() = HourFragment()
    }

    private lateinit var viewModel: HourViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hour_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HourViewModel::class.java)
        // TODO: Use the ViewModel
    }

}