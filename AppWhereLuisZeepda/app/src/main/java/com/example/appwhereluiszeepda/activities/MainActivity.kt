package com.example.appwhereluiszeepda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.appwhereluiszeepda.R
import com.example.appwhereluiszeepda.fragment.FragmentAddUbication
import com.example.appwhereluiszeepda.fragment.FragmentMap
import com.example.appwhereluiszeepda.fragment.FragmentRvUbications
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(null == savedInstanceState) {
            bottom_navigation.selectedItemId=
                R.id.action_map
            change(R.layout.fragment_map)
        }
        init()
    }

    private fun init(){

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_map -> {
                    change(R.layout.fragment_map)
                    onToolbarName()
                }
                R.id.action_ubication ->{
                change(R.layout.fragment_rv_ubications)
                    onToolbarName()
            }
                R.id.action_add_ubication ->{
                change(R.layout.fragment_add_ubication)
                    onToolbarName()
            }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun change(id:Int){
        when(id){
            R.layout.fragment_map ->{
                val newFragment = FragmentMap()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, newFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.layout.fragment_rv_ubications ->{
            val newFragment = FragmentRvUbications()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, newFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
            R.layout.fragment_add_ubication ->{
            val newFragment = FragmentAddUbication()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, newFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
        }
        supportFragmentManager.executePendingTransactions()
        }
    private fun onToolbarName(){
        supportFragmentManager.findFragmentById(R.id.frame_layout)?.let {
            // the fragment exists
                if (it is FragmentMap) {
                    supportActionBar!!.title = "Mapa"
                }
                if (it is FragmentRvUbications) {
                    supportActionBar!!.title = "Ubicaciones"
                }
                if (it is FragmentAddUbication){
                    supportActionBar!!.title = "Agregar Ubicacion"
                }
        }
    }

    }
