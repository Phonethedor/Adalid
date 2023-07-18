package com.example.individual16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.example.individual16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        val paises = listOf(
            Pais("País 1", "100 millones"),
            Pais("País 2", "200 millones"),
            Pais("País 3", "300 millones"),
            Pais("País 4", "400 millones"),
            Pais("País 5", "500 millones"),
            Pais("País 6", "600 millones"),
            Pais("País 7", "700 millones"),
            Pais("País 8", "800 millones"),
            Pais("País 9", "900 millones")
        )

        val adapter = Adapter(paises)
        binding.listview.adapter= adapter

        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val pais = paises[position]
            val texto = "${pais.nombre} tiene ${pais.poblacion} habitantes"
            binding.textView.text = texto
        }
    }
}





