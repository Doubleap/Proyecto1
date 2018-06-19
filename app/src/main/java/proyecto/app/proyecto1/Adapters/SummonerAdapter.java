package proyecto.app.proyecto1.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import proyecto.app.proyecto1.Modelo.Summoner;
import proyecto.app.proyecto1.R;

public class SummonerAdapter extends PagerAdapter {
    private ArrayList<Summoner> items;
    private int resourceId;
    private Context context;
    public ArrayList<Summoner> getItems(){
        return items;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        //return super.getView(position, convertView, parent);
        final Summoner dato = (Summoner) items.get(position);
        String nombre = dato.getPlayerOrTeamName();
        String info = "Rank: "+dato.getQueueType()+" ("+dato.getTier()+" "+dato.getRank()+")";
        info += "Pertenence a la liga: "+dato.getLeagueName()+"\n";
        info += "Ganados: "+dato.getWins()+"\n";
        info += "Perdidas: "+dato.getLosses()+"\n";
        info += "Racha Ganadora: "+dato.isHotStreak();
        if (container == null)
        {
            // Crear una celda si no ha sido creada. De lo contrario la celda se re-utiliza y debe limpiarse o refrescarse
            // View-Recycling
            //container = LayoutInflater.from(context).inflate(R.layout.campeon, parent, false);
        }
        final TextView textoNombre = container.findViewById(R.id.textView2);
        TextView textoInfo = container.findViewById(R.id.info);
        ImageView imagen = container.findViewById(R.id.contactPic);

        Resources resources = container.getContext().getResources();
        String tier = dato.getTier();
        String rank = dato.getRank();
        if(dato.getTier() == null){
            tier = "bronze";
        }else{
            tier = tier.toLowerCase();
        }
        if(dato.getRank() == null){
            rank = "v";
        }else{
            rank = rank.toLowerCase();
        }
        final int resourceId = resources.getIdentifier(tier+"_"+rank+"", "drawable", container.getContext().getPackageName());

        textoNombre.setText(nombre);
        textoInfo.setText(info);
        imagen.setImageDrawable(resources.getDrawable(resourceId));
        //container.addView(button);

        return container;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object==view;

    }
}

