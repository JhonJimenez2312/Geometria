package com.example.jhon.geometria;

/**
 * Created by Jhon on 1/10/2017.
 */

public class Operacion {
    private String nombre;
    private String datos;
    private String resultado;

    public Operacion(String nombre, String datos, String resultado) {
        this.nombre = nombre;
        this.datos = datos;
        this.resultado = resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void guardar(){
        Datos.guardar(this);
    }
}
