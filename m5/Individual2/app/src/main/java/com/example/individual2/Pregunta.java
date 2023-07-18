package com.example.individual2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.individual14m4.databinding.FragmentPreguntaBinding;


public class Pregunta extends Fragment {

    private FragmentPreguntaBinding binding;



    public Pregunta() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_pregunta, container, false);
        binding = FragmentPreguntaBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int index = binding.radiogroup1.indexOfChild(binding.radiogroup1.findViewById(i));
                switch (index) {

                    case 0:
                        binding.tv1.setText("Si la conozco");
                        break;

                    case 1:
                        binding.tv1.setText("No la conozco");
                        break;

                    default:
                        break;
                }
            }
        });
    }

}