package com.dmb.sqlite.Teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dmb.sqlite.MainActivity;
import com.dmb.sqlite.R;

public class TeacherActivity extends AppCompatActivity {

    EditText nombre, edad, ciclo, curso, despacho, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        this.nombre = findViewById(R.id.nombre);
        this.edad = findViewById(R.id.edad);
        this.ciclo = findViewById(R.id.ciclo);
        this.curso = findViewById(R.id.curso);
        this.despacho = findViewById(R.id.despacho);
        this.id = findViewById(R.id.id);
    }

    public void clearTeacher(View v) {
        this.nombre.setText("");
        this.edad.setText("");
        this.ciclo.setText("");
        this.curso.setText("");
        this.despacho.setText("");
    }

    public void insertTeacher(View v) {
        MainActivity.myDBAdapter.insertTeacher(
                this.nombre.getText().toString(),
                this.ciclo.getText().toString(),
                this.curso.getText().toString(),
                Integer.parseInt(this.edad.getText().toString()),
                this.despacho.getText().toString());
    }

    public void deleteTeacher(View v) {
        MainActivity.myDBAdapter.deleteTeacher(Integer.parseInt(this.id.getText().toString()));
    }
}