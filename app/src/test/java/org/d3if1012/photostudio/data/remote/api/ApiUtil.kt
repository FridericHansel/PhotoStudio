package org.d3if1012.photostudio.data.remote.api

import org.d3if1012.photostudio.data.remote.ApiResponse
import retrofit2.Response

object ApiUtil {

    fun <T : Any> successCall(data: T) = createCall(Response.success(data))

    fun <T : Any> createCall(response: Response<T>): ApiResponse<T> =
        ApiResponse.create(200..229, response)
}
