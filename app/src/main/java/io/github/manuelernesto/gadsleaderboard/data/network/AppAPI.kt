package io.github.manuelernesto.gadsleaderboard.data.network


import io.github.manuelernesto.gadsleaderboard.data.model.Learner
import io.github.manuelernesto.gadsleaderboard.util.BASE_URL
import io.github.manuelernesto.gadsleaderboard.util.HOUR_URL
import io.github.manuelernesto.gadsleaderboard.util.SKILLIQ_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AppAPI {


    //get all learners per hour
    @GET(HOUR_URL)
    suspend fun getLearnerPerHour(): Response<List<Learner>>

    //get all learners per hour
    @GET(SKILLIQ_URL)
    suspend fun getLearnerPerSkillIQ(): Response<List<Learner>>

    companion object {

        operator fun invoke(): AppAPI {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(AppAPI::class.java)
        }
    }
}