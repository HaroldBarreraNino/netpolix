package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformacionGeneralActivity extends AppCompatActivity {

    TextView textoModelo, textoInventario, textoSerial, textoIp;
    Button btnAdmin;

    String modelo = "DELL";
    String inventario = "Abastecidos por el momento, requiere monitoreo futuro";
    String serial = "JKE9738000";
    String ip = "177.16.12.3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_general);

        textoModelo = (TextView) findViewById(R.id.textoModelo);
        textoInventario = (TextView) findViewById(R.id.textoInventario);
        textoSerial = (TextView) findViewById(R.id.textoSerial);
        textoIp = (TextView) findViewById(R.id.textoIp);
        btnAdmin = (Button) findViewById(R.id.btnAdmin);

        textoModelo.setText(modelo);
        textoInventario.setText(inventario);
        textoSerial.setText(serial);
        textoIp.setText(ip);

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InformacionGeneralActivity.this, SesionAdmin.class);
                startActivity(i);
            }
        });
    }
}