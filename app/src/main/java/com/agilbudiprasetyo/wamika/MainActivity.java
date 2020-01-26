package com.agilbudiprasetyo.wamika;

import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static final String SOME_VALUE = "int_value";
    static final String SOME_OTHER_VALUE = "string_value";
    ImageView imgBG;
    TransitionDrawable trans1;
    TransitionDrawable trans2;
    TransitionDrawable trans3;
    TransitionDrawable trans4;
    FragmentManager manager = getSupportFragmentManager();
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = this.getResources();

        imgBG = findViewById(R.id.imgBG);
        trans1 = (TransitionDrawable) res.getDrawable(R.drawable.transisi1);
        trans2 = (TransitionDrawable) res.getDrawable(R.drawable.transisi2);
        trans3 = (TransitionDrawable) res.getDrawable(R.drawable.transisi3);
        trans4 = (TransitionDrawable) res.getDrawable(R.drawable.transisi4);
        bgTransisi();
        Fragment fClick = new FragmentClick();
        //bisa gunakan ini : getSupportFragmentManager().beginTransaction().add(R.id.container,fClick).commit();
        manager.beginTransaction().add(R.id.container,fClick).commit();
        //imgBG.setOnClickListener(this);
    }

    private void bgTransisi() {
        new CountDownTimer(8000, 7000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                repeat();
            }

        }.start();
    }
    private void repeat() {
        new CountDownTimer(8000, 7000) {
            public void onTick(long l) { }

            public void onFinish() {
                imgBG.setImageDrawable(trans1);
                trans1.startTransition(5000);

                new CountDownTimer(8000, 7000) {
                    public void onTick(long l) { }

                    public void onFinish() {
                        imgBG.setImageDrawable(trans2);
                        trans2.startTransition(5000);

                        new CountDownTimer(8000, 7000) {
                            public void onTick(long l) { }

                            public void onFinish() {
                                imgBG.setImageDrawable(trans3);
                                trans3.startTransition(5000);

                                new CountDownTimer(8000,7000){
                                    public void onTick(long l) { }

                                    public void onFinish() {
                                        imgBG.setImageDrawable(trans4);
                                        trans4.startTransition(5000);
                                        repeat();
                                    }
                                }.start();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();
    }


    public void mF(int sebagai) {
        FragmentTransaction transaction;
        switch (sebagai){
            case R.layout.fragment_login_anggota:
                LoginAnggota la = new LoginAnggota();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.container, la);
                transaction.commit();
                break;
            case R.layout.fragment_login_pengurus:
                LoginPengurus lp = new LoginPengurus();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.container, lp);
                transaction.commit();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        //savedInstanceState.putInt(SOME_VALUE,R.layout.fragment_login_anggota);
        super.onSaveInstanceState(savedInstanceState);
    }
}
