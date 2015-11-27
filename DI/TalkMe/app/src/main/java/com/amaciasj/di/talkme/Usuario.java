package com.amaciasj.di.talkme;

/**
 * Created by amacias on 19/11/2015.
 */
public class Usuario {

    private String login;
    private String nombreCompleto;

    public Usuario(String login, String nombreCompleto) {
        this.login = login;
        this.nombreCompleto = nombreCompleto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
