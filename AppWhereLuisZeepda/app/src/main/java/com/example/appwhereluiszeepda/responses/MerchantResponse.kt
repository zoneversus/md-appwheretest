package com.example.appwhereluiszeepda.responses

import com.example.appwhereluiszeepda.model.MerchantModel
import com.google.gson.annotations.SerializedName

data class MerchantResponse(
    @SerializedName("description") val id:String,
    @SerializedName("merchants") val merchants:ArrayList<MerchantModel>,
    @SerializedName("status") val status:Int
)