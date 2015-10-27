package com.amaciasj.di.listviewpersonalizado;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by Andres on 26/10/15.
 */
public class Team {

    private String name;
    private String city;
    private boolean likeMe;
    private Drawable logo;

    public Team(String name, String city, boolean likeMe, Drawable logo) {
        this.name = name;
        this.city = city;
        this.likeMe = likeMe;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public boolean isLikeMe() {
        return likeMe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLikeMe(boolean likeMe) {
        this.likeMe = likeMe;
    }

    public Drawable getLogo() {
        return logo;
    }

    public void setLogo(Drawable logo) {
        this.logo = logo;
    }
}
