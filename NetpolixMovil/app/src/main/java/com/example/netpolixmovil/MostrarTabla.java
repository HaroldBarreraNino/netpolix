package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.ColeccionAdapter;
import adapters.SerieAdapter;
import adapters.VideoAdapter;
import models.Coleccion;
import models.Serie;
import models.Video;

public class MostrarTabla extends AppCompatActivity {

    ListView listadatos;
    Button btnCrearDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tabla);

        btnCrearDato = (Button) findViewById(R.id.btnCrearDato);
        listadatos = (ListView) findViewById(R.id.listadatos);

        Intent datos = getIntent();
        String tipotabla = datos.getStringExtra("tipotabla");

        switch (tipotabla){
            case "Videos":
                tablaVideos();
                break;
            case "Colecciones":
                tablaColecciones();
                break;
            case "Series":
                tablaSeries();
                break;
        }
    }

    public void tablaVideos(){
        ArrayList<Video> listavideos = (ArrayList<Video>) getIntent().getSerializableExtra("tipolista");
        VideoAdapter adapter = new VideoAdapter(this, listavideos);
        listadatos.setAdapter(adapter);
        listadatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = i + 1;
                Intent intent = new Intent(MostrarTabla.this, CRUD.class);
                intent.putExtra("accion", "21");
                intent.putExtra("id", listavideos.get(i).getId_Video());
                intent.putExtra("titulo", listavideos.get(i).getTitulo());
                intent.putExtra("duracion", listavideos.get(i).getDuracion());
                intent.putExtra("categoria", listavideos.get(i).getCategoria());
                intent.putExtra("actores", listavideos.get(i).getActores());
                intent.putExtra("directores", listavideos.get(i).getDirectores());
                intent.putExtra("isan", listavideos.get(i).getIsan());
                intent.putExtra("calificacion", listavideos.get(i).getCalificacion());
                intent.putExtra("idioma", listavideos.get(i).getIdioma());
                startActivity(intent);
            }
        });
        btnCrearDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTabla.this, CRUD.class);
                i.putExtra("accion", "11");
                startActivity(i);
            }
        });
    }

    public void tablaColecciones(){
        ArrayList<Coleccion> listacolecciones = (ArrayList<Coleccion>) getIntent().getSerializableExtra("tipolista");
        ColeccionAdapter adapter = new ColeccionAdapter(this, listacolecciones);
        listadatos.setAdapter(adapter);
        listadatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = i + 1;
                Intent intent = new Intent(MostrarTabla.this, CRUD.class);
                intent.putExtra("accion", "22");
                intent.putExtra("id", listacolecciones.get(i).getId_Coleccion());
                intent.putExtra("titulo", listacolecciones.get(i).getTitulo());
                intent.putExtra("volumen", listacolecciones.get(i).getVolumen());
                intent.putExtra("capitulos", listacolecciones.get(i).getCapitulos());
                startActivity(intent);
            }
        });
        btnCrearDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTabla.this, CRUD.class);
                i.putExtra("accion", "12");
                startActivity(i);
            }
        });
    }

    public void tablaSeries(){
        ArrayList<Serie> listaseries = (ArrayList<Serie>) getIntent().getSerializableExtra("tipolista");
        SerieAdapter adapter = new SerieAdapter(this, listaseries);
        listadatos.setAdapter(adapter);
        listadatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = i + 1;
                Intent intent = new Intent(MostrarTabla.this, CRUD.class);
                intent.putExtra("accion", "23");
                intent.putExtra("id", listaseries.get(i).getId_Serie());
                intent.putExtra("titulo", listaseries.get(i).getTitulo());
                intent.putExtra("temporadas", listaseries.get(i).getTemporadas());
                intent.putExtra("capitulos", listaseries.get(i).getCapitulos());
                startActivity(intent);
            }
        });
        btnCrearDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTabla.this, CRUD.class);
                i.putExtra("accion", "13");
                startActivity(i);
            }
        });
    }
}