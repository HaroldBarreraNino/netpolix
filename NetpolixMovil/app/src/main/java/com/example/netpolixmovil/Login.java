package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText txtLogCedula, txtLogNombre;
    Button btnLogin, btnIrRegister;

    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogCedula = (EditText) findViewById(R.id.txtLogCedula);
        txtLogNombre = (EditText) findViewById(R.id.txtLogNombre);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnIrRegister = (Button) findViewById(R.id.btnIrRegister);
        phpController = new PHPController(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String nombre_completo, cedula;
            nombre_completo = txtLogNombre.getText().toString().trim();
            cedula = txtLogCedula.getText().toString().trim();
            phpController.Login(nombre_completo, cedula);
            }
        });

        btnIrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });
    }
}