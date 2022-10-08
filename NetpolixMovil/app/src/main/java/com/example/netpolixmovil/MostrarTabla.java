package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.VideoAdapter;
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
            case "Comentarios":
                //tablaComentarios();
                break;
            case "Perfiles":
                //tablaPerfiles();
                break;
        }
    }

    public void tablaVideos(){
        ArrayList<Video> listausuarios = (ArrayList<Video>) getIntent().getSerializableExtra("tipolista");
        VideoAdapter adapter = new VideoAdapter(this, listausuarios);
        listadatos.setAdapter(adapter);
        listadatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*int id = i + 1;
                System.out.println("USUARIO = [" + id + "]");
                Intent intent = new Intent(MostrarTablaActivity.this, CrudActivity.class);
                intent.putExtra("accion", "21");
                intent.putExtra("id", listausuarios.get(i).getId());
                intent.putExtra("nombre", listausuarios.get(i).getNombre());
                intent.putExtra("apellido", listausuarios.get(i).getApellido());
                intent.putExtra("correo", listausuarios.get(i).getCorreo());
                intent.putExtra("username", listausuarios.get(i).getUsername());
                intent.putExtra("password", listausuarios.get(i).getPassword());
                startActivity(intent);*/
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
}