package com.agilbudiprasetyo.wamika;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginAnggota extends Fragment {
    TextView sebagaiA, lupaA;
    EditText noAnggotaA,namaA,passwordA;
    Button loginA;


    public LoginAnggota() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login_anggota, container, false);
        sebagaiA = v.findViewById(R.id.tv_sebagai_anggota);
        lupaA = v.findViewById(R.id.tv_Lupa_anggota);


        lupaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity) getActivity();
                ma.mF(R.layout.fragment_login_anggota);//fragment tujuan
            }
        });
        sebagaiA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity) getActivity();
                ma.mF(R.layout.fragment_login_pengurus);//fragment tujuan
            }
        });
        return v;
    }
}
