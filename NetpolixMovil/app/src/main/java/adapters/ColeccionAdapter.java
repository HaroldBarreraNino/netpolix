package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.netpolixmovil.R;

import java.util.ArrayList;

import models.Coleccion;
import models.Video;

public class ColeccionAdapter extends BaseAdapter {

    Context c;
    ArrayList<Coleccion> listacoleccion;

    public ColeccionAdapter(Context c, ArrayList<Coleccion> listacoleccion) {
        this.c = c;
        this.listacoleccion = listacoleccion;
    }

    @Override
    public int getCount() {
        return listacoleccion.size();
    }

    @Override
    public Object getItem(int i) {
        return listacoleccion.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(c).inflate(R.layout.coleccion_item, null);//Decirle que layout va utilizar

        //Crear cada elemento del layout a utilizar, varia en cada caso
        TextView idcoleccion = (TextView) view.findViewById(R.id.coleccion_id);
        TextView titulo = (TextView) view.findViewById(R.id.coleccion_titulo);
        TextView volumen = (TextView) view.findViewById(R.id.coleccion_volumen);
        TextView capitulos = (TextView) view.findViewById(R.id.coleccion_capitulos);

        //Llenar con datos los elementos creados
        Coleccion item = (Coleccion) getItem(i);
        idcoleccion.setText(item.getId_Coleccion());
        titulo.setText(item.getTitulo());
        volumen.setText(item.getVolumen());
        capitulos.setText(item.getCapitulos());

        return view;
    }
}
