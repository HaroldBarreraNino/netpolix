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
import models.Serie;

public class SerieAdapter extends BaseAdapter {

    Context c;
    ArrayList<Serie> listaserie;

    public SerieAdapter(Context c, ArrayList<Serie> listaserie) {
        this.c = c;
        this.listaserie = listaserie;
    }

    @Override
    public int getCount() {
        return listaserie.size();
    }

    @Override
    public Object getItem(int i) {
        return listaserie.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(c).inflate(R.layout.serie_item, null);//Decirle que layout va utilizar

        //Crear cada elemento del layout a utilizar, varia en cada caso
        TextView idserie = (TextView) view.findViewById(R.id.serie_id);
        TextView titulo = (TextView) view.findViewById(R.id.serie_titulo);
        TextView temporadas = (TextView) view.findViewById(R.id.serie_temporadas);
        TextView capitulos = (TextView) view.findViewById(R.id.serie_capitulos);

        //Llenar con datos los elementos creados
        Serie item = (Serie) getItem(i);
        idserie.setText(item.getId_Serie());
        titulo.setText(item.getTitulo());
        temporadas.setText(item.getTemporadas());
        capitulos.setText(item.getCapitulos());

        return view;
    }
}
