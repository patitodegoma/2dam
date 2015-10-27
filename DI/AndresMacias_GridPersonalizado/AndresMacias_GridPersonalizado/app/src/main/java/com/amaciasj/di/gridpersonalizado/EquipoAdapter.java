package com.amaciasj.di.gridpersonalizado;

import android.content.Context;
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
public class EquipoAdapter extends ArrayAdapter <Equipo> {
    private final Context context;
    private final ArrayList<Equipo> values;


    public EquipoAdapter(Context context, ArrayList<Equipo> values) {
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
        View layoutEquipoAInyectar = inflater.inflate(R.layout.grid_item, parent, false);

        // Busco en el layout los elementos a modificar
        ImageView escudo = (ImageView) layoutEquipoAInyectar.findViewById(R.id.imageViewEscudo);
        TextView nombreEquipo = (TextView) layoutEquipoAInyectar.findViewById(R.id.textViewNombre);


        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        Equipo seleccionado = values.get(position);

        nombreEquipo.setText(seleccionado.getNombre());
        escudo.setImageDrawable(seleccionado.getEscudo());

        return layoutEquipoAInyectar;
    }
}
