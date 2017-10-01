package com.example.jhon.geometria;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jhon on 1/10/2017.
 */

public class CuadradoResultado extends AppCompatActivity {
    private Resources resources;
    private Intent in;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado_resultado);
        resources = this.getResources();
        res= (TextView) findViewById(R.id.txtResultadoArea);
        Bundle datos = this.getIntent().getExtras();
        int val = datos.getInt("areaCuadrado");
        res.setText(""+val);


    }

    public void regresar(View view){
        in= new Intent(CuadradoResultado.this,Cuadrado.class);
        startActivity(in);
    }
}
