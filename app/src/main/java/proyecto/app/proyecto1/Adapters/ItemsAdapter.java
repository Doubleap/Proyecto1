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
import proyecto.app.proyecto1.Modelo.Campeon;
import proyecto.app.proyecto1.Modelo.Items;
import proyecto.app.proyecto1.R;

public class ItemsAdapter extends ArrayAdapter {
    private ArrayList<Items> items;
    private int resourceId;
    private Context context;
    public ItemsAdapter(Context context, int resourceId, ArrayList<Items> items)
    {
        super(context, resourceId, items);

        this.resourceId = resourceId;
        this.items = items;
        this.context = context;
    }

    public ArrayList<Items> getItems(){
        return items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
            final Items dato = (Items) items.get(position);
            String nombre = dato.getName();
            if (convertView == null) {
                // Crear una celda si no ha sido creada. De lo contrario la celda se re-utiliza y debe limpiarse o refrescarse
                // View-Recycling
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_item, parent, false);
            }

            final TextView textoNombre = convertView.findViewById(R.id.textViewi);
            ImageView imagen = convertView.findViewById(R.id.contactPici);
            String url_imagen = App.context.getString(R.string.path_imagenes_articulos) + dato.getId() + ".png";

            if(nombre.length() >= 13)
                textoNombre.setText(nombre.substring(0, 12));
            else
                textoNombre.setText(nombre);
            Picasso.get().load(url_imagen).error(App.context.getResources().getDrawable(R.drawable.imagennodisponible)).into(imagen);

        return convertView;
    }
}

