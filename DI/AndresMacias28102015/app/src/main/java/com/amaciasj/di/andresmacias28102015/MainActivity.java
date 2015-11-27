package com.amaciasj.di.andresmacias28102015;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = (ListView)findViewById(R.id.listView);

        final ArrayList<Fruta> listado = new ArrayList<Fruta>();
        listado.add(new Fruta(true, "AdviceAnimals", "1886496 subscribers, 2 years old"));
        listado.add(new Fruta(true, "announcements", "2966300 subscribers, 3 years old"));
        listado.add(new Fruta(false, "AskReddit", "2792876 subscribers, 4 years old"));
        listado.add(new Fruta(true, "atheism", "1548622 subscribers, 4 years old"));


        final FrutaAdapter myAdapter = new FrutaAdapter(this, R.layout.list_item, listado);



        myList.setAdapter(myAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruta selected = listado.get(position);

                if (selected.isMeGusta()) {
                    selected.setMeGusta(false);
                } else {
                    selected.setMeGusta(true);
                }

                myAdapter.notifyDataSetChanged();
            }
        });



    }
}
