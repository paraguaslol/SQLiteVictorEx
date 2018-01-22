package com.dmb.sqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dmb.sqlite.Model.Teacher;
import com.dmb.sqlite.R;

import java.util.ArrayList;

/**
 * Created by davidmari on 22/1/18.
 */

public class TeachersAdapter extends BaseAdapter {
    Context context;
    ArrayList<Teacher> profesores;

    public TeachersAdapter(Context context, ArrayList<Teacher> profesores) {
        this.context=context;
        this.profesores=profesores;
    }

    @Override
    public int getCount() {
        return profesores.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Teacher getItem(int position) {
        return profesores.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.item_student, null);


        Teacher profesor = getItem(position);
        ((TextView) view.findViewById(R.id.nombre)).setText(profesor.getNombre());
        ((TextView) view.findViewById(R.id.curso)).setText("Curso: "+profesor.getCurso());
        ((TextView) view.findViewById(R.id.ciclo)).setText("Ciclo: "+profesor.getCiclo());

        return view;
    }
}
