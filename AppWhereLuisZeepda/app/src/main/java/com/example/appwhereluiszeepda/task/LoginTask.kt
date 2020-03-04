package com.example.appwhereluiszeepda.task

import com.example.appwhereluiszeepda.repository.APIService
import com.example.appwhereluiszeepda.repository.RetrofitBuilder
import com.example.appwhereluiszeepda.responses.LoginResponse

class LoginTask{
    fun loginUser(user: String, pass: String): LoginResponse {
        val call =
            RetrofitBuilder.getRetrofit().create(APIService::class.java).login(user,pass).execute()
        val user:LoginResponse
        if (call.code()!=500){
             user = call.body() as LoginResponse
        }else{
            user = LoginResponse("none",0,false,"-1")
        }
        return user
    }
}