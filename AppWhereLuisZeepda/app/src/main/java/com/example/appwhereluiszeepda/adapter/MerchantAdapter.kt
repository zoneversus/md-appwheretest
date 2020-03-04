package com.example.appwhereluiszeepda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appwhereluiszeepda.databinding.ItemMerchantBinding
import com.example.appwhereluiszeepda.model.MerchantModel

class MerchantAdapter (private val item: List<MerchantModel>): RecyclerView.Adapter<MerchantAdapter.ViewHolder> () {

    private lateinit var contexto: Context

    inner class ViewHolder (val binding: ItemMerchantBinding): RecyclerView.ViewHolder(binding.root){ // 2. debemos indicar donde se renderizara el modelo
        fun bind(merchantModel: MerchantModel){

            binding.elemento =merchantModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {  // 1. primero devemos indicar donde inflaremos la vista
        contexto = parent.context
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMerchantBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size  // indicar que regrese el tamaño de la lista

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
        }
    }
