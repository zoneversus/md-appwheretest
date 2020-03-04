package com.example.appwhereluiszeepda.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object{
        fun getRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl("http://166.62.33.53:4590/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}