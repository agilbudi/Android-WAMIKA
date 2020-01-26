package com.agilbudiprasetyo.wamika;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClick extends Fragment implements View.OnClickListener {
    TextView click;
    FrameLayout re;

    public FragmentClick() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_click, container, false);
        click = v.findViewById(R.id.text_click);
        re = v.findViewById(R.id.layout_awal);
        new CountDownTimer(2000,5000){
            @Override
            public void onTick(long l) { }

            @Override
            public void onFinish() {
                click.setText(getString(R.string.text_click));
            }
        }.start();
        re.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        MainActivity ma = (MainActivity) getActivity();
        ma.mF(R.layout.fragment_login_anggota);
    }
}
