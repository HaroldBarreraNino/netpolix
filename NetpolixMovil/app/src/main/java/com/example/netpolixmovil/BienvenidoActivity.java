package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BienvenidoActivity extends AppCompatActivity {

    EditText txtDocumento;
    Button gobtn, exitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        txtDocumento = (EditText) findViewById(R.id.txtDocumento);
        gobtn = (Button) findViewById(R.id.gobtn);
        exitbtn = (Button) findViewById(R.id.exitbtn);

        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BienvenidoActivity.this, Login.class);
                startActivity(i);
            }
        });

        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtDocumento.getText().toString().equals("")){
                    Toast.makeText(BienvenidoActivity.this, "Porfavor, inserte su documento", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i = new Intent(BienvenidoActivity.this, QRactivity.class);
                    startActivity(i);
                }
            }
        });
    }
}