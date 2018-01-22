package com.dmb.sqlite.Student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dmb.sqlite.MainActivity;
import com.dmb.sqlite.R;

public class StudentActivity extends AppCompatActivity {

    EditText nombre, edad, ciclo, curso, nota, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        this.nombre = findViewById(R.id.nombre);
        this.edad = findViewById(R.id.edad);
        this.ciclo = findViewById(R.id.ciclo);
        this.curso = findViewById(R.id.curso);
        this.nota = findViewById(R.id.nota);
        this.id = findViewById(R.id.id);
    }

    public void clearStudent(View v) {
        this.nombre.setText("");
        this.edad.setText("");
        this.ciclo.setText("");
        this.curso.setText("");
        this.nota.setText("");
    }

    public void insertStudent(View v) {
        MainActivity.myDBAdapter.insertStudent(
                this.nombre.getText().toString(),
                this.ciclo.getText().toString(),
                this.curso.getText().toString(),
                Integer.parseInt(this.edad.getText().toString()),
                Integer.parseInt(this.nota.getText().toString()));
    }

    public void deleteStudent(View v) {
        MainActivity.myDBAdapter.deleteStudent(Integer.parseInt(this.id.getText().toString()));
    }
}
