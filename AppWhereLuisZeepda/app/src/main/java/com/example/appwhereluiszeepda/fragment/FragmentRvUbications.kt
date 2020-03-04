package com.example.appwhereluiszeepda.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appwhereluiszeepda.R
import com.example.appwhereluiszeepda.adapter.MerchantAdapter
import com.example.appwhereluiszeepda.controller.MerchantController
import com.example.appwhereluiszeepda.model.MerchantModel
import kotlinx.android.synthetic.main.fragment_rv_ubications.*

class FragmentRvUbications : Fragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var controller: MerchantController
    private lateinit var animation : LayoutAnimationController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      init()
        //behavior when publications list its updated
       controller.getViewHolder().merchants.observe(viewLifecycleOwner, Observer { pubList ->
           updateUI(pubList.merchants) })
      controller.getMerchant()

    }

    private fun init(){
        //Controller is the mediator, where you can get you publications with the backend
        controller = MerchantController()
        //Here you declare the animation that will be assigned to the recyclerview
        animation = AnimationUtils.loadLayoutAnimation(context, R.anim.layaout_animation)
        rvMerchant.layoutAnimation=animation
        //This 2 lines of code assign the kind of display that the rv will be following could be linear, grid, etc.
        linearLayoutManager = LinearLayoutManager(context)
        rvMerchant.layoutManager = linearLayoutManager
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_rv_ubications, container, false)
    }

    fun updateUI(merchants:List<MerchantModel>) {
        rvMerchant.adapter = MerchantAdapter(merchants)
        rvMerchant.scheduleLayoutAnimation()
    }
}
