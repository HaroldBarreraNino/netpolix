package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SesionAdmin extends AppCompatActivity {

    Button btnTablaVideos, btnTablaSeries, btnTablaColeccion, btnConsultas;

    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_admin);

        btnTablaVideos = (Button) findViewById(R.id.btnTablaVideos);
        btnTablaSeries = (Button) findViewById(R.id.btnTablaSeries);
        btnTablaColeccion = (Button) findViewById(R.id.btnTablaColeccion);
        btnConsultas = (Button) findViewById(R.id.btnConsultas);
        phpController = new PHPController(this);

        btnTablaVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.ReadAllVideos();
            }
        });

        btnTablaSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SesionAdmin.this, CRUD.class);
                i.putExtra("accion", "12");
                startActivity(i);
            }
        });

        btnTablaColeccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SesionAdmin.this, CRUD.class);
                i.putExtra("accion", "13");
                startActivity(i);
            }
        });

        btnConsultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SesionAdmin.this, ElegirConsulta.class);
                startActivity(i);
            }
        });
    }
}