package com.example.cl.sprintfinalm6.Presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cl.sprintfinalm6.R
import com.example.cl.sprintfinalm6.data.local.PhoneEntity
import com.example.cl.sprintfinalm6.databinding.ItemListaBinding

class Adapter: RecyclerView.Adapter<Adapter.ListaViewHolder>() {

    lateinit var  binding:  ItemListaBinding
    private val lista = mutableListOf<PhoneEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        binding = ItemListaBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val list = lista[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setData(detalle : List<PhoneEntity>){
        this.lista.clear()
        this.lista.addAll(detalle)
        notifyDataSetChanged()

    }

    class ListaViewHolder(val view: ItemListaBinding):RecyclerView.ViewHolder(view.root) {

        fun bind(detalle: PhoneEntity) {
             view.imageViewPhone.load(detalle.image)
            view.txtName.text = detalle.name
            view.txtPrice.text = "$${detalle.price}"

            view.imageViewPhone.setOnClickListener{
                val bundle = Bundle()
                val detalle = detalle.id
                bundle.putInt("id",detalle)
                Navigation.findNavController(view.root).navigate(R.id.action_LIstItems_to_detailFragment,bundle)
            }
        }
    }




}