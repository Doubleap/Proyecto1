package proyecto.app.proyecto1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import proyecto.app.proyecto1.Modelo.Campeon;
import proyecto.app.proyecto1.R;

public class CampeonAdapter  extends ArrayAdapter{
    private ArrayList<Campeon> items;
    private int resourceId;

    public CampeonAdapter(Context context, int resourceId, ArrayList<Campeon> items)
    {
        super(context, resourceId, items);

        this.resourceId = resourceId;
        this.items = items;
    }

    public ArrayList<Campeon> getItems(){
        return items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Campeon dato = (Campeon) items.get(position);
        String nombre = dato.getName();
        String info = "Dificultad: "+dato.getInfo().getDifficulty()+"\n";
        info += "Ataque: "+dato.getInfo().getAttack()+"\n";
        info += "Defensa: "+dato.getInfo().getDefense()+"\n";
        info += "Magia: "+dato.getInfo().getMagic();
        if (convertView == null)
        {
            // Crear una celda si no ha sido creada. De lo contrario la celda se re-utiliza y debe limpiarse o refrescarse
            // View-Recycling
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.campeon, parent, false);
        }
        TextView textoNombre = convertView.findViewById(R.id.textView2);
        TextView textoInfo = convertView.findViewById(R.id.info);
        ImageView imagen = convertView.findViewById(R.id.contactPic);
        String url_imagen = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/"+dato.getKey()+"_0.jpg";

        textoNombre.setClickable(false);
        textoInfo.setClickable(false);
        imagen.setClickable(false);

        textoNombre.setText(nombre);
        textoInfo.setText(info);
        Picasso.get().load(url_imagen).into(imagen);

        return convertView;
    }
}
