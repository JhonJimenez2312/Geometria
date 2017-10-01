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

public class Esfera extends AppCompatActivity {
    private Resources resources;
    private EditText lado;
    private Intent in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);
        lado = (EditText)findViewById(R.id.txtValorRadioEsfera);
        resources = this.getResources();


    }

    public void calcularVolumenEsfera(View view){
        String ladoaux;
        if(validar()){

            ladoaux = lado.getText().toString();
            double radio=Double.parseDouble(""+ladoaux);
            double val=(4.0/3.0)*Math.PI*Math.pow(radio,3.0);

            //almacenamos la operacion
            Operacion o = new Operacion(resources.getString(R.string.volumenDeLaEsfera),resources.getString(R.string.lado)+": "+ladoaux,""+val);
            o.guardar();
            in= new Intent(Esfera.this,EsferaResultado.class);
            in.putExtra("VolumenEsfera", val);
            startActivity(in);

        }

    }
    public void limpiar(View view){
        lado.setText("");
        lado.requestFocus();

    }

    public boolean validar(){
        boolean r=true;

        lado = (EditText)findViewById(R.id.txtValorRadioEsfera);
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