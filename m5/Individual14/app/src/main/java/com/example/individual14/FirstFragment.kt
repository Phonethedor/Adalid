package com.example.individual14

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.individual14.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var monto: Int = 0
    private var ingreso: Int = 0
    private var giro: Int = 0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvsaldo.text = monto.toString()

        binding.btingresar.setOnClickListener {

            var ingresotext = binding.edingresar.text.toString()
            var ingreso = ingresotext.toIntOrNull()
            if (ingreso != null) {
                monto += ingreso
                binding.tvsaldo.text = monto.toString()
                binding.edingresar.text?.clear()
            } else {
                binding.tfingresar.error = "Ingrese un valor ´valido"
            }
        }

        binding.btgirar.setOnClickListener {
            val giroText = binding.tfgirar.editText?.text.toString()
            val giro = giroText.toIntOrNull()
            if (giro != null) {
                if (giro <= monto) {
                    monto -= giro
                    binding.tvsaldo.text = monto.toString()
                    binding.tfgirar.editText?.text?.clear()
                } else {
                    binding.tfgirar.error = " No hay saldo suficiente"
                }
            } else {
                binding.tfgirar.error = "Ingrese un valor"
            }


        }

        binding.btsalir.setOnClickListener{
            requireActivity().finishAffinity()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}