package com.example.prjlibraryjetpack

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import kotlin.getValue

interface apiService {
    //get method that pulls poem titles from the api
    @GET("/titles")
    suspend fun getTitles(): TitleResponse //response class handles data pulled from api

    //get method to pull specific poem from api based on its title
    @GET("/title/{title}")
    suspend fun getPoem(@Path("title") title: String): PoemResponse //response class handle data pulled for individual poem details

}


//I think it is because you were missing this object

object RetrofitClient{
    private const val BASE_URL = "https://poetrydb.org";//"https://opsc.azurewebsites.net/"

    val instance: apiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(apiService::class.java)

    }
}