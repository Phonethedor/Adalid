package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.individual15m4.R;
import com.example.individual15m4.databinding.FragmentPreguntaBinding;


public class PreguntaFragment extends Fragment {

    private FragmentPreguntaBinding pbinding;


    private static final String ARG_PARAM1 = "clave1";
    //private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    //private String mParam2;

    public PreguntaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pregunta.
     */
    // TODO: Rename and change types and number of parameters
    public static PreguntaFragment newInstance(String param1, String param2) {
        PreguntaFragment fragment = new PreguntaFragment();
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
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        pbinding= FragmentPreguntaBinding.inflate(inflater,container,false);
        View view=pbinding.getRoot();

        String saludo=getString(R.string.saludo,mParam1);
        pbinding.tvsaludo.setText(saludo);



        pbinding.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int index=pbinding.radiogroup.indexOfChild(pbinding.radiogroup.findViewById(i));
                switch (index){
                    case 0:
                        enviarstring(mParam1);
                        break;

                    case 1:
                        enviarstring(mParam1);
                        break;

                    case 2:
                        enviarcorrecta(mParam1);
                        break;

                    case 3:
                        enviarstring(mParam1);
                        break;

                    default:
                        break;
                }

            }
        });

        return view;


    }

    private void enviarstring(String mParam1){
        Bundle bundle= new Bundle();
        bundle.putString("clave1",mParam1);
        Navigation.findNavController(pbinding.getRoot()).navigate(R.id.action_pregunta_to_respuestaEquivocada,bundle);

    }

    private void enviarcorrecta(String mParam1){
        Bundle bundle=new Bundle();
        bundle.putString("clave1",mParam1);
        Navigation.findNavController(pbinding.getRoot()).navigate(R.id.action_pregunta_to_respuestaCorrectaFragment,bundle);
    }



}