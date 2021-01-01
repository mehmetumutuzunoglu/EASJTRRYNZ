package com.mehmetumutuzunoglu.easjtrrynz.base


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = "8b07fc2a131e6ad93153e02a8909d636"

        private var retrofit: Retrofit? = null

        fun getRetrofitClient(): ApiService? {
            if (retrofit == null) {

                val okHttpClientBuilder = OkHttpClient.Builder()
                okHttpClientBuilder.addInterceptor { chain ->
                    val original = chain.request()
                    val originalUrl = original.url()
                    val url = originalUrl.newBuilder()
                        .addQueryParameter("api_key", API_KEY)
                        .build()
                    val requestBuilder = original.newBuilder().url(url)
                    val request = requestBuilder.build()
                    chain.proceed(request)
                }

                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClientBuilder.build())
                    .build()
            }
            return retrofit?.create(ApiService::class.java)
        }

    }
}