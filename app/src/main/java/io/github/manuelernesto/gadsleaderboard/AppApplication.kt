package io.github.manuelernesto.gadsleaderboard

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi

class AppApplication : Application(), KodeinAware {

    @RequiresApi(Build.VERSION_CODES.O)
    override val kodein = Kodein.lazy {

        import(androidXModule(this@AppApplication))

    }
}