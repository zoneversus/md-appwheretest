package com.example.appwhereluiszeepda.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LayoutAnimationController
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ilhasoft.support.validation.Validator
import com.example.appwhereluiszeepda.R
import com.example.appwhereluiszeepda.controller.MerchantController
import com.example.appwhereluiszeepda.databinding.FragmentAddUbicationBinding
import com.example.appwhereluiszeepda.model.MerchantModel
import com.example.appwhereluiszeepda.responses.MerchantResponse
import kotlinx.android.synthetic.main.fragment_add_ubication.*

class FragmentAddUbication : Fragment() {
    private var controller=MerchantController()
    private lateinit var binding: FragmentAddUbicationBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val validator = Validator(binding)
        saveLocation.setOnClickListener {
            if (validator.validate()){
                val merchant = MerchantModel("",tvLatitude.text.toString().toDouble(),
                    tvLogitude.text.toString().toDouble(),
                    tvDireccion.text.toString(),
                    tvName.text.toString(),
                    tvPhone.text.toString(),
                    "")
                controller.postMerchant(merchant)
            }
            controller.getViewHolder().merchants.observe(viewLifecycleOwner, Observer { pubList ->
                updateUI(pubList) })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add_ubication, container, false)
        return binding.root
    }

    private fun updateUI(merchantResponse:MerchantResponse){
        if (merchantResponse.status==1){
            tvLatitude.text!!.clear()
            tvLogitude.text!!.clear()
            tvDireccion.text!!.clear()
            tvName.text!!.clear()
            tvPhone.text!!.clear()
            Toast.makeText(context,"Locacion Registrada con exito",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Hubo un problema al registrar",Toast.LENGTH_LONG).show()
        }
    }

}

