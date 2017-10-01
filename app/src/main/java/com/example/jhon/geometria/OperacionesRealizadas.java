package com.example.jhon.geometria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jhon on 1/10/2017.
 */

public class OperacionesRealizadas extends AppCompatActivity {

    private TableLayout tabla;
    private ArrayList<Operacion> OperacionesRealizadas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones_realizadas);
        tabla = (TableLayout)findViewById(R.id.Tabla);
        OperacionesRealizadas = Datos.Obtener();
        int contador=0;
        for (int i = 0; i <OperacionesRealizadas.size() ; i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(OperacionesRealizadas.get(i).getNombre());
            c3.setText(OperacionesRealizadas.get(i).getDatos());
            c4.setText(OperacionesRealizadas.get(i).getResultado());

                fila.addView(c1);
                fila.addView(c2);
                fila.addView(c3);
                fila.addView(c4);
                tabla.addView(fila);
         }
    }
}
