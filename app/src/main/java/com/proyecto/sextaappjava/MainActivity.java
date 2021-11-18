package com.proyecto.sextaappjava;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int op=0;
    LinearLayout CONTE;
    Fragment FRAG;
    Button B1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CONTE=(LinearLayout)findViewById(R.id.contenedor);
        CONTE.setVisibility(View.INVISIBLE);
        B1=(Button)findViewById(R.id.b1);
    }


    public void metodoPolitica(View view) {
        switch (op)
        {
            case 0:
                CONTE.setVisibility(View.VISIBLE);
                FRAG=new fragmento1();
                op=1;
                cargarFragmento(FRAG);
                break;
            case 1:
                FRAG=new fragmento2();
                op=2;
                cargarFragmento(FRAG);
                break;
            case 2:
                CONTE.setVisibility(View.INVISIBLE);
                op=0;
                break;

        }
    }

    private void cargarFragmento(Fragment frag) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fragment,frag);
        transaction.commit();
    }
}
