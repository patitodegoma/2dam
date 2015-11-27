package com.amaciasj.di.talkme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Adaptador del histórico de búsquedas. Análogo al de la predicción de 5 días
 */
public class MensajesAdapter extends RecyclerView.Adapter<MensajesAdapter.CardViewHolder>{

    private List<Mensaje> items = new ArrayList();

    static Context context;



    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public ImageButton imgEye;
        public TextView txtPoblacion, txtPais;

        public CardViewHolder(View v) {
            super(v);


            context =v.getContext();

        }
    }


    public MensajesAdapter(List<Mensaje> items) {

        this.items = items;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.lista_mensajes_item, viewGroup, false);



        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder viewHolder, final int i) {




    }



}
