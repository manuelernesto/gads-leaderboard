package io.github.manuelernesto.gadsleaderboard.data.network

import io.github.manuelernesto.gadsleaderboard.util.ApiExeption
import retrofit2.Response


abstract class SafeAPIRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()

        if (response.isSuccessful)
            return response.body()!!
        else
        //@todo handle api exception
            throw  ApiExeption(
                response.code().toString()
            )
    }
}