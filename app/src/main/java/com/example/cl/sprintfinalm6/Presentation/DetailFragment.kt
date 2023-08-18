package com.example.cl.sprintfinalm6.Presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.cl.sprintfinalm6.databinding.FragmentDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"
private const val ARG_PARAM2 = "param2"


class DetailFragment : Fragment() {

    lateinit var  binding: FragmentDetailBinding
    private val listVIewModel:ListVIewModel by activityViewModels()
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        val id = param1
        if (id != null) {
            listVIewModel.getDetailPhone(id)

            listVIewModel.detailLiveData(id.toInt()).observe(viewLifecycleOwner){
                if(it != null) {
                    binding.imageView.load(it.image)
                    binding.txtname.text = it.name
                    binding.txtLastPrice.text = "$${it.lastPrice}"
                    binding.txtnowPrice.text = "$${it.price}"
                    binding.txtDetalle.text = it.description
                    if (it.credit){
                      binding.txtCredit.text = "Acepta Credito"

                    }else{
                        binding.txtCredit.text = "NO Acepta Credito"
                    }
                }
            }

        }

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