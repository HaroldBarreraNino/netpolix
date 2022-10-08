package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.netpolixmovil.R;

import java.util.ArrayList;

import models.Video;

public class VideoAdapter extends BaseAdapter {

    Context c;
    ArrayList<Video> listavideo;

    public VideoAdapter(Context c, ArrayList<Video> listavideo) {
        this.c = c;
        this.listavideo = listavideo;
    }

    @Override
    public int getCount() {
        return listavideo.size();
    }

    @Override
    public Object getItem(int i) {
        return listavideo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(c).inflate(R.layout.video_item, null);//Decirle que layout va utilizar

        //Crear cada elemento del layout a utilizar, varia en cada caso
        TextView idvideo = (TextView) view.findViewById(R.id.video_id);
        TextView titulo = (TextView) view.findViewById(R.id.video_titulo);
        TextView duracion = (TextView) view.findViewById(R.id.video_duracion);
        TextView categoria = (TextView) view.findViewById(R.id.video_categoria);
        TextView actores = (TextView) view.findViewById(R.id.video_actores);
        TextView directores = (TextView) view.findViewById(R.id.video_directores);
        TextView isan = (TextView) view.findViewById(R.id.video_isan);
        TextView calificacion = (TextView) view.findViewById(R.id.video_calificacion);
        TextView idioma = (TextView) view.findViewById(R.id.video_idioma);

        //Llenar con datos los elementos creados
        Video item = (Video) getItem(i);
        idvideo.setText(item.getId_Video());
        titulo.setText(item.getTitulo());
        duracion.setText(item.getDuracion());
        categoria.setText(item.getCategoria());
        actores.setText(item.getActores());
        directores.setText(item.getDirectores());
        isan.setText(item.getIsan());
        calificacion.setText(item.getCalificacion());
        idioma.setText(item.getIdioma());

        return view;
    }
}
