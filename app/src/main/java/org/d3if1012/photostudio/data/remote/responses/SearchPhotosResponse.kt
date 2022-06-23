package org.d3if1012.photostudio.data.remote.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.d3if1012.photostudio.model.PhotoModel

data class SearchPhotosResponse(
    @Expose @SerializedName("total") val total: Int,
    @Expose @SerializedName("total_pages") val totalPages: Int,
    @Expose @SerializedName("results") val photosList: List<PhotoModel>
)
