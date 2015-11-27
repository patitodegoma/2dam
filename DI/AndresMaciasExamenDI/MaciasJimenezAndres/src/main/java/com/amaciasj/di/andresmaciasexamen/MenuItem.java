package com.amaciasj.di.andresmaciasexamen;

import android.graphics.drawable.Drawable;

/**
 * Created by amacias on 30/10/2015.
 */
public class MenuItem {

    Drawable icono;
    String texto;

    public MenuItem(Drawable icono, String texto) {
        this.icono = icono;
        this.texto = texto;
    }

    public Drawable getIcono() {
        return icono;
    }

    public void setIcono(Drawable icono) {
        this.icono = icono;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
