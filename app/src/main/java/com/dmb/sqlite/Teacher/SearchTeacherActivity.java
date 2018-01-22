package com.dmb.sqlite.Teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.dmb.sqlite.Adapter.TeachersAdapter;
import com.dmb.sqlite.MainActivity;
import com.dmb.sqlite.Model.Teacher;
import com.dmb.sqlite.R;

import java.util.ArrayList;

public class SearchTeacherActivity extends AppCompatActivity {

    EditText curso, ciclo;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_teacher);
        this.curso = findViewById(R.id.curso);
        this.ciclo = findViewById(R.id.ciclo);
        this.listView = findViewById(R.id.listView);
    }

    public void searchTeachers(View v) {

        String sql = "";

        switch (this.checkET()) {
            case 0:
                sql = "SELECT * FROM profesores;";
                break;
            case 1:
                sql = "SELECT * FROM profesores WHERE ciclo = \""+this.ciclo.getText().toString()+"\" ;";
                break;
            case 2:
                sql = "SELECT * FROM profesores WHERE curso = \""+this.curso.getText().toString()+"\" ;";
                break;
            case 3:
                sql = "SELECT * FROM profesores WHERE ciclo = \""+this.ciclo.getText().toString()+"\" AND curso = \"" + this.curso.getText().toString() + "\" ;";
                break;
        }

        ArrayList<Teacher> profesoresAMostrar = MainActivity.myDBAdapter.searchTeachers(sql);
        TeachersAdapter profesoresAdapter = new TeachersAdapter(getApplicationContext(), profesoresAMostrar);
        listView.setAdapter(profesoresAdapter);
    }

    public int checkET() {
        //0: todos,1: ciclo, 2: curso, 3: ciclo y curso
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