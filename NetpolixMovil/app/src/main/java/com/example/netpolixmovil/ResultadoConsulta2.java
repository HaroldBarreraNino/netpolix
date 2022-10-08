package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadoConsulta2 extends AppCompatActivity {

    EditText campoConsulta;
    Button btnEnviarConsulta;

    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_consulta2);

        campoConsulta = (EditText) findViewById(R.id.campoConsulta);
        btnEnviarConsulta = (Button) findViewById(R.id.btnEnviarConsulta);
        phpController = new PHPController(this);

        btnEnviarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = campoConsulta.getText().toString().trim();
                phpController.ReadAllConsultaCuatro(numero);
            }
        });
    }
}