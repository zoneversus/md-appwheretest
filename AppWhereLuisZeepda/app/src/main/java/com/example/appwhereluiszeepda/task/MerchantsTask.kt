package com.example.appwhereluiszeepda.task

import com.example.appwhereluiszeepda.model.MerchantModel
import com.example.appwhereluiszeepda.repository.APIService
import com.example.appwhereluiszeepda.repository.RetrofitBuilder
import com.example.appwhereluiszeepda.responses.MerchantResponse

class MerchantsTask {
    fun getMerchant(): MerchantResponse {
        val call =
            RetrofitBuilder.getRetrofit().create(APIService::class.java).getMerchant().execute()
        val merchant = call.body() as MerchantResponse
        return merchant
    }
    fun postMerchant(merchant:MerchantModel): MerchantResponse {
        val call =
            RetrofitBuilder.getRetrofit().create(APIService::class.java).postMerchant(merchant).execute()
        return call.body() as MerchantResponse
    }
}