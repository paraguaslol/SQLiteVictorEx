package com.dmb.sqlite.Asignatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.dmb.sqlite.Adapter.AsignaturasAdapter;
import com.dmb.sqlite.MainActivity;
import com.dmb.sqlite.Model.Asignatura;
import com.dmb.sqlite.R;

import java.util.ArrayList;

public class SearchAsignaturaActivity extends AppCompatActivity {

    ListView lwA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_asignatura);

        this.lwA = findViewById(R.id.asignaturalw);
    }

    public void searchAsignaturas(View v){
        String sql="SELECT * FROM asignaturas;";

        ArrayList<Asignatura> showAsignaturas = MainActivity.myDBAdapter.searchAsignatura(sql);
        AsignaturasAdapter asignaturasAdapter = new AsignaturasAdapter(getApplicationContext(), showAsignaturas);
        lwA.setAdapter(asignaturasAdapter);
    }
}
