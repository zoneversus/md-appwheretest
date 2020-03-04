package com.example.appwhereluiszeepda.viewholder

import androidx.lifecycle.MutableLiveData
import com.example.appwhereluiszeepda.model.MerchantModel
import com.example.appwhereluiszeepda.responses.LoginResponse
import com.example.appwhereluiszeepda.responses.MerchantResponse

class MerchantViewHolder {
    val merchants: MutableLiveData<MerchantResponse> by lazy {
        MutableLiveData<MerchantResponse>()
    }
}