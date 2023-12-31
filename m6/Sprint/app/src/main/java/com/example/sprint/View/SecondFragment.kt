package com.example.sprint.View

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.sprint.R
import com.example.sprint.ViewModel.PhoneViewModel
import com.example.sprint.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PhoneViewModel by activityViewModels()
    private var phoneId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater,container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { bundle ->
            phoneId = bundle.getString("phoneid")
            Log.d("***LO RECIBO??***", phoneId.toString())
        }

        phoneId?.let { id ->
            viewModel.getPhoneDetailByIdFromInternet(id)
        }

        viewModel.getPhoneDetail().observe(viewLifecycleOwner, Observer {

            Glide.with(binding.imageView2).load(it.image).into(binding.imageView2)
            binding.id.text = "ID Producto          : " + it.id
            binding.name.text = "Nombre Celular   : " + it.name
            binding.price.text = "Precio                    : $" + it.price.toString()
            binding.description.text = "Descripción          : " + it.description
            binding.lastprice.text = "Precio Final           : $" + it.lastPrice.toString()


            if (it.credit == true) {
                binding.credit.text = "Tipo de Pago        : Acepta Crédito"
            } else {
                binding.credit.text = "Tipo de Pago        : Sólo Efectivo"
            }

            var name = it.name
            var code = it.id.toString()

            binding.btfab.setOnClickListener {

                val intent = Intent(Intent.ACTION_SEND)
                intent.data = Uri.parse("mailto")
                intent.type = "text/plain"

                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("info@novaera.cl"))
                intent.putExtra(
                    Intent.EXTRA_SUBJECT,
                    "Consulta " + name + "id" + code
                )
                intent.putExtra(
                    Intent.EXTRA_TEXT, "Hola\n" +
                            "Vi el teléfono " + name + " de código: " + code + ",\n" +
                            "Me gustaría que me contactaran a este correo o al siguiente número:___________\n" +
                            "Quedo atento"
                )
                startActivity(intent)
            }
        })

       binding.btvolver.setOnClickListener {
          findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
