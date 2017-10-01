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

public class Triangulo extends AppCompatActivity {
    private Resources resources;
    private EditText base;
    private EditText altura;
    private Intent in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);
        base = (EditText)findViewById(R.id.txtBase);
        altura = (EditText)findViewById(R.id.txtAltura);
        resources = this.getResources();


    }

    public void calcularAreaTriangulo(View view){
        String baseAux,alturaAux;
        if(validar()){

            baseAux = base.getText().toString();
            alturaAux = altura.getText().toString();
            double valBase=Double.parseDouble(""+baseAux);
            double valAltura=Double.parseDouble(""+alturaAux);
            double area =(0.5)*valBase*valAltura;
            //almacenamos la operacion
            String msg=resources.getString(R.string.valorBase)+": "+valBase+"\n"+resources.getString(R.string.valorAltura)+": "+valAltura;
            Operacion o = new Operacion(resources.getString(R.string.areaDelTriangulo),msg,""+area);
            o.guardar();
            in= new Intent(Triangulo.this,TrianguloResultado.class);
            in.putExtra("areaTriangulo", area);
            startActivity(in);

        }

    }
    public void limpiar(View view){
        base.setText("");
        base.requestFocus();
        altura.setText("");

    }


    public boolean validar(){
        boolean r=true;

        base = (EditText)findViewById(R.id.txtBase);
        String x =base.getText().toString();

        if(x.isEmpty()||base.getText().toString().trim().isEmpty()){
            base.setError(resources.getString(R.string.mensaje_error_uno));
            base.setText("");
            base.requestFocus();
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
