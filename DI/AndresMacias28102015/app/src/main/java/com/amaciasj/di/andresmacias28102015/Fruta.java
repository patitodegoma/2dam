package com.amaciasj.di.andresmacias28102015;

/**
 * Created by amacias on 28/10/2015.
 */
public class Fruta {

    private boolean meGusta;
    private String nombre;
    private String subscribers;

    public Fruta(boolean meGusta, String nombre, String subscribers) {
        this.meGusta = meGusta;
        this.nombre = nombre;
        this.subscribers = subscribers;
    }

    public boolean isMeGusta() {
        return meGusta;
    }

    public void setMeGusta(boolean meGusta) {
        this.meGusta = meGusta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(String subscribers) {
        this.subscribers = subscribers;
    }
}
