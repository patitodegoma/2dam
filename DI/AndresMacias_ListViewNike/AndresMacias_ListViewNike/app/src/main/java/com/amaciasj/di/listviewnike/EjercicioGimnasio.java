package com.amaciasj.di.listviewnike;

import android.graphics.drawable.Drawable;

/**
 * Created by andres on 26/10/15.
 */
public class EjercicioGimnasio {

    private Drawable tiempo;
    private String nombreEjercicio;

    public EjercicioGimnasio(Drawable tiempo, String nombreEjercicio) {
        this.tiempo = tiempo;
        this.nombreEjercicio = nombreEjercicio;
    }

    public Drawable getTiempo() {
        return tiempo;
    }

    public void setTiempo(Drawable tiempo) {
        this.tiempo = tiempo;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }
}
