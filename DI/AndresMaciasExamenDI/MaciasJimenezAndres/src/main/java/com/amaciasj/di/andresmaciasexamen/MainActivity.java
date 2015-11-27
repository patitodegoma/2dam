package com.amaciasj.di.andresmaciasexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    GridView menu;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList listaemail = new ArrayList<EmailItem>();
        listaemail.add(new EmailItem("L", "Los escarabajos", "Un viaje mágico..."));
        listaemail.add(new EmailItem("T", "TIBCO Jasper", "Our apologies..."));




    }
}
