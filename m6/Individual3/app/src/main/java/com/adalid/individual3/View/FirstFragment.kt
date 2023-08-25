package com.adalid.individual3.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.adalid.individual3.Modelo.Model.Task
import com.adalid.individual3.R
import com.adalid.individual3.ViewModel.TaskViewModel
import com.adalid.individual3.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 * Acá es donde estarán las instancias de lo creado anteriormente.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/

        binding.fab2.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val adapter=TaskAdapter()
        binding.rvTask.adapter= adapter
        binding.rvTask.layoutManager=LinearLayoutManager(context)

        binding.rvTask.addItemDecoration(
        DividerItemDecoration(
            context,
            DividerItemDecoration.VERTICAL
        )
        )

        viewModel.allTask.observe(viewLifecycleOwner,{

            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedItem().observe(viewLifecycleOwner,{
            it?.let {
                viewModel.selected(it)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

            }
        })

        binding.btDeleteAll.setOnClickListener {
            viewModel.deleteAllTask()
        }







    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}