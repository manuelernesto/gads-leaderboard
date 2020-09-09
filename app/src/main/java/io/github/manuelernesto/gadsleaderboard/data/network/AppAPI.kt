package io.github.manuelernesto.gadsleaderboard.data.network

import androidx.lifecycle.LiveData
import io.github.manuelernesto.gadsleaderboard.data.model.LearnerHour
import io.github.manuelernesto.gadsleaderboard.data.model.LearnerSkill
import io.github.manuelernesto.gadsleaderboard.util.BASE_URL
import io.github.manuelernesto.gadsleaderboard.util.HOUR_URL
import io.github.manuelernesto.gadsleaderboard.util.NetworkConnectionInterceptor
import io.github.manuelernesto.gadsleaderboard.util.SKILLIQ_URL
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppAPI {


    //get all learners per hour
    @GET(HOUR_URL)
    suspend fun getLearnerPerHour(): LiveData<LearnerHour>

    //get all learners per hour
    @GET(SKILLIQ_URL)
    suspend fun getLearnerPerSkillIQ(): LiveData<LearnerSkill>


    companion object {

        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): AppAPI {

            val okkHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit
                .Builder()
                .client(okkHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AppAPI::class.java)
        }
    }
}