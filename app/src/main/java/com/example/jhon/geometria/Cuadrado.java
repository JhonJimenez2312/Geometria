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

public class Cuadrado extends AppCompatActivity {
    private Resources resources;
    private EditText lado;
    private Intent in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        lado = (EditText)findViewById(R.id.txtValorLadoCuadrado);
        resources = this.getResources();


    }

    public void calcularAreaCuadrado(View view){
        String ladoaux;
        if(validar()){

            ladoaux = lado.getText().toString();
            double val=Double.parseDouble(""+ladoaux);
            val=val*val;
            //almacenamos la operacion
            Operacion o = new Operacion(resources.getString(R.string.areaDelCuadrado),resources.getString(R.string.lado)+": "+ladoaux,""+val);
            o.guardar();
            in= new Intent(Cuadrado.this,CuadradoResultado.class);
            in.putExtra("areaCuadrado", val);
            startActivity(in);

        }

    }
    public void limpiar(View view){
        lado.setText("");
        lado.requestFocus();

    }

    public boolean validar(){
        boolean r=true;

        lado = (EditText)findViewById(R.id.txtValorLadoCuadrado);
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
