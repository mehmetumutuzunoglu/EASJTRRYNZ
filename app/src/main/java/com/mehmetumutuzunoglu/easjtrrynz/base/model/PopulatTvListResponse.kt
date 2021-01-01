package com.mehmetumutuzunoglu.easjtrrynz.base.model

import com.google.gson.annotations.SerializedName

data class PopularTvListResponse(
    @SerializedName("page")
    val page: Int?,

    @SerializedName("results")
    val results: List<TvData>?,

    @SerializedName("total_pages")
    val totalPages: Int?,

    @SerializedName("total_results")
    val totalResults: Int?
)

data class TvData(
    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("first_air_date")
    val firstAirDate: String?,

    @SerializedName("original_name")
    val originalName: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("vote_average")
    val voteAverage: Double?,

    @SerializedName("vote_count")
    val voteCount: Int?
)