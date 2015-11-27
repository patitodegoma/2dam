package com.amaciasj.di.andresmacias28102015;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by amacias on 28/10/2015.
 */

public class FrutaAdapter extends ArrayAdapter<Fruta> {
    private List<Fruta> frutas;
    Activity context;
    int layoutMolde;
    public FrutaAdapter(Activity context, int layout,
                        List<Fruta> listadoFrutas) {
        super(context, layout, listadoFrutas);
        frutas = listadoFrutas;
        this.context = context;
        this.layoutMolde = layout;
// TODO Auto-generated constructor stub
    }
    @Override
    public View getView(int position, View moldeVacio, ViewGroup parent) {
// TODO Auto-generated method stub
//return super.getView(position, convertView, parent);
        LayoutInflater inflater = context.getLayoutInflater();
        moldeVacio = inflater.inflate(layoutMolde, null);
// Si optamos por eliminar del constructor del Adaptador el
// parámetro del layout que utilizamos como molde, podríamos
// hacerlo de la siguiente manera:
// convertView = inflater.inflate(R.layout.list_item_fruta, null);
        Fruta frutaActual = frutas.get(position);
// Rescato los elementos del molde para modificarlos con el nombre y el icono de la fruta actual
        TextView nombre = (TextView) moldeVacio.findViewById(R.id.txtNombre);
        TextView subscriptores = (TextView) moldeVacio.findViewById(R.id.txtSubscribers);
        CheckBox cbLike = (CheckBox) moldeVacio.findViewById(R.id.checkBox);
        ImageView img = (ImageView) moldeVacio.findViewById(R.id.imageView);

        nombre.setText(frutaActual.getNombre());
        subscriptores.setText(frutaActual.getSubscribers());

        if (frutaActual.isMeGusta()) {
            cbLike.setChecked(true);
            img.setImageResource(R.mipmap.ic_star);
        } else {
            cbLike.setChecked(false);
            img.setImageResource(R.mipmap.ic_star2);
        }

        return moldeVacio;
    }

}
