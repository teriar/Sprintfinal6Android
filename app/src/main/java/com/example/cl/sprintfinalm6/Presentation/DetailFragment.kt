package com.example.cl.sprintfinalm6.Presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cl.sprintfinalm6.databinding.FragmentDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DetailFragment : Fragment() {

    lateinit var  binding: FragmentDetailBinding
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
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        initListener()
        return binding.root

    }

    private fun initListener() {
        val mensaje = "Hola " +
                "Vi la propiedad {produc_name} id {product_id} y me gustaria que me contactaran a este correo" +
                "o al siguiente numero 97978869" +
                "Quedo atento."
        binding.btnContactar.setOnClickListener{

            var intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,
            arrayOf("felipegonzalezurr@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta {Product_name} id {Product_ID}")
            intent.putExtra(Intent.EXTRA_TEXT, mensaje)


            // Lanzo el selector de cliente de Correo
            startActivity(
                Intent
                    .createChooser(
                        intent,
                        "Elije un cliente de Correo:"
                    )
            )
        }
    }

}