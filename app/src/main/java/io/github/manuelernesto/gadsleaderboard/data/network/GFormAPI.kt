package io.github.manuelernesto.gadsleaderboard.data.network


import io.github.manuelernesto.gadsleaderboard.util.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GFormAPI {


    //save data to Google form
    @FormUrlEncoded
    @POST(FORM_ID)
    suspend fun saveForm(
        @Field(ENTRY_FIRST_NAME) firstName: String,
        @Field(ENTRY_LAST_NAME) lastName: String,
        @Field(ENTRY_EMAIL) email: String,
        @Field(ENTRY_LINK) link: String
    ): Response<Unit>


    companion object {

        operator fun invoke(): GFormAPI {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(FORM_BASE_URL)
                .build()
                .create(GFormAPI::class.java)
        }
    }
}