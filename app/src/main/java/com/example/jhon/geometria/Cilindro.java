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

public class Cilindro extends AppCompatActivity {
    private Resources resources;
    private EditText radio,altura;
    private Intent in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);
        radio = (EditText)findViewById(R.id.txtRadio);
        altura = (EditText)findViewById(R.id.txtAltura);
        resources = this.getResources();


    }

    public void calcularVolumenCilindro(View view){
        String radioaux,alturaaux;
        if(validar()){

            radioaux = radio.getText().toString();
            alturaaux = altura.getText().toString();
            double radiox=Double.parseDouble(""+radioaux);
            double alturax=Double.parseDouble(""+alturaaux);
            double val=Math.PI*Math.pow(radiox,2.0)*alturax;

            //almacenamos la operacion
            String msg=resources.getString(R.string.txtValorRadio)+" "+radiox+"\n"+resources.getString(R.string.valorAltura)+" "+alturax;
            Operacion o = new Operacion(resources.getString(R.string.volumenDelCilindro),msg,""+val);
            o.guardar();
            in= new Intent(Cilindro.this,CilindroResultado.class);
            in.putExtra("VolumenCilindro", val);
            startActivity(in);

        }

    }
    public void limpiar(View view){
        altura.setText("");
        radio.setText("");
        radio.requestFocus();


    }

    public boolean validar(){
        boolean r=true;

        radio = (EditText)findViewById(R.id.txtRadio);
        String x =radio.getText().toString();

        if(x.isEmpty()||radio.getText().toString().trim().isEmpty()){
            radio.setError(resources.getString(R.string.mensaje_error_uno));
            radio.setText("");
            radio.requestFocus();
            return false;
        }


        altura = (EditText)findViewById(R.id.txtAltura);
         x =altura.getText().toString();

        if(x.isEmpty()||altura.getText().toString().trim().isEmpty()){
            altura.setError(resources.getString(R.string.mensaje_error_uno));
            altura.setText("");
            altura.requestFocus();
            return false;
        }

        return r;
    }
}