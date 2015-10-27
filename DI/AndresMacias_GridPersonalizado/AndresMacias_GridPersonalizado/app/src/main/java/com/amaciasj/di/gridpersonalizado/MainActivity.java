package com.amaciasj.di.gridpersonalizado;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (GridView)findViewById(R.id.gridView);

        final ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_ath), "Athletic Bilbao"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_atm), "Atlético Madrid"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_bar), "FC Barcelona"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_bet), "Real Betis"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_esp), "RCD Español"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_get), "SD Getafe"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_gij), "Sporting Gijón"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_gra), "Granada CF"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_lev), "UD Levante"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_mad), "Real Madrid"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_mag), "Málaga CF"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_mal), "RCD Mallorca"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_osa), "CA Osasuna"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_rac), "Racing Santander"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_ray), "AD Rayo"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_rso), "Real Sociedad"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_sev), "Sevilla FC"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_val), "Valencia CF"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_vil), "Villarreal CF"));
        listaEquipos.add(new Equipo(ContextCompat.getDrawable(this, R.mipmap.ic_zar), "Real Zaragoza"));

        final EquipoAdapter adaptador = new EquipoAdapter(this,listaEquipos);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Equipo alumnoSeleccionado = listaEquipos.get(position);



                adaptador.notifyDataSetChanged();
            }
        });

    }
}
