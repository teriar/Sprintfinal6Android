package com.example.cl.sprintfinalm6.Presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.cl.sprintfinalm6.R
import com.example.cl.sprintfinalm6.databinding.FragmentListItemsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LIstItems : Fragment() {

    lateinit var binding: FragmentListItemsBinding
    private val listVIewModel:ListVIewModel by activityViewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListItemsBinding.inflate(layoutInflater,container,false)

        initAdapter()
        listVIewModel.getDataPhones()

        return binding.root
    }

    private fun initAdapter() {
        val adapter = Adapter()
        listVIewModel.phoneLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
        binding.recyclerView.adapter = adapter

    }

}