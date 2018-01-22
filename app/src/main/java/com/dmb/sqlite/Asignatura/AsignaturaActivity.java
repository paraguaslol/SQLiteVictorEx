package com.dmb.sqlite.Asignatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dmb.sqlite.MainActivity;
import com.dmb.sqlite.R;

public class AsignaturaActivity extends AppCompatActivity {

    EditText aNombre,aHoras, aID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);

        this.aNombre = findViewById(R.id.aNombre);
        this.aHoras = findViewById(R.id.aHoras);
        this.aID = findViewById(R.id.aID);

    }

    public void clearSubject(View v){
        this.aNombre.setText("");
        this.aHoras.setText("");
    }

    public void insertSubject(View v){
        MainActivity.myDBAdapter.insertAsignatura(
                this.aHoras.getText().toString(),
                Integer.parseInt(this.aHoras.getText().toString()));

    }

    public void deleteAsignatura(View v){
        MainActivity.myDBAdapter.deleteAsignatura(Integer.parseInt(aID.getText().toString()));
    }
}
