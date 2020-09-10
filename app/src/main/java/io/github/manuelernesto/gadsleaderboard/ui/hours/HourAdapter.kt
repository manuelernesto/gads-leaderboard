package io.github.manuelernesto.gadsleaderboard.ui.hours

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.manuelernesto.gadsleaderboard.R
import io.github.manuelernesto.gadsleaderboard.data.model.LearnerHour
import io.github.manuelernesto.gadsleaderboard.databinding.HourLearnerItemBinding

class HourAdapter(
    private val hours: List<LearnerHour>
) : RecyclerView.Adapter<HourAdapter.HourHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HourHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.hour_learner_item,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: HourHolder, position: Int) {
        holder.hourLearnerItemBinding.hour = hours[position]
    }

    override fun getItemCount() = hours.size

    inner class HourHolder(val hourLearnerItemBinding: HourLearnerItemBinding) :
        RecyclerView.ViewHolder(hourLearnerItemBinding.root)
}