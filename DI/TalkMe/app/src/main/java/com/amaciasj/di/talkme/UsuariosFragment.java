package com.amaciasj.di.talkme;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class UsuariosFragment extends Fragment {

    View v;
    Context context;

    RecyclerView rv;
    RecyclerView.LayoutManager lm;

    ArrayList<Usuario> listaUsuarios;

    SharedPreferences sp;


    public UsuariosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        context = container.getContext();

        v = inflater.inflate(R.layout.fragment_usuarios, container, false);

        rv = (RecyclerView) v.findViewById(R.id.rec);

        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(context);
        rv.setLayoutManager(lm);

        listaUsuarios = new ArrayList<Usuario>();

        // TODO Cargar el ArrayList con datos no demo
        listaUsuarios.add(new Usuario("andmacjim", "Andrés Macías Jiménez"));
        listaUsuarios.add(new Usuario("beaalvtor", "Beatriz Álvarez Toro"));
        listaUsuarios.add(new Usuario("fratirmar", "Fran Tirado Maraver"));

        rv.setAdapter(new ListaUsuariosAdapter(listaUsuarios));

        return v;
    }


}
