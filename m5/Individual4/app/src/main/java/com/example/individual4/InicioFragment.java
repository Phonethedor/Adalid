package com.example.individual4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.individual4.databinding.FragmentInicioBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {


    private FragmentInicioBinding ibinding;


    public InicioFragment() {
        // Required empty public constructor
    }


    public static InicioFragment newInstance() {
        InicioFragment fragment = new InicioFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ibinding= FragmentInicioBinding.inflate(inflater,container,false);
        View view=ibinding.getRoot();

        ibinding.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ibinding.textInputnombre.getEditText().getText().toString().isEmpty()){
                    addPreguntaFragment(ibinding.textInputnombre.getEditText().getText().toString());
                }
                else {
                    ibinding.textInputnombre.setError("Ingrese su nombre");

                }
            }
        });
        return view;

    }

    private void addPreguntaFragment(String name){
        Bundle bundle=new Bundle();
        bundle.putString("clave1",name);
        Navigation.findNavController(ibinding.getRoot()).navigate(R.id.action_inicio_to_pregunta,bundle);
    }

}