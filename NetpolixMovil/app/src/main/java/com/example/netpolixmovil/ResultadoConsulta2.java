package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        Intent datos = getIntent();
        String consulta = datos.getStringExtra("consulta");

        btnEnviarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (consulta.equals("2")){
                    String numero = campoConsulta.getText().toString().trim();
                    phpController.ReadAllConsultaDos(numero);
                }
                if (consulta.equals("4")){
                    String numero = campoConsulta.getText().toString().trim();
                    phpController.ReadAllConsultaCuatro(numero);
                }
            }
        });
    }
}