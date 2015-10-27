package com.amaciasj.di.listviewpersonalizado;

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

        final ArrayList<Team> canadianTeams = new ArrayList<Team>();
        canadianTeams.add(new Team("Canadiens","Montreal", true, ContextCompat.getDrawable(this, R.mipmap.ic_canadiens)));
        canadianTeams.add(new Team("Maple Leafs", "Toronto", true, ContextCompat.getDrawable(this, R.mipmap.ic_mapleleafs)));
        canadianTeams.add(new Team("Oilers", "Edmonton", false, ContextCompat.getDrawable(this, R.mipmap.ic_oilers)));
        canadianTeams.add(new Team("Senators","Ottawa", false, ContextCompat.getDrawable(this, R.mipmap.ic_senators)));
        canadianTeams.add(new Team("Canucks","Vancouver", true, ContextCompat.getDrawable(this, R.mipmap.ic_canucks)));
        canadianTeams.add(new Team("Flames","Calgary", true, ContextCompat.getDrawable(this, R.mipmap.ic_flames)));
        canadianTeams.add(new Team("Jets","Winnipeg", false, ContextCompat.getDrawable(this, R.mipmap.ic_jets)));

        final TeamAdapter myAdapter = new TeamAdapter(this,canadianTeams);

        myList.setAdapter(myAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Team selected = canadianTeams.get(position);

                if(selected.isLikeMe()) {
                    selected.setLikeMe(false);
                } else  {
                    selected.setLikeMe(true);
                }

                myAdapter.notifyDataSetChanged();
            }
        });


    }
}
