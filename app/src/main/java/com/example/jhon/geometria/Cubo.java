package com.example.jhon.geometria;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Jhon on 1/10/2017.
 */

public class Cubo extends AppCompatActivity {
    private Resources resources;
    private EditText lado;
    private Intent in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);
        lado = (EditText)findViewById(R.id.txtValorLadoCubo);
        resources = this.getResources();


    }

    public void calcularVolumenCubo(View view){
        String ladoaux;
        if(validar()){

            ladoaux = lado.getText().toString();
            double val=Double.parseDouble(""+ladoaux);
            val=Math.pow(val,3);
            //almacenamos la operacion
            Operacion o = new Operacion(resources.getString(R.string.volumenDelCubo),resources.getString(R.string.lado)+": "+ladoaux,""+val);
            o.guardar();
            in= new Intent(Cubo.this,CuboResultado.class);
            in.putExtra("VolumenCubo", val);
            startActivity(in);

        }

    }
    public void limpiar(View view){
        lado.setText("");
        lado.requestFocus();

    }

    public boolean validar(){
        boolean r=true;

        lado = (EditText)findViewById(R.id.txtValorLadoCubo);
        String x =lado.getText().toString();

        if(x.isEmpty()||lado.getText().toString().trim().isEmpty()){
            lado.setError(resources.getString(R.string.mensaje_error_uno));
            lado.setText("");
            lado.requestFocus();
            return false;
        }

        return r;
    }
}