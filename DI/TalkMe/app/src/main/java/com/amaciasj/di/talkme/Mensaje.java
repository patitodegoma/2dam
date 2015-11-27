package com.amaciasj.di.talkme;

import java.util.Date;

/**
 * Created by amacias on 19/11/2015.
 */
public class Mensaje {

    private Date fechaEnvio;
    private String contenido;
    private String remitente;
    private String receptor;

    public Mensaje(Date fechaEnvio, String contenido, String remitente, String receptor) {
        this.fechaEnvio = fechaEnvio;
        this.contenido = contenido;
        this.remitente = remitente;
        this.receptor = receptor;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "fechaEnvio=" + fechaEnvio +
                ", contenido='" + contenido + '\'' +
                ", remitente='" + remitente + '\'' +
                ", receptor='" + receptor + '\'' +
                '}';
    }
}
