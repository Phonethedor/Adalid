package com.example.individual4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.individual4.databinding.FragmentRespuestaCorrectaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RespuestaCorrectaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RespuestaCorrectaFragment extends Fragment {

    private FragmentRespuestaCorrectaBinding cbinding;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "clave1";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RespuestaCorrectaFragment() {
        // Required empty public constructor
    }


    public static RespuestaCorrectaFragment newInstance(String param1) {
        RespuestaCorrectaFragment fragment = new RespuestaCorrectaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        cbinding= FragmentRespuestaCorrectaBinding.inflate(inflater,container,false);
        View view=cbinding.getRoot();

        String llenar=getString(R.string.bien,mParam1);
        cbinding.tvcorrecto.setText(llenar);

        cbinding.btdenuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(cbinding.getRoot()).navigate(R.id.action_respuestaCorrectaFragment_to_inicio);
            }
        });

        return view;


    }
}