package proyecto.app.proyecto1.Fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import proyecto.app.proyecto1.Adapters.SummonerAdapter;
import proyecto.app.proyecto1.Clases.HttpCliente;
import proyecto.app.proyecto1.Modelo.ListaCampeones;
import proyecto.app.proyecto1.Modelo.Summoner;
import proyecto.app.proyecto1.R;

public class DatosFragment extends Fragment {

    private SummonerAdapter adapter;
    private HttpCliente clienteWeb;

    //private Response.Listener<String> callbackExito;
    private Response.Listener<JSONArray> callbackExito;
    private Response.ErrorListener callbackError;
    private final String URL_GOOGLE = "http://www.google.com";
    private final String URL_JSON = "http://httpbin.org/json";
    private final String URL_PAISES = "https://restcountries.eu/rest/v2/name/colombia?fullText=true";

    public DatosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        final View vista = inflater.inflate(R.layout.fragment_summoner, container, false);



        //callbackExito = new Response.Listener<String>() {
        callbackExito = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject respuesta=null;
                try {
                    respuesta = (JSONObject) response.get(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                Summoner summoner = gson.fromJson(respuesta.toString(), Summoner.class);

                ImageView imagen = container.findViewById(R.id.tier_image);
                TextView name = container.findViewById(R.id.name_text);
                TextView header = container.findViewById(R.id.header_text);
                TextView footer = container.findViewById(R.id.footer_text);

                String info = "Rank: "+summoner.getQueueType()+" ( "+summoner.getTier()+" "+summoner.getRank()+" )\n";
                info += "Ganados: "+summoner.getWins()+"\n";
                info += "Perdidas: "+summoner.getLosses()+"\n";
                info += "Racha Ganadora: "+summoner.isHotStreak();

                String info_footer = summoner.getLeagueName()+"\n";
                info_footer += "Puntos: "+summoner.getLeaguePoints()+"\n";
                info_footer += "Sangre Fresca: "+summoner.isFreshBlood()+"\n";
                info_footer += "Inactivo: "+summoner.isInactive()+"\n";
                info_footer += "Veterano: "+summoner.isVeteran();

                Resources resources = container.getContext().getResources();
                String tier = summoner.getTier();
                String rank = summoner.getRank();
                if(summoner.getTier() == null){
                    tier = "bronze";
                }else{
                    tier = tier.toLowerCase();
                }
                if(summoner.getRank() == null){
                    rank = "v";
                }else{
                    rank = rank.toLowerCase();
                }
                final int resourceId = resources.getIdentifier(tier+"_"+rank+"", "drawable", container.getContext().getPackageName());

                name.setText(summoner.getPlayerOrTeamName());
                header.setText(info);
                footer.setText(info_footer);
                imagen.setImageDrawable(resources.getDrawable(resourceId));

                final ViewPager lista = vista.findViewById(R.id.lista);

            }
        };

        callbackError  = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(container.getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        clienteWeb = new HttpCliente(getActivity());
        clienteWeb.GetJsonArray(getString(R.string.API_URL_SUMMONER)+"878661?api_key="+getString(R.string.API_KEY), callbackExito, callbackError,"1");

        return vista;
    }
}
