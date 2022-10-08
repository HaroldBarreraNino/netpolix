package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Referidos extends AppCompatActivity {

    EditText campoReferido;
    Button btnEnviarReferido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referidos);

        campoReferido = (EditText) findViewById(R.id.campoReferido);
        btnEnviarReferido = (Button) findViewById(R.id.btnEnviarReferido);
        btnEnviarReferido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Referidos.this, "¡GRACIAS! Nos comunicaremos con la persona referida muy pronto.", Toast.LENGTH_LONG).show();
            }
        });
    }
}