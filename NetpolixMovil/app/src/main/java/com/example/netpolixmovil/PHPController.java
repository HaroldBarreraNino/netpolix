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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PHPController {
    Context c;
    RequestQueue requestQueue;

    private static String IP = "192.168.10.15"; //Cambiar esta IP con la de tu internet

    //Persona URLs
    private static String URLREGISTER = "http://"+IP+"/netpolix/persona/register.php";
    private static String URLLOGIN = "http://"+IP+"/netpolix/persona/login.php?";

    public PHPController(Context context){
        c = context;
        requestQueue = Volley.newRequestQueue(c);
    }

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
                            nombre = response.getString("nombre");
                            apellido = response.getString("apellido");
                            correo = response.getString("correo");
                            username = response.getString("username");
                            password = response.getString("password");
                            String nombreCompleto = nombre + " " + apellido;

                            if (id.equals("1")){
                                Intent i = new Intent(c, SesionAdmin.class);
                                /*i.putExtra("usuario", nombreCompleto);
                                i.putExtra("usucorreo", correo);
                                i.putExtra("usuUsername", username);
                                i.putExtra("usuPassword", password);*/
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
}
