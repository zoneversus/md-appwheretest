package com.example.appwhereluiszeepda.model

import com.google.gson.annotations.SerializedName

data class MerchantModel(@SerializedName("id") val id:String,
                         @SerializedName("latitude") val latitude:Double,
                         @SerializedName("longitude") val logitude:Double,
                         @SerializedName("merchantAddress") val merchantAddress:String,
                         @SerializedName("merchantName") val merchantName:String,
                         @SerializedName("merchantTelephone") val merchantTelephone:String,
                         @SerializedName("registrationDate") val registrationDate:String)