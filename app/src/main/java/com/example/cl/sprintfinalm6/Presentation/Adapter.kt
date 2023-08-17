package com.example.cl.sprintfinalm6.Presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cl.sprintfinalm6.databinding.ItemListaBinding

class Adapter: RecyclerView.Adapter<Adapter.ListaViewHolder>() {

    lateinit var  binding:  ItemListaBinding
    private val lista = mutableListOf<String>()


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

    fun setData(detalle : List<String>){
        this.lista.clear()
        this.lista.addAll(detalle)
        notifyDataSetChanged()

    }

    class ListaViewHolder(val view: ItemListaBinding):RecyclerView.ViewHolder(view.root) {

        fun bind(detalle: String) {

        }
    }




}