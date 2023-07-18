package com.example.individual15

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.individual15.databinding.ShoelistviewBinding


class ShoeAdapter(private val dataSet: List<Shoe>, val esvisible:Boolean): RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // infla la vista
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        //retornamos el viewholder, inflamos el xml donde estan los elementos a traves de la clase R
        return ShoeAdapter.ViewHolder(layoutInflater.inflate(R.layout.shoelistview,parent,false))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //declaramos una variable para guardar la posicion
        val elemento: Shoe=dataSet[position]
        holder.bind(elemento, esvisible)

    }



    // Se crea clase interna viewholder
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //se declara el binding del xml donde estan los elementos y asigna como vista
        private val binding = ShoelistviewBinding.bind(view)

        //funcion para llenar los elementos, llamamos todos los elementos de la
        //clase zapato

        fun bind(zapato: Shoe, esvisible: Boolean){
            binding.tvnombre.text=zapato.nombre
            binding.tvdescripcion.text=zapato.descripcion
            binding.tvprecio.text=zapato.precio
            //aca usamos Glide
            Glide.with(binding.imageshoelist).load(zapato.urlfoto).into(binding.imageshoelist)
            //hago binding al boton

            if (esvisible){
                binding.botoncarro.visibility=View.VISIBLE
            }



        }


    }

}


   /* class Viewholder(shoelistviewBinding: ShoelistviewBinding): RecyclerView.ViewHolder(shoelistviewBinding.root) {
        val tvnombre: TextView
        val tvdescripcion: TextView
        val tvprecio: TextView
        val imagen: ImageView


        init {

            tvnombre= shoelistviewBinding.tvnombre
            tvdescripcion=shoelistviewBinding.tvdescripcion
            tvprecio=shoelistviewBinding.tvprecio
            imagen=shoelistviewBinding.imageshoelist

        }

    }
*/
