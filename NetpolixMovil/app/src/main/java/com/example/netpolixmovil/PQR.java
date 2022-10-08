package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PQR extends AppCompatActivity {

    Button btnEnviarPqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pqr);

        btnEnviarPqr = (Button) findViewById(R.id.btnEnviarPqr);
        btnEnviarPqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PQR.this, "¡GRACIAS! Nuestros empleados recibirar pronto tu mensaje.", Toast.LENGTH_LONG).show();
            }
        });
    }
}