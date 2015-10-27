package com.amaciasj.di.listviewactivitypersonalizado;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;


public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<CallItem> listaLlamadas = new ArrayList <CallItem> ();
        listaLlamadas.add(new CallItem("Macarena", "635482579", "hoy a las 19:29", "4m58s", 0));
        listaLlamadas.add(new CallItem("Mamá", "646804252", "hoy a las 16:21", "1m18s", 1));
        listaLlamadas.add(new CallItem("Macarena", "635482579", "hoy a las 15:04", "", 2));
        listaLlamadas.add(new CallItem("Miguel", "612857442", "hoy a las 11:01", "7m15s", 1));
        listaLlamadas.add(new CallItem("Pablo", "696547744", "ayer a las 21:58", "4m58s", 0));
        listaLlamadas.add(new CallItem("Mamá", "646804252", "ayer a las 19:27", "1m38s", 1));
        listaLlamadas.add(new CallItem("Macarena", "635482579", "hace 2 días", "", 2));
        listaLlamadas.add(new CallItem("Papá", "695458854", "hace 2 días", "49s", 1));
        listaLlamadas.add(new CallItem("Macarena", "635482579", "24/10/2015", "9m08s", 0));
        listaLlamadas.add(new CallItem("Luismi", "955145874", "24/10/2015", "10m18s", 1));
        listaLlamadas.add(new CallItem("Macarena", "635482579", "24/10/2015", "", 2));
        listaLlamadas.add(new CallItem("Mamá", "646804252", "23/10/2015", "3m22s", 1));

        final CallItemAdapter myAdapter = new CallItemAdapter(this, listaLlamadas);

        setListAdapter(myAdapter);
    }
}
