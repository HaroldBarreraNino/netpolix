package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

public class ResultadoConsulta extends AppCompatActivity {

    TextView resultadoConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_consulta);

        resultadoConsulta = (TextView) findViewById(R.id.resultadoConsulta);

        Intent datos = getIntent();
        String jsonarray = datos.getStringExtra("jsonarray");

        try {
            JSONArray arr = new JSONArray(jsonarray);
            resultadoConsulta.setText(arr.toString());
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}