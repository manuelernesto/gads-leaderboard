package io.github.manuelernesto.gadsleaderboard

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import io.github.manuelernesto.gadsleaderboard.data.network.AppAPI
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerHourRepository
import io.github.manuelernesto.gadsleaderboard.data.repository.LearnerSkillRepository
import io.github.manuelernesto.gadsleaderboard.ui.hours.HourViewModelFactory
import io.github.manuelernesto.gadsleaderboard.ui.skilliq.SkillViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AppApplication : Application(), KodeinAware {

    @RequiresApi(Build.VERSION_CODES.O)
    override val kodein = Kodein.lazy {

        import(androidXModule(this@AppApplication))

        bind() from singleton { AppAPI() }

        bind() from singleton { LearnerSkillRepository(instance()) }
        bind() from singleton { LearnerHourRepository(instance()) }

        bind() from provider { SkillViewModelFactory(instance()) }
        bind() from provider { HourViewModelFactory(instance()) }

    }
}