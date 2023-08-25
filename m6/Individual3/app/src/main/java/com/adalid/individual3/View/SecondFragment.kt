package com.adalid.individual3.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.adalid.individual3.Modelo.Model.Task
import com.adalid.individual3.R
import com.adalid.individual3.ViewModel.TaskViewModel
import com.adalid.individual3.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: TaskViewModel by activityViewModels()
    private var idTask: Int=0
    private var taskSelected: Task?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/


        viewModel.selectedItem().observe(viewLifecycleOwner,{
            it?.let {
                selectedTask->
                binding.etTitle.setText(selectedTask.title)
                binding.etDate.setText(selectedTask.date)
                binding.etDescription.setText(selectedTask.descripcion)
                binding.etPriority.setText(selectedTask.priority.toString())
                binding.cbStatenew.isChecked=selectedTask.state
                idTask=selectedTask.id
                taskSelected=selectedTask




            }
        })

        binding.btnsave.setOnClickListener {
            saveData()
            viewModel.selected(null)
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.button.setOnClickListener {
            viewModel.deleteOneTask(taskSelected)
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveData(){
        val title=binding.etTitle.text.toString()
        val description=binding.etDescription.text.toString()
        val date=binding.etDate.text.toString()
        val priority=binding.etPriority.text.toString().toInt()
        val state=binding.cbStatenew.isChecked

        if (title.isEmpty()||description.isEmpty()||date.isEmpty()){
            Toast.makeText(context,"Ingrese datos",Toast.LENGTH_LONG).show()
        }else{
            if (idTask==0){
                val newTask= Task(
                    title=title,
                    descripcion = description,
                    date= date,
                    priority = priority,
                    state=state
                )
                viewModel.insertTask(newTask)
                Toast.makeText(context,"Tarea guardada",Toast.LENGTH_LONG).show()
            }else{
                val newTask1= Task(
                    id= idTask,
                    title=title,
                    descripcion = description,
                    date= date,
                    priority = priority,
                    state=state
                )
                viewModel.updateTask(newTask1)
                Toast.makeText(context,"Tarea actualizada",Toast.LENGTH_LONG).show()

            }
        }


    }
}