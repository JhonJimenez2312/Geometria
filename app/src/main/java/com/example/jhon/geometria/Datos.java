package com.example.jhon.geometria;

import java.util.ArrayList;


public class Datos {
    private static ArrayList<Operacion> Operaciones = new ArrayList<>();

    public static void guardar (Operacion o){
        Operaciones.add(o);
    }

    public static ArrayList<Operacion> Obtener(){
        return Operaciones;
    }
}
