package com.dmb.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dmb.sqlite.Adapter.MyDBAdapter;
import com.dmb.sqlite.Student.SearchStudentActivity;
import com.dmb.sqlite.Student.StudentActivity;
import com.dmb.sqlite.Asignatura.SearchAsignaturaActivity;
import com.dmb.sqlite.Asignatura.AsignaturaActivity;
import com.dmb.sqlite.Teacher.SearchTeacherActivity;
import com.dmb.sqlite.Teacher.TeacherActivity;

public class MainActivity extends AppCompatActivity {


    public static MyDBAdapter myDBAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.myDBAdapter = new MyDBAdapter(getApplicationContext());
    }

    public void estudiantes(View v) {
        Intent i = new Intent(this,StudentActivity.class);
        startActivity(i);
    }

    public void mostrarEstudiantes(View v) {
        Intent i = new Intent(this,SearchStudentActivity.class);
        startActivity(i);
    }

    public void profesores(View v) {
        Intent i = new Intent(this,TeacherActivity.class);
        startActivity(i);
    }

    public void mostrarProfesores(View v) {
        Intent i = new Intent(this,SearchTeacherActivity.class);
        startActivity(i);
    }

    public void asignaturas(View v){
        Intent intent = new Intent(this, AsignaturaActivity.class);
        startActivity(intent);
    }

    public void mostrarAsignaturas(View v){
        Intent intent = new Intent(this, SearchAsignaturaActivity.class);
        startActivity(intent);
    }

    public void eliminarBD(View v) {
        this.myDBAdapter.deleteDB();
    }
}
