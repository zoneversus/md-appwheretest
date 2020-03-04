package com.example.appwhereluiszeepda.controller

import com.example.appwhereluiszeepda.model.MerchantModel
import com.example.appwhereluiszeepda.task.LoginTask
import com.example.appwhereluiszeepda.task.MerchantsTask
import com.example.appwhereluiszeepda.viewholder.LoginViewHolder
import com.example.appwhereluiszeepda.viewholder.MerchantViewHolder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MerchantController {
    private val task: MerchantsTask = MerchantsTask()
    private val uiScope = CoroutineScope(Dispatchers.IO)
    private var viewHolder = MerchantViewHolder()

    fun getMerchant()=uiScope.launch{
        val merchants=task.getMerchant()
        viewHolder.merchants.postValue(merchants)
    }
    fun postMerchant(merchant:MerchantModel)=uiScope.launch{
        val merchants=task.postMerchant(merchant)
        viewHolder.merchants.postValue(merchants)
    }
    fun getViewHolder():MerchantViewHolder{
        return viewHolder
    }
}