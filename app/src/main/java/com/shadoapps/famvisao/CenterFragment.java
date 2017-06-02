package com.shadoapps.famvisao;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CenterFragment extends Fragment {
    public CenterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragView = inflater.inflate(R.layout.fragment_center, container, false); //temp view for method application
        final Button btn_criar = (Button) fragView.findViewById(R.id.btn_criar);
        final Button btn_mapa= (Button) fragView.findViewById(R.id.btn_mapa);

        btn_criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Submeter= new Intent(getActivity(), CreateEventActivity.class);
                CenterFragment.this.startActivity(Submeter);
            }
        });
        btn_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Mapa= new Intent(getActivity(), MapsActivity.class);
                CenterFragment.this.startActivity(Mapa);
            }
        });


        return fragView;
    }


}
