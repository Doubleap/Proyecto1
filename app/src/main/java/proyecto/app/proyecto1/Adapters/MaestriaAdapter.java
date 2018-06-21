package proyecto.app.proyecto1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import proyecto.app.proyecto1.Clases.App;
import proyecto.app.proyecto1.Modelo.Maestria;
import proyecto.app.proyecto1.R;

public class MaestriaAdapter extends ArrayAdapter {
    private ArrayList<Maestria> items;
    private int resourceId;
    private Context context;
    public MaestriaAdapter(Context context, int resourceId, ArrayList<Maestria> items)
    {
        super(context, resourceId, items);

        this.resourceId = resourceId;
        this.items = items;
        this.context = context;
    }

    public ArrayList<Maestria> getItems(){
        return items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        final Maestria dato = (Maestria) items.get(position);
        String nombre = dato.getName();
        if (convertView == null) {
            // Crear una celda si no ha sido creada. De lo contrario la celda se re-utiliza y debe limpiarse o refrescarse
            // View-Recycling
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_maestria, parent, false);
        }

        final TextView textoNombre = convertView.findViewById(R.id.name);
        final TextView description = convertView.findViewById(R.id.description);
        final TextView rank = convertView.findViewById(R.id.rank);
        ImageView imagen = convertView.findViewById(R.id.imagen_maestria);
        String url_imagen = App.context.getString(R.string.path_imagenes_maestrias) + dato.getId() + ".png";

        textoNombre.setText(nombre);
        description.setText(dato.getDescription());
        rank.setText( String.valueOf(dato.getRanks()));
        Picasso.get().load(url_imagen).error(App.context.getResources().getDrawable(R.drawable.imagennodisponible)).into(imagen);

        return convertView;
    }
}

