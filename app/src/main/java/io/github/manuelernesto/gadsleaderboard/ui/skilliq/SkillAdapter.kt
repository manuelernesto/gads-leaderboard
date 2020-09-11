package io.github.manuelernesto.gadsleaderboard.ui.skilliq

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.manuelernesto.gadsleaderboard.R
import io.github.manuelernesto.gadsleaderboard.data.model.Learner
import io.github.manuelernesto.gadsleaderboard.databinding.SkilliqLeanerItemBinding

class SkillAdapter(
    private val skills: List<Learner>
) : RecyclerView.Adapter<SkillAdapter.SkillHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SkillHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.skilliq_leaner_item,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: SkillHolder, position: Int) {
        holder.skilliqLeanerItemBinding.skill = skills[position]
    }

    override fun getItemCount() = skills.size

    inner class SkillHolder(val skilliqLeanerItemBinding: SkilliqLeanerItemBinding) :
        RecyclerView.ViewHolder(skilliqLeanerItemBinding.root)
}