package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ElegirConsulta extends AppCompatActivity {

    Button rfc1, rfc2, rfc3, rfc4, rfc5, rfc6, rfc7, rfc8, rfc9;

    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_consulta);

        rfc1 = (Button) findViewById(R.id.rfc1);
        rfc2 = (Button) findViewById(R.id.rfc2);
        rfc3 = (Button) findViewById(R.id.rfc3);
        rfc4 = (Button) findViewById(R.id.rfc4);
        rfc5 = (Button) findViewById(R.id.rfc5);
        rfc6 = (Button) findViewById(R.id.rfc6);
        rfc7 = (Button) findViewById(R.id.rfc7);
        rfc8 = (Button) findViewById(R.id.rfc8);
        rfc9 = (Button) findViewById(R.id.rfc9);
        phpController = new PHPController(this);

        rfc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.ReadAllConsulta("rfc1.php");
            }
        });

        rfc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.ReadAllConsulta("rfc2.php");
            }
        });

        rfc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.ReadAllConsulta("rfc3.php");
            }
        });

        rfc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ElegirConsulta.this, ResultadoConsulta2.class);
                startActivity(i);
            }
        });

        rfc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.ReadAllConsulta("rfc5.php");
            }
        });

        rfc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.ReadAllConsulta("rfc6.php");
            }
        });

        rfc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.ReadAllConsulta("rfc7.php");
            }
        });

        rfc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.ReadAllConsulta("rfc8.php");
            }
        });

        rfc9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phpController.ReadAllConsulta("rfc9.php");
            }
        });
    }
}