package com.dmb.sqlite.Student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.dmb.sqlite.Adapter.StudentsAdapter;
import com.dmb.sqlite.MainActivity;
import com.dmb.sqlite.Model.Student;
import com.dmb.sqlite.R;

import java.util.ArrayList;

public class SearchStudentActivity extends AppCompatActivity {

    EditText curso, ciclo;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        this.curso = findViewById(R.id.curso);
        this.ciclo = findViewById(R.id.ciclo);
        this.listView = findViewById(R.id.listView);
    }

    public void searchStudents(View v) {
        String sql = "";

        switch (this.checkET()) {
            case 0:
                sql = "SELECT * FROM estudiantes;";
                break;
            case 1:
                sql = "SELECT * FROM estudiantes WHERE ciclo = \""+this.ciclo.getText().toString()+"\" ;";
                break;
            case 2:
                sql = "SELECT * FROM estudiantes WHERE curso = \""+this.curso.getText().toString()+"\" ;";
                break;
            case 3:
                sql = "SELECT * FROM estudiantes WHERE ciclo = \""+this.ciclo.getText().toString()+"\" AND curso = \"" + this.curso.getText().toString() + "\" ;";
                break;
        }
        ArrayList<Student> estudiantesAMostrar = MainActivity.myDBAdapter.searchStudents(sql);
        StudentsAdapter estudiantesAdapter = new StudentsAdapter(getApplicationContext(), estudiantesAMostrar);
        listView.setAdapter(estudiantesAdapter);
    }

    public int checkET() {

        if(this.ciclo.getText().toString().length()>0) {
            if(this.curso.getText().toString().length()>0) {
                return 3;
            } else {
                return 1;
            }
        }else if(this.curso.getText().toString().length()>0) {
            return 2;
        } else {
            return 0;
        }
    }
}