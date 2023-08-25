package com.adalid.individual3.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.adalid.individual3.Modelo.Model.Task
import com.adalid.individual3.databinding.TaskItemBinding

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskVh>() {

    private var mlistTask= listOf<Task>()
    private val selectedTask= MutableLiveData<Task>()


    fun update(ListTask: List<Task>){
        mlistTask=ListTask
        notifyDataSetChanged()
    }

    fun selectedItem(): LiveData<Task> = selectedTask











    inner class TaskVh(private val binding:TaskItemBinding):
            RecyclerView.ViewHolder(binding.root),

            //se crea el listener aca en el viewholder
        //el listener es para toda la vista

        View.OnClickListener{
            //se hace una funcion que recibirá un task
            fun bind(task: Task){
                //se pasan los distintos elementos del task item
                binding.tvTitle.text=task.title
                binding.tvDescription.text=task.descripcion
                binding.tvDate.text=task.date
                //el checkbox se obtiene ischecked
                binding.cbState.isChecked=task.state
                binding.tvPrioridad.text=task.priority.toString()


                /**Activar el elemento click dentro de la vista
                 * le pasamos this o sea esta vista*/
                itemView.setOnClickListener(this)
            }

        //esta funcion debe implementarse por hacer el el viewholder, es por implementar viewholder
        override fun onClick(p0: View?) {
            //hacemos una funcion para leer la tarea seleccionada, se hace despues de implementar
            //los tres metodos del adapter
            //metodo deprecadoaveriguar bindingadapterposition
            selectedTask.value=mlistTask[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVh {
        //retorna el inflado acá lo hicimos en forma mas directa
        return TaskVh(TaskItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    //esta funcion se puede igualar al tamaño de la lista, sin return
    override fun getItemCount(): Int =mlistTask.size

    override fun onBindViewHolder(holder: TaskVh, position: Int) {
        val Task=mlistTask[position]
        holder.bind(Task)
    }
}