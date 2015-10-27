package com.amaciasj.di.listviewactivitypersonalizado;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by andres on 27/10/15.
 */
public class CallItemAdapter extends ArrayAdapter<CallItem> {

    private final Context context;
    private final ArrayList<CallItem> values;


    public CallItemAdapter(Context context, ArrayList<CallItem> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // La siguiente línea de código recibe como parámetro el layout
        // que he diseñado para un elemento del ListView, en este caso
        // para un Alumno de la lista >>> R.layout.list_item_alumno
        View layoutCallItemAInyectar = inflater.inflate(R.layout.list_item, parent, false);

        // Busco en el layout los elementos a modificar
        ImageView icon = (ImageView) layoutCallItemAInyectar.findViewById(R.id.imageView);
        TextView number = (TextView) layoutCallItemAInyectar.findViewById(R.id.txt_telephone);
        TextView name = (TextView) layoutCallItemAInyectar.findViewById(R.id.txt_name);
        TextView date = (TextView) layoutCallItemAInyectar.findViewById(R.id.txt_date);
        TextView duration = (TextView) layoutCallItemAInyectar.findViewById(R.id.txt_duration);


        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        CallItem myCall = values.get(position);

        switch (myCall.getType()) {
            case 0: // Llamada efectuada
                icon.setImageResource(R.mipmap.ic_placed_call);
                break;
            case 1: // Llamada recibida
                icon.setImageResource(R.mipmap.ic_received_call);
                break;
            case 2: // Llamada perdida
                icon.setImageResource(R.mipmap.ic_missed_call);
        }


        name.setText(" - " + myCall.getNombre());
        number.setText(myCall.getNumber());
        duration.setText(myCall.getDuration());
        date.setText(myCall.getDate());

        return layoutCallItemAInyectar;
    }
}
