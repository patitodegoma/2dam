package com.amaciasj.di.gridpersonalizado;

import android.graphics.drawable.Drawable;

/**
 * Created by andres on 27/10/15.
 */
public class Equipo {

    private Drawable escudo;
    private String nombre;

    public Equipo(Drawable escudo, String nombre) {
        this.escudo = escudo;
        this.nombre = nombre;
    }

    public Drawable getEscudo() {
        return escudo;
    }

    public void setEscudo(Drawable escudo) {
        this.escudo = escudo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
