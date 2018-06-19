package proyecto.app.proyecto1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import proyecto.app.proyecto1.CampeonActivity;
import proyecto.app.proyecto1.Modelo.Campeon;
import proyecto.app.proyecto1.R;

public class CampeonAdapter  extends ArrayAdapter{
    private ArrayList<Campeon> items;
    private int resourceId;
    private Context context;
    public CampeonAdapter(Context context, int resourceId, ArrayList<Campeon> items)
    {
        super(context, resourceId, items);

        this.resourceId = resourceId;
        this.items = items;
        this.context = context;
    }

    public ArrayList<Campeon> getItems(){
        return items;
    }

    /*@Nullable
    @Override
    public Campeon getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }*/

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        final Campeon dato = (Campeon) items.get(position);
        String nombre = dato.getName();
        String info = "";
        if (convertView == null)
        {
            // Crear una celda si no ha sido creada. De lo contrario la celda se re-utiliza y debe limpiarse o refrescarse
            // View-Recycling
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.campeon, parent, false);
        }
        /*final TextView textoNombre = convertView.findViewById(R.id.textoNombre);
        textoNombre.setText(nombre);
        ImageView imagen = convertView.findViewById(R.id.contactPic);
        String url_imagen = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/"+dato.getKey()+"_0.jpg";
        Picasso.get().load(url_imagen).into(imagen);*/

        ProgressBar dificultad = convertView.findViewById(R.id.dificultad);
        ProgressBar ataque = convertView.findViewById(R.id.ataque);
        ProgressBar defensa = convertView.findViewById(R.id.defensa);
        ProgressBar magia = convertView.findViewById(R.id.magia);
        final TextView textoNombre = convertView.findViewById(R.id.textView2);
        TextView textoInfo = convertView.findViewById(R.id.info);
        ImageView imagen = convertView.findViewById(R.id.contactPic);
        String url_imagen = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/"+dato.getKey()+"_0.jpg";

        dificultad.setProgress(dato.getInfo().getDifficulty());
        ataque.setProgress(dato.getInfo().getAttack());
        defensa.setProgress(dato.getInfo().getDefense());
        magia.setProgress(dato.getInfo().getMagic());
        textoNombre.setText(nombre);
        textoInfo.setText(info);
        Picasso.get().load(url_imagen).into(imagen);

        return convertView;
    }
}
