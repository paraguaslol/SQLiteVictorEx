package com.dmb.sqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dmb.sqlite.Model.Student;
import com.dmb.sqlite.R;

import java.util.ArrayList;

/**
 * Created by davidmari on 22/1/18.
 */

public class StudentsAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> estudiantes;

    public StudentsAdapter(Context context, ArrayList<Student> estudiantes) {
        this.context=context;
        this.estudiantes=estudiantes;
    }

    @Override
    public int getCount() {
        return estudiantes.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Student getItem(int position) {
        return estudiantes.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.item_student, null);


        Student estudiante = getItem(position);
        ((TextView) view.findViewById(R.id.nombre)).setText(estudiante.getNombre());
        ((TextView) view.findViewById(R.id.curso)).setText("Curso: "+estudiante.getCurso());
        ((TextView) view.findViewById(R.id.ciclo)).setText("Ciclo: "+estudiante.getCiclo());

        return view;
    }
}