package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRactivity extends AppCompatActivity {

    Button btnescanearQR;
    ImageView imagenQR;

    String contenidoqr = "abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qractivity);

        btnescanearQR = (Button) findViewById(R.id.btnEscanearQR);
        imagenQR = (ImageView) findViewById(R.id.imagenQR);

        try {
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.encodeBitmap(contenidoqr, BarcodeFormat.QR_CODE, 750, 750);
            imagenQR.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }

        btnescanearQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QRactivity.this, InformacionGeneralActivity.class);
                startActivity(i);
            }
        });
    }
}