package com.example.appwhereluiszeepda.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse (@SerializedName("description") val description:String?,
                          @SerializedName("status") val status:Int?,
                          @SerializedName("successful") val successful:Boolean?,
                          @SerializedName("userId") val id:String?)