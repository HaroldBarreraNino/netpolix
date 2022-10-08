package com.example.netpolixmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CRUD extends AppCompatActivity {

    EditText campoId, campo1, campo2, campo3, campo4, campo5, campo6, campo7, campo8;
    Button editarCampos, eliminarCampos, crearCampos;

    PHPController controller;

    Intent datosrecibidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        campoId = (EditText) findViewById(R.id.EditcampoId);
        campo1 = (EditText) findViewById(R.id.Editcampo1);
        campo2 = (EditText) findViewById(R.id.Editcampo2);
        campo3 = (EditText) findViewById(R.id.Editcampo3);
        campo4 = (EditText) findViewById(R.id.Editcampo4);
        campo5 = (EditText) findViewById(R.id.Editcampo5);
        campo6 = (EditText) findViewById(R.id.Editcampo6);
        campo7 = (EditText) findViewById(R.id.Editcampo7);
        campo8 = (EditText) findViewById(R.id.Editcampo8);
        editarCampos = (Button) findViewById(R.id.btnEditarCampos);
        eliminarCampos = (Button) findViewById(R.id.btnEliminarCampos);
        crearCampos = (Button) findViewById(R.id.btnCrearCampos);

        controller = new PHPController(this);

        datosrecibidos = getIntent();
        String accion = datosrecibidos.getStringExtra("accion");

        switch (accion){
            case "11":
                CrearVideo();
                break;
            case "12":
                CrearSerie();
                break;
            case "13":
                CrearColeccion();
                break;
            case "14":
                //CrearComentario();
                break;
            case "15":
                //CrearPublicacion();
            case "21":
                EditarEliminarVideo();
                break;
            case "22":
                //EditarEliminarImagen();
                break;
            case "23":
                //EditarEliminarPerfil();
                break;
            case "24":
                //EditarEliminarComentario();
                break;
            case "25":
                //EditarEliminarPublicacion();
        }

    }

    //CREATE
    private void CrearVideo(){
        //Campos desactivados
        campoId.setVisibility(View.INVISIBLE);
        eliminarCampos.setVisibility(View.INVISIBLE);
        editarCampos.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        campo4.setVisibility(View.VISIBLE);
        campo5.setVisibility(View.VISIBLE);
        crearCampos.setVisibility(View.VISIBLE);

        campo1.setHint("Titulo");
        campo2.setHint("Duracion");
        campo3.setHint("Categoria");
        campo4.setHint("Actores");
        campo5.setHint("Directores");
        campo6.setHint("ISAN");
        campo7.setHint("Calificacion");
        campo8.setHint("Idioma");

        crearCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = campo1.getText().toString().trim();
                String duracion = campo2.getText().toString().trim();
                String categoria = campo3.getText().toString().trim();
                String actores = campo4.getText().toString().trim();
                String directores = campo5.getText().toString().trim();
                String isan = campo6.getText().toString().trim();
                String calificacion = campo7.getText().toString().trim();
                String idioma = campo8.getText().toString().trim();
                controller.crearVideo(titulo, duracion, categoria, actores, directores, isan, calificacion, idioma);
            }
        });
    }

    private void CrearSerie(){
        //Campos desactivados
        campoId.setVisibility(View.INVISIBLE);
        eliminarCampos.setVisibility(View.INVISIBLE);
        editarCampos.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        campo4.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);
        campo6.setVisibility(View.INVISIBLE);
        campo7.setVisibility(View.INVISIBLE);
        campo8.setVisibility(View.INVISIBLE);
        crearCampos.setVisibility(View.VISIBLE);

        campo1.setHint("Titulo");
        campo2.setHint("Temporadas");
        campo3.setHint("Capitulos");

        crearCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = campo1.getText().toString().trim();
                String temporadas = campo2.getText().toString().trim();
                String capitulos = campo3.getText().toString().trim();
                controller.crearSerie(titulo, temporadas, capitulos);
            }
        });
    }

    private void CrearColeccion(){
        //Campos desactivados
        campoId.setVisibility(View.INVISIBLE);
        eliminarCampos.setVisibility(View.INVISIBLE);
        editarCampos.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        campo4.setVisibility(View.INVISIBLE);
        campo5.setVisibility(View.INVISIBLE);
        campo6.setVisibility(View.INVISIBLE);
        campo7.setVisibility(View.INVISIBLE);
        campo8.setVisibility(View.INVISIBLE);
        crearCampos.setVisibility(View.VISIBLE);

        campo1.setHint("Titulo");
        campo2.setHint("Volumen");
        campo3.setHint("Capitulos");

        crearCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = campo1.getText().toString().trim();
                String volumen = campo2.getText().toString().trim();
                String capitulos = campo3.getText().toString().trim();
                controller.crearColeccion(titulo, volumen, capitulos);
            }
        });
    }

    //EDIT n DELETE
    private void EditarEliminarVideo(){
        //Campos desactivados
        crearCampos.setVisibility(View.INVISIBLE);

        //Campos Activados
        campo1.setVisibility(View.VISIBLE);
        campo2.setVisibility(View.VISIBLE);
        campo3.setVisibility(View.VISIBLE);
        campo4.setVisibility(View.VISIBLE);
        campo5.setVisibility(View.VISIBLE);
        campo6.setVisibility(View.VISIBLE);
        campo7.setVisibility(View.VISIBLE);
        campo8.setVisibility(View.VISIBLE);
        campoId.setVisibility(View.VISIBLE);
        eliminarCampos.setVisibility(View.VISIBLE);
        editarCampos.setVisibility(View.VISIBLE);

        campoId.setText(datosrecibidos.getStringExtra("id"));
        campo1.setText(datosrecibidos.getStringExtra("titulo"));
        campo2.setText(datosrecibidos.getStringExtra("duracion"));
        campo3.setText(datosrecibidos.getStringExtra("categoria"));
        campo4.setText(datosrecibidos.getStringExtra("actores"));
        campo5.setText(datosrecibidos.getStringExtra("directores"));
        campo6.setText(datosrecibidos.getStringExtra("isan"));
        campo7.setText(datosrecibidos.getStringExtra("calificacion"));
        campo8.setText(datosrecibidos.getStringExtra("idioma"));

        eliminarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = campoId.getText().toString().trim();
                controller.DeleteVideo(id);
            }
        });
    }
}