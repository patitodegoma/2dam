package com.amaciasj.di.listviewactivitypersonalizado;

/**
 * Created by andres on 27/10/15.
 */
public class CallItem {

    private String nombre;
    private String number;
    private String date;
    private String duration;
    private int type;


    public CallItem(String nombre, String number, String date, String duration, int type) {
        this.nombre = nombre;
        this.number = number;
        this.date = date;
        this.duration = duration;
        this.type = type;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
