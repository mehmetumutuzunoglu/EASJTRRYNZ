package com.mehmetumutuzunoglu.easjtrrynz.base.model

import com.google.gson.annotations.SerializedName

data class TvShowDetailResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("poster_path")
    val imageUrl: String?,

    @SerializedName("backdrop_path")
    val backdropImageUrl: String?,

    @SerializedName("vote_average")
    val voteAverage: Double?
)