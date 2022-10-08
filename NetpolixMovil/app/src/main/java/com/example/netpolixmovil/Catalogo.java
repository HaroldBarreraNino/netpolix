package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.VideoAdapter;
import models.Video;

public class Catalogo extends AppCompatActivity {

    ListView catalogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        catalogo = (ListView) findViewById(R.id.ListaCatalogo);
        ArrayList<Video> listavideos = (ArrayList<Video>) getIntent().getSerializableExtra("lista");
        VideoAdapter adapter = new VideoAdapter(this, listavideos);
        catalogo.setAdapter(adapter);
        catalogo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Catalogo.this, "¡PELICULA ALQUILADA CON EXITO!", Toast.LENGTH_LONG).show();
            }
        });
    }
}