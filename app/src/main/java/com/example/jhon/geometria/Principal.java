package com.example.jhon.geometria;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView lv;
    private Resources resources;
    private String opc[];
    private Intent in;//para intercambiar entre activitys
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lv = (ListView)findViewById(R.id.Opciones);
        resources= this.getResources();
        opc=resources.getStringArray(R.array.Opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        lv.setAdapter(adapter);

                //AREAS,VOLUMENES,OP REALIZADAS
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in= new Intent(Principal.this,Areas.class);
                        startActivity(in);
                        break;
                    case 1:
                        in= new Intent(Principal.this,Volumenes.class);
                        startActivity(in);
                        break;
                    case 2:
                        in= new Intent(Principal.this,OperacionesRealizadas.class);
                        startActivity(in);
                        break;
                }
            }
        });
    }
}
