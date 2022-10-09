package com.example.netpolixmovil;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Coleccion;
import models.Serie;
import models.Video;

public class PHPController {
    Context c;
    RequestQueue requestQueue;

    private static String IP = "192.168.10.15"; //Cambiar esta IP con la de tu internet

    //Persona URLs
    private static String URLREGISTER = "http://"+IP+"/netpolix/persona/register.php";
    private static String URLLOGIN = "http://"+IP+"/netpolix/persona/login.php?";

    //Video URLs
    private static String ULRCREATEVIDEO = "http://"+IP+"/netpolix/video/create.php";
    private static String URLREADALLVIDEO = "http://"+IP+"/netpolix/video/readAll.php";
    private static String URLDELETEVIDEO = "http://"+IP+"/netpolix/video/delete.php";

    //Serie URLs
    private static String ULRCREATESERIE = "http://"+IP+"/netpolix/serie/create.php";
    private static String ULRDELETESERIE = "http://"+IP+"/netpolix/serie/delete.php";
    private static String ULRREADALLSERIE = "http://"+IP+"/netpolix/serie/readAll.php";

    //Coleccion URLs
    private static String ULRCREATECOLECCION = "http://"+IP+"/netpolix/coleccion/create.php";
    private static String ULRDELETECOLECCION = "http://"+IP+"/netpolix/coleccion/delete.php";
    private static String ULRREADALLCOLECCION = "http://"+IP+"/netpolix/coleccion/readAll.php";

    //Consultas URLs
    private static String URLCONSULTA = "http://"+IP+"/netpolix/consultas/";
    private static String URLCONSULTACUATRO = "http://"+IP+"/netpolix/consultas/rfc4.php?idioma=";
    private static String URLCONSULTADOS = "http://"+IP+"/netpolix/consultas/rfc2.php?calificacion=";

    public PHPController(Context context){
        c = context;
        requestQueue = Volley.newRequestQueue(c);
    }

    //Persona
    public void Register(String ced, String nom, String fecha){

        final String cedula = ced;
        final String nombre_completo = nom;
        final String fecha_nacimiento = fecha;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLREGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "¡USUARIO REGISTRADO CON EXITO!", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al crear al usuario...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("cedula", cedula);
                params.put("nombre_completo", nombre_completo);
                params.put("fecha_nacimiento", fecha_nacimiento);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void Login(String nom, String ced){
        String cedula = "cedula="+ced;
        String nombre_completo = "&nombre_completo="+nom;
        String urllogin = URLLOGIN + cedula + nombre_completo;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urllogin,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(c, "¡INICIO DE SESION EXITOSA!", Toast.LENGTH_SHORT).show();
                        String id, nombre, apellido, correo, username, password;
                        try {
                            id = response.getString("id_Persona");
                            if (id.equals("1")){
                                Intent i = new Intent(c, SesionAdmin.class);
                                c.startActivity(i);
                            }else{
                                Intent i = new Intent(c, SesionUsuario.class);
                                i.putExtra("id_Persona", id);
                                c.startActivity(i);
                            }

                        }catch (JSONException e){
                            System.out.println("ERROR: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al logearse...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }

    //Video
    public void crearVideo(String tit, String dur, String cat, String act, String dir, String is, String cal, String idi){

        final String titulo = tit;
        final String duracion = dur;
        final String categoria = cat;
        final String actores = act;
        final String directores = dir;
        final String isan = is;
        final String calificacion = cal;
        final String idioma = idi;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ULRCREATEVIDEO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("-----------------------");
                        System.out.println("PELICULA CREADO CON EXITO");
                        Toast.makeText(c, "PELICULA CREADO CON EXITO", Toast.LENGTH_SHORT).show();
                        System.out.println("-----------------------");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("-----------------------");
                        System.out.println("ERROR CREANDO LA PELICULA");
                        Toast.makeText(c, "ERROR CREANDO LA PELICULA", Toast.LENGTH_SHORT).show();
                        System.out.println("Err: " + error.getMessage());
                        System.out.println("-----------------------");

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("titulo", titulo);
                params.put("duracion", duracion);
                params.put("categoria", categoria);
                params.put("actores", actores);
                params.put("directores", directores);
                params.put("isan", isan);
                params.put("calificacion", calificacion);
                params.put("idioma", idioma);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void DeleteVideo(String id){
        final String idvideo = id;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URLDELETEVIDEO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Delete Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Delete ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println("DELETE ERROR: " + error.getMessage());
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idvideo);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


    public void ReadAllVideos(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URLREADALLVIDEO,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Video> lista = generarListaVideos(response);
                        Intent intent = new Intent(c, MostrarTabla.class);
                        intent.putExtra("tipotabla", "Videos");
                        intent.putExtra("tipolista", lista);
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar Videos...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    public void generarCatalogo(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URLREADALLVIDEO,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Video> lista = generarListaVideos(response);
                        Intent intent = new Intent(c, Catalogo.class);
                        intent.putExtra("lista", lista);
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar Videos...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    private ArrayList<Video> generarListaVideos(JSONArray jsonArray){

        ArrayList<Video> listavideos = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                Video video = new Video();

                video.setId_Video(jsonArray.getJSONObject(i).getString("id_Video"));
                video.setTitulo(jsonArray.getJSONObject(i).getString("titulo"));
                video.setDuracion(jsonArray.getJSONObject(i).getString("duracion"));
                video.setCategoria(jsonArray.getJSONObject(i).getString("categoria"));
                video.setActores(jsonArray.getJSONObject(i).getString("actores"));
                video.setDirectores(jsonArray.getJSONObject(i).getString("directores"));
                video.setIsan(jsonArray.getJSONObject(i).getString("isan"));
                video.setCalificacion(jsonArray.getJSONObject(i).getString("calificacion"));
                video.setIdioma(jsonArray.getJSONObject(i).getString("idioma"));

                System.out.println(jsonArray.get(i).toString());
                listavideos.add(video);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------CONVERTIDO A ARRAYLIST---------");
        for (int i = 0; i < listavideos.size(); i++) {
            System.out.println(listavideos.get(i));
        }
        System.out.println("----------------------------------------");

        if (listavideos.isEmpty()){
            System.out.println("----------------------------");
            System.out.println("LA LISTA DE PERFILES ESTA VACIA");
            System.out.println(listavideos.size());
            System.out.println("----------------------------");
        }

        return listavideos;

    }

    //Serie
    public void crearSerie(String tit, String temp, String cap){
        final String titulo = tit;
        final String temporadas = temp;
        final String capitulos = cap;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ULRCREATESERIE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("-----------------------");
                        System.out.println("SERIE CREADO CON EXITO");
                        Toast.makeText(c, "SERIE CREADO CON EXITO", Toast.LENGTH_SHORT).show();
                        System.out.println("-----------------------");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("-----------------------");
                        System.out.println("ERROR CREANDO LA SERIE");
                        Toast.makeText(c, "ERROR CREANDO LA SERIE", Toast.LENGTH_SHORT).show();
                        System.out.println("Err: " + error.getMessage());
                        System.out.println("-----------------------");

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("titulo", titulo);
                params.put("temporadas", temporadas);
                params.put("capitulos", capitulos);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void DeleteSerie(String id){
        final String idserie = id;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ULRCREATESERIE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Delete Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Delete ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println("DELETE ERROR: " + error.getMessage());
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idserie);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void ReadAllSerie(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                ULRREADALLSERIE,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Serie> lista = generarListaSeries(response);
                        Intent intent = new Intent(c, MostrarTabla.class);
                        intent.putExtra("tipotabla", "Series");
                        intent.putExtra("tipolista", lista);
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar Videos...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    private ArrayList<Serie> generarListaSeries(JSONArray jsonArray){

        ArrayList<Serie> listaseries = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                Serie serie = new Serie();

                serie.setId_Serie(jsonArray.getJSONObject(i).getString("id_Serie"));
                serie.setTitulo(jsonArray.getJSONObject(i).getString("titulo"));
                serie.setTemporadas(jsonArray.getJSONObject(i).getString("temporadas"));
                serie.setCapitulos(jsonArray.getJSONObject(i).getString("capitulos"));

                System.out.println(jsonArray.get(i).toString());
                listaseries.add(serie);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------CONVERTIDO A ARRAYLIST---------");
        for (int i = 0; i < listaseries.size(); i++) {
            System.out.println(listaseries.get(i));
        }
        System.out.println("----------------------------------------");

        if (listaseries.isEmpty()){
            System.out.println("----------------------------");
            System.out.println("LA LISTA DE PERFILES ESTA VACIA");
            System.out.println(listaseries.size());
            System.out.println("----------------------------");
        }

        return listaseries;

    }

    //Coleccion
    public void ReadAllColeccion(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                ULRREADALLCOLECCION,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Coleccion> lista = generarListaColeccion(response);
                        Intent intent = new Intent(c, MostrarTabla.class);
                        intent.putExtra("tipotabla", "Colecciones");
                        intent.putExtra("tipolista", lista);
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar Videos...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    private ArrayList<Coleccion> generarListaColeccion(JSONArray jsonArray){

        ArrayList<Coleccion> listacoleccion = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                Coleccion coleccion = new Coleccion();

                coleccion.setId_Coleccion(jsonArray.getJSONObject(i).getString("id_Coleccion"));
                coleccion.setTitulo(jsonArray.getJSONObject(i).getString("titulo"));
                coleccion.setVolumen(jsonArray.getJSONObject(i).getString("volumen"));
                coleccion.setCapitulos(jsonArray.getJSONObject(i).getString("capitulos"));

                System.out.println(jsonArray.get(i).toString());
                listacoleccion.add(coleccion);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------CONVERTIDO A ARRAYLIST---------");
        for (int i = 0; i < listacoleccion.size(); i++) {
            System.out.println(listacoleccion.get(i));
        }
        System.out.println("----------------------------------------");

        if (listacoleccion.isEmpty()){
            System.out.println("----------------------------");
            System.out.println("LA LISTA DE PERFILES ESTA VACIA");
            System.out.println(listacoleccion.size());
            System.out.println("----------------------------");
        }

        return listacoleccion;

    }

    public void crearColeccion(String tit, String vol, String cap){
        final String titulo = tit;
        final String volumen = vol;
        final String capitulos = cap;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ULRCREATECOLECCION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("-----------------------");
                        System.out.println("COLECCION CREADO CON EXITO");
                        Toast.makeText(c, "COLECCION CREADO CON EXITO", Toast.LENGTH_SHORT).show();
                        System.out.println("-----------------------");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("-----------------------");
                        System.out.println("ERROR CREANDO LA COLECCION");
                        Toast.makeText(c, "ERROR CREANDO LA COLECCION", Toast.LENGTH_SHORT).show();
                        System.out.println("Err: " + error.getMessage());
                        System.out.println("-----------------------");

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("titulo", titulo);
                params.put("temporadas", volumen);
                params.put("capitulos", capitulos);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void DeleteColeccion(String id){
        final String idcoleccion = id;
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ULRDELETECOLECCION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(c, "Delete Succesful", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Delete ERROR", Toast.LENGTH_SHORT).show();
                        System.out.println("DELETE ERROR: " + error.getMessage());
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idcoleccion);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    //Consultas
    public void ReadAllConsulta(String numero){
        String urlconsulta = URLCONSULTA + numero;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                urlconsulta,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Intent intent = new Intent(c, ResultadoConsulta.class);
                        intent.putExtra("jsonarray", response.toString());
                        c.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar resultados...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    public void ReadAllConsultaCuatro(String numero){
        String urlconsulta = URLCONSULTACUATRO + numero;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                urlconsulta,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        EnviarJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar resultados...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    public void ReadAllConsultaDos(String numero){
        String urlconsulta = URLCONSULTADOS + numero;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                urlconsulta,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        EnviarJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, "Error al generar resultados...", Toast.LENGTH_SHORT).show();
                        System.out.println("----------------------------");
                        System.out.println("ERROR: " + error.getMessage());
                        System.out.println("----------------------------");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    private void EnviarJSON(JSONArray arr) {
        Intent intent = new Intent(c, ResultadoConsulta.class);
        intent.putExtra("jsonarray", arr.toString());
        c.startActivity(intent);
    }
}
