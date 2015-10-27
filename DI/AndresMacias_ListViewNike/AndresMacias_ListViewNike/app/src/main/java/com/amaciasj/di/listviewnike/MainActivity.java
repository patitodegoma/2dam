package com.amaciasj.di.listviewnike;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = (ListView)findViewById(R.id.listView);

        final ArrayList<EjercicioGimnasio> ejercicios = new ArrayList<EjercicioGimnasio>();
        ejercicios.add(new EjercicioGimnasio(ContextCompat.getDrawable(this, R.mipmap.ic_thirty_min), "SWEAT + SHAPE"));
        ejercicios.add(new EjercicioGimnasio(ContextCompat.getDrawable(this, R.mipmap.ic_thirty_min), "SLIM CHANCE"));
        ejercicios.add(new EjercicioGimnasio(ContextCompat.getDrawable(this, R.mipmap.ic_thirty_min), "FIGHTER FIT"));
        ejercicios.add(new EjercicioGimnasio(ContextCompat.getDrawable(this, R.mipmap.ic_thirty_min), "JUMP START"));
        ejercicios.add(new EjercicioGimnasio(ContextCompat.getDrawable(this, R.mipmap.ic_forty_five), "HURRICANE"));
        ejercicios.add(new EjercicioGimnasio(ContextCompat.getDrawable(this, R.mipmap.ic_forty_five), "CRUNCH + BURN"));
        ejercicios.add(new EjercicioGimnasio(ContextCompat.getDrawable(this, R.mipmap.ic_forty_five), "CARDIO SURGE"));

        final EjercicioAdapter myAdapter = new EjercicioAdapter(this, ejercicios);

        myList.setAdapter(myAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EjercicioGimnasio selected = ejercicios.get(position);

                Toast.makeText(MainActivity.this, "Seleccionado " + selected.getNombreEjercicio(), Toast.LENGTH_LONG).show();

                myAdapter.notifyDataSetChanged();
            }
        });


    }
}
