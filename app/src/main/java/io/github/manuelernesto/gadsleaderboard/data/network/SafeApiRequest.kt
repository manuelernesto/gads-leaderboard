package io.github.manuelernesto.gadsleaderboard.data.network

import io.github.manuelernesto.gadsleaderboard.util.ApiExeption
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response


abstract class SafeAPIRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()

        if (response.isSuccessful)
            return response.body()!!
        else {
            val error = response.errorBody()?.string()
            val message = StringBuilder()

            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException) {
                }
            }

            throw  ApiExeption(
                message.toString()
            )

        }

    }
}