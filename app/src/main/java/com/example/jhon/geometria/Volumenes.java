package com.example.jhon.geometria;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Jhon on 1/10/2017.
 */

public class Volumenes extends AppCompatActivity {
    private ListView lv;
    private Resources resources;
    private String opc[];
    private Intent in;//para intercambiar entre activitys
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //CLASE
        setContentView(R.layout.activity_volumenes);
        lv = (ListView)findViewById(R.id.OpcionesVolumenes);
        resources= this.getResources();
        opc=resources.getStringArray(R.array.OpcionesVolumenes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        lv.setAdapter(adapter);

        //AREAS,VOLUMENES,OP REALIZADAS
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in= new Intent(Volumenes.this,Areas.class);
                        startActivity(in);
                        break;
                    case 1:
                        in= new Intent(Volumenes.this,Volumenes.class);
                        startActivity(in);
                        break;
                    case 2:
                        in= new Intent(Volumenes.this,OperacionesRealizadas.class);
                        startActivity(in);
                        break;
                }
            }
        });
    }
}
