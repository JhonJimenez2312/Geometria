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

public class Circulo extends AppCompatActivity {
    private Resources resources;
    private EditText lado;
    private Intent in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        lado = (EditText)findViewById(R.id.txtValorRadioCirculo);
        resources = this.getResources();


    }

    public void calcularAreaCirculo(View view){
        String ladoaux;
        if(validar()){

            ladoaux = lado.getText().toString();
            double radio=Double.parseDouble(""+ladoaux);
            double val=(radio*radio)*Math.PI;

            //almacenamos la operacion
            Operacion o = new Operacion(resources.getString(R.string.areaDelCirculo),resources.getString(R.string.radio)+": "+ladoaux,""+val);
            o.guardar();
            in= new Intent(Circulo.this,CirculoResultado.class);
            in.putExtra("areaCirculo", val);
            startActivity(in);

        }

    }
    public void limpiar(View view){
        lado.setText("");
        lado.requestFocus();

    }

    public boolean validar(){
        boolean r=true;

        lado = (EditText)findViewById(R.id.txtValorRadioCirculo);
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