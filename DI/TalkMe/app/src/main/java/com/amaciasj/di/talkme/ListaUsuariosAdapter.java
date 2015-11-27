package com.amaciasj.di.talkme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Adaptador del histórico de búsquedas. Análogo al de la predicción de 5 días
 */
public class ListaUsuariosAdapter extends RecyclerView.Adapter<ListaUsuariosAdapter.CardViewHolder>{

    private List<Usuario> items = new ArrayList();

    static Context context;

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView txtUsername, txtName;

        public CardViewHolder(View v) {
            super(v);

            txtUsername = (TextView) v.findViewById(R.id.txt_user);
            txtName = (TextView) v.findViewById(R.id.txt_name);

            context = v.getContext();

        }
    }


    public ListaUsuariosAdapter(List<Usuario> items) {

        this.items = items;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.lista_usuarios_item, viewGroup, false);

        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder viewHolder, final int i) {

        viewHolder.txtUsername.setText(items.get(i).getLogin());
        viewHolder.txtName.setText(items.get(i).getNombreCompleto());

    }

}
