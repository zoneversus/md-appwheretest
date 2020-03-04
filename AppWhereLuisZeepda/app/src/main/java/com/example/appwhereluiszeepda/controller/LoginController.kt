package com.example.appwhereluiszeepda.controller

import androidx.lifecycle.ViewModelProviders
import com.example.appwhereluiszeepda.task.LoginTask
import com.example.appwhereluiszeepda.viewholder.LoginViewHolder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginController {
    private val task:LoginTask = LoginTask()
    private val uiScope = CoroutineScope(Dispatchers.IO)
    private var viewHolder = LoginViewHolder()

    fun doLogin(user:String,pass:String)=uiScope.launch{
        val userResponse=task.loginUser(user,pass)
        viewHolder.user.postValue(userResponse)
    }
    fun getViewHolder():LoginViewHolder{
        return viewHolder
    }
}