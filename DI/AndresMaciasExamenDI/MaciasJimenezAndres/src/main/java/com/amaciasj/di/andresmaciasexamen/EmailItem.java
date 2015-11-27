package com.amaciasj.di.andresmaciasexamen;

import android.graphics.drawable.Drawable;

/**
 * Created by amacias on 30/10/2015.
 */
public class EmailItem {

    String inicial;
    String remitente;
    String texto;

    public EmailItem(String inicial, String remitente, String texto) {
        this.inicial = inicial;
        this.remitente = remitente;
        this.texto = texto;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
