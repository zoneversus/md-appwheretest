package com.example.appwhereluiszeepda.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import br.com.ilhasoft.support.validation.Validator
import com.example.appwhereluiszeepda.R
import com.example.appwhereluiszeepda.controller.LoginController
import com.example.appwhereluiszeepda.databinding.ActivityLoginBinding
import com.example.appwhereluiszeepda.responses.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var controller: LoginController
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        controller= LoginController()
        val validator = Validator(binding)
        controller.getViewHolder().user.observe(this, Observer { user ->
            goMap(user) })

        login.setOnClickListener {
            if (validator.validate()){
                controller.doLogin(tvUser.text.toString(),tvPass.text.toString())
            }
        }
    }
    private fun goMap(user:LoginResponse){
        if (user.successful!!){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Hubo un problema al logearte",Toast.LENGTH_LONG).show()
        }
    }
}
