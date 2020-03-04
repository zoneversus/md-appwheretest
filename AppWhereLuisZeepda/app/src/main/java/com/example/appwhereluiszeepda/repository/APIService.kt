package com.example.appwhereluiszeepda.repository

import com.example.appwhereluiszeepda.model.MerchantModel
import com.example.appwhereluiszeepda.responses.LoginResponse
import com.example.appwhereluiszeepda.responses.MerchantResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService{
    @GET("api/session/login")
    fun login( @Query("email") email: String, @Query("password")password:String): Call<LoginResponse>
    @GET("get-merchants")
    fun getMerchant(): Call<MerchantResponse>
    @POST("register-merchant")
    fun postMerchant(@Body merchant:MerchantModel): Call<MerchantResponse>
}