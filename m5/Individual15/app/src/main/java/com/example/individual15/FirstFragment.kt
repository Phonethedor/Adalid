package com.example.individual15

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.individual15.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    fun returnShoeList(): List<Shoe> {
        val shoeList = mutableListOf<Shoe>()

        val shoeItem1 = Shoe(
            "Nike Air Force 1 07 LV8",
            "Zapatillas para Hombre",
            "$126.990",
            "https://nikeclprod.vteximg.com.br/arquivos/ids/724801-1000-1000/DZ2522_001_A_PREM.jpg?v=638241065888000000"
        )
        shoeList.add(shoeItem1)
        val shoeItem2 = Shoe(
            "Nike Air Max 90",
            "Zapatillas para Mujer",
            "$144.990",
            "https://nikeclprod.vteximg.com.br/arquivos/ids/725077-1000-1000/FB2617_100_A_PREM.jpg?v=638241069163600000"
        )
        shoeList.add(shoeItem2)

        val shoeItem3 = Shoe(
            "Nike Dunk Low Retro",
            "Zapatillas para Hombre",
            "$106.990",
            "https://nikeclprod.vteximg.com.br/arquivos/ids/156208-1000-1000/DD1391_100_A.jpg?v=637654333983500000"
        )
        shoeList.add(shoeItem3)

        val shoeItem4 = Shoe(
            "Air Jordan 1 Mid",
            "Zapatillas para Mujer",
            "$129.990",
            "https://nikeclprod.vteximg.com.br/arquivos/ids/720745-1000-1000/BQ6472_060_A_PREM.jpg?v=638241017225570000"
        )
        shoeList.add(shoeItem4)

        val shoeItem5 = Shoe(
            "Nike Air Force 1 LX",
            "Zapatillas para Mujer",
            "$132.990",
            "https://nikeclprod.vteximg.com.br/arquivos/ids/724894-1000-1000/DZ2789_200_A_PREM.jpg?v=638241066984300000"
        )
        shoeList.add(shoeItem5)






        return shoeList
    }

    //TODO setear el adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // creamos una variable de tipo adapter del tipo shoeadapter y retornamos el metodo que
        //entrega los datos al adaotes
        val adapter = ShoeAdapter(returnShoeList(), esvisible = false)
        //seteamos el adapter al recycler view
        binding.recyclerview1.adapter = adapter
        //al recycler le damos un linear layout
        binding.recyclerview1.layoutManager = LinearLayoutManager(context)
        //que sean del mismo tamaño
        binding.recyclerview1.setHasFixedSize(true)






       // binding.buttonFirst.setOnClickListener {
         //   findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        //}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}