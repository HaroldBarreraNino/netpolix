package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SesionUsuario extends AppCompatActivity {

    ImageButton btnIrPqr, btnIrVerPeliculas, btnIrReferidos;
    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_usuario);

        btnIrPqr = (ImageButton) findViewById(R.id.btnIrPqr);
        btnIrVerPeliculas = (ImageButton) findViewById(R.id.btnIrVerPeliculas);
        btnIrReferidos = (ImageButton) findViewById(R.id.btnIrReferidos);
        phpController = new PHPController(this);

        btnIrPqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SesionUsuario.this, PQR.class);
                startActivity(i);
            }
        });

        btnIrVerPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.generarCatalogo();
            }
        });

        btnIrReferidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SesionUsuario.this, Referidos.class);
                startActivity(i);
            }
        });
    }
}