package com.amaciasj.di.listviewpersonalizado;

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
public class TeamAdapter extends ArrayAdapter <Team> {

    private final Context context;
    private final ArrayList<Team> values;


    public TeamAdapter(Context context, ArrayList<Team> values) {
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
        View layoutTeamAInyectar = inflater.inflate(R.layout.list_item, parent, false);

        // Busco en el layout los elementos a modificar
        ImageView icon = (ImageView) layoutTeamAInyectar.findViewById(R.id.imageView);
        TextView teamName = (TextView) layoutTeamAInyectar.findViewById(R.id.txt_teamname);
        TextView cityName = (TextView) layoutTeamAInyectar.findViewById(R.id.txt_city);
        ImageView logo = (ImageView) layoutTeamAInyectar.findViewById(R.id.imageViewlogo);

        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        Team myTeam = values.get(position);

        if(myTeam.isLikeMe()) {
            icon.setImageResource(R.drawable.ic_like);
        } else {
            icon.setImageResource(R.drawable.ic_dislike);
        }

        if (position % 2 == 1) {
            layoutTeamAInyectar.setBackgroundColor(Color.GRAY);

        }

        teamName.setText(myTeam.getName());
        cityName.setText(myTeam.getCity());
        logo.setImageDrawable(myTeam.getLogo());

        return layoutTeamAInyectar;
    }

}
