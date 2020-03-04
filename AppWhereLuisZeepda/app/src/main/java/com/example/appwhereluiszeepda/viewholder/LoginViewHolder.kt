package com.example.appwhereluiszeepda.viewholder

import androidx.lifecycle.MutableLiveData
import com.example.appwhereluiszeepda.responses.LoginResponse

class LoginViewHolder {
    val user: MutableLiveData<LoginResponse> by lazy {
        MutableLiveData<LoginResponse>()
    }
}