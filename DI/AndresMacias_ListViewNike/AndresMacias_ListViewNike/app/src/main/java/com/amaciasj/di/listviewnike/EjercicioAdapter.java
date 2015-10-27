package com.amaciasj.di.listviewnike;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by andres on 26/10/15.
 */
public class EjercicioAdapter extends ArrayAdapter <EjercicioGimnasio> {

    private final Context context;
    private final ArrayList<EjercicioGimnasio> values;


    public EjercicioAdapter(Context context, ArrayList<EjercicioGimnasio> values) {
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
        View layoutEjercicioAInyectar= inflater.inflate(R.layout.list_item, parent, false);

        // Busco en el layout los elementos a modificar
        ImageView tiempo = (ImageView) layoutEjercicioAInyectar.findViewById(R.id.imageViewtiempo);
        TextView nombreEjercicio = (TextView) layoutEjercicioAInyectar.findViewById(R.id.txt_nombreEjercicio);

        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        EjercicioGimnasio miEjercicio = values.get(position);


        nombreEjercicio.setText(miEjercicio.getNombreEjercicio());
        tiempo.setImageDrawable(miEjercicio.getTiempo());

        return layoutEjercicioAInyectar;
    }
}
