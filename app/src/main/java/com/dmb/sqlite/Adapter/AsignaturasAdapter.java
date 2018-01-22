package com.dmb.sqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dmb.sqlite.Model.Asignatura;
import com.dmb.sqlite.R;

import java.util.ArrayList;

public class AsignaturasAdapter extends BaseAdapter {
    Context context;
    ArrayList<Asignatura> asignaturas;

    public AsignaturasAdapter(Context context, ArrayList<Asignatura> asignaturas) {
        this.context=context;
        this.asignaturas = asignaturas;
    }

    @Override
    public int getCount() {
        return asignaturas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Asignatura getItem(int position) {
        return asignaturas.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.item_asignatura, null);


        Asignatura asignatura = getItem(position);
        ((TextView) view.findViewById(R.id.listNombre)).setText(asignatura.getNombre());
        ((TextView) view.findViewById(R.id.listHoras)).setText(asignatura.getHoras()+"hs");

        return view;
    }
}
