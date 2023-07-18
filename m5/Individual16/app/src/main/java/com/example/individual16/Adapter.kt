package com.example.individual16

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.individual16.databinding.ItemlistBinding



    class Adapter(private val items: List<Pais>) : BaseAdapter() {
        private lateinit var binding: ItemlistBinding
        override fun getCount(): Int {
            return items.size
        }

        override fun getItem(p0: Int): Any {
            return items[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val binding: ItemlistBinding
            val view: View

            if (convertView == null) {
                val inflater = LayoutInflater.from(parent?.context)
                binding = ItemlistBinding.inflate(inflater, parent, false)
                view = binding.root
                view.tag = binding
            } else {
                view = convertView
                binding = view.tag as ItemlistBinding
            }

            val pais = getItem(position) as Pais
            binding.textView2.text = pais.nombre

            return view
        }

    }

