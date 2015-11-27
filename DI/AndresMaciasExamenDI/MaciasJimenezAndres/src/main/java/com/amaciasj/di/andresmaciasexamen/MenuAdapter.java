package com.amaciasj.di.andresmaciasexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by amacias on 30/10/2015.
 */
public class MenuAdapter extends ArrayAdapter<MenuItem> {

    private final Context context;
    private final ArrayList<MenuItem> values;


    public MenuAdapter(Context context, ArrayList<MenuItem> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutMenuAInyectar = inflater.inflate(R.layout.list_item_menu, parent, false);



        MenuItem alumnoActual = values.get(position);

        // Modificaciones a realizar en el layout...

        return layoutMenuAInyectar;
    }
}
