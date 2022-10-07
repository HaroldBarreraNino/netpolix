package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText txtRegCedula, txtRegNombre, txtRegFecha;
    Button btnRegister, btnIrLogin;

    PHPController phpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtRegCedula = (EditText) findViewById(R.id.txtRegCedula);
        txtRegNombre = (EditText) findViewById(R.id.txtRegNombre);
        txtRegFecha = (EditText) findViewById(R.id.txtRegFecha);
        btnIrLogin = (Button) findViewById(R.id.btnIrLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        phpController = new PHPController(this);

        btnIrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cedula, nombre_completo, fecha_nacimiento;
                cedula = txtRegCedula.getText().toString().trim();
                nombre_completo = txtRegNombre.getText().toString().trim();
                fecha_nacimiento = txtRegFecha.getText().toString().trim();
                phpController.Register(cedula, nombre_completo, fecha_nacimiento);
            }
        });
    }


}