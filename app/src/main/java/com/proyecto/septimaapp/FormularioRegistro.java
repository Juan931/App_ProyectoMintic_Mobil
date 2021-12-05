package com.proyecto.septimaapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FormularioRegistro extends AppCompatActivity {
    int op=0;
    LinearLayout CONTE;
    Fragment FRAG;
    Button B1,B2;
    EditText E1,E2,E3;
    TextView T1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro);
        CONTE=(LinearLayout)findViewById(R.id.contenedor);
        CONTE.setVisibility(View.INVISIBLE);
        B1=(Button)findViewById(R.id.b1);
        B2=(Button)findViewById(R.id.b2);
        E1=(EditText) findViewById(R.id.e1);
        E2=(EditText) findViewById(R.id.e2);
        E3=(EditText) findViewById(R.id.e3);
        T1=(TextView) findViewById(R.id.t1);
    }
    public void metodoPolitica(View view) {
        switch (op)
        {
            case 0:
                CONTE.setVisibility(View.VISIBLE);
                FRAG=new Fragmento1();
                op=1;
                cargarFragmento(FRAG);
                break;
            case 1:
                FRAG=new Fragmento2();
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

    public void guardarDatos(View view) {
        String nombre, apellido,telefono;
        int v1,v2,v3;
        //Lectura
        nombre=E1.getText().toString();
        apellido=E2.getText().toString();
        telefono=E3.getText().toString();
        //validacion
        v1=validarDatos(1,nombre);
        v2=validarDatos(1,apellido);
        v3=validarDatos(2,telefono);
        if (v1!=1 || v2!=1 || v3!=1){

            T1.setText("error");
        }
        else{
            T1.setText("ok");
        }
        //almacenamiento
    }

    private int validarDatos(int i, String cadena) {
        int  validacion =1,c,pos;
        switch (i){
            case 1:
                for (pos=0; pos < cadena.length(); pos=pos+1){
                    c=cadena.charAt(pos);
                    if (c<67||c>90){
                        validacion=0;
                        pos=cadena.length();
                    }
                }
                break;

            case 2:
                for (pos=0; pos < cadena.length(); pos=pos+1){
                    c=cadena.charAt(pos);
                    if (c<48||c>57){
                        validacion=0;
                        pos=cadena.length();
                    }
                }
                break;
        }
        return validacion;
    }

}