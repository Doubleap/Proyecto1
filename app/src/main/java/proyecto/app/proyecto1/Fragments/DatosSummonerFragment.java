package proyecto.app.proyecto1.Fragments;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
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
import proyecto.app.proyecto1.Clases.App;
import proyecto.app.proyecto1.Clases.HttpCliente;
import proyecto.app.proyecto1.Modelo.ListaCampeones;
import proyecto.app.proyecto1.Modelo.Summoner;
import proyecto.app.proyecto1.R;

public class DatosSummonerFragment extends Fragment {

    private SummonerAdapter adapter;
    private HttpCliente clienteWeb;
    private HttpCliente clienteWeb2;

    //private Response.Listener<String> callbackExito;
    private Response.Listener<JSONArray> callbackExito;
    private Response.Listener<JSONObject> callbackExitoP;
    private Response.ErrorListener callbackError;
    private Response.ErrorListener callbackErrorP;
    private final String URL_GOOGLE = "http://www.google.com";
    private final String URL_JSON = "http://httpbin.org/json";
    private final String URL_PAISES = "https://restcountries.eu/rest/v2/name/colombia?fullText=true";

    public DatosSummonerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle=getArguments();

        //here is your list array
        ArrayList<String> parametros = (ArrayList<String>)bundle.get("argumentos");
        String summoner = parametros.get(0);
        final View vista = inflater.inflate(R.layout.fragment_summoner, container, false);
        SummonerAdapter summonerAdapter = new SummonerAdapter();
        callbackExitoP = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String idSummoner=null;
                try {
                    idSummoner = response.getString("id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbackExito = new Response.Listener<JSONArray>() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResponse(JSONArray response) {
                        //adapter = new SummonerAdapter();
                        JSONObject respuesta = null;
                        if (respuesta != null) {
                            for (int x = 0; x < response.length();x++) {
                                try {
                                    respuesta = (JSONObject) response.get(x);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                Gson gson = new Gson();
                                Summoner summoner = gson.fromJson(respuesta.toString(), Summoner.class);

                                ImageView imagen = container.findViewById(R.id.tier_image);
                                ImageView imagen_racha = container.findViewById(R.id.racha_image);
                                TextView header = container.findViewById(R.id.header_text);
                                TextView puntos = container.findViewById(R.id.puntos_text);
                                TextView name = container.findViewById(R.id.name_text);
                                TextView ganadas = container.findViewById(R.id.ganadas_text);
                                TextView perdidas = container.findViewById(R.id.perdidas_text);
                                TextView footer = container.findViewById(R.id.footer_text);
                                TextView league = container.findViewById(R.id.league_text);

                                String info = "" + summoner.getQueueType() + " ( " + summoner.getTier() + " " + summoner.getRank() + " )";
                                String p = String.valueOf(summoner.getLeaguePoints());
                                String info_footer = "Encendido:" + summoner.isHotStreak() + " | ";
                                info_footer += "Sangre Fresca: " + summoner.isFreshBlood() + " | ";
                                info_footer += "Inactivo: " + summoner.isInactive() + " | ";
                                info_footer += "Veterano: " + summoner.isVeteran();


                                Resources resources = App.context.getResources();
                                String tier = summoner.getTier();
                                String rank = summoner.getRank();
                                if (summoner.getTier() == null) {
                                    tier = "bronze";
                                } else {
                                    tier = tier.toLowerCase();
                                }
                                if (summoner.getRank() == null) {
                                    rank = "v";
                                } else {
                                    rank = rank.toLowerCase();
                                }
                                final int resourceId = resources.getIdentifier(tier + "_" + rank + "", "drawable", App.context.getPackageName());

                                header.setText(info);
                                league.setText(summoner.getLeagueName());
                                name.setText(summoner.getPlayerOrTeamName());
                                puntos.setText(p);
                                ganadas.setText("G:" + String.valueOf(summoner.getWins()));
                                perdidas.setText("P:" + String.valueOf(summoner.getLosses()));
                                footer.setText(info_footer);
                                imagen.setImageDrawable(resources.getDrawable(resourceId));
                                if (summoner.isHotStreak())
                                    imagen_racha.setImageDrawable(resources.getDrawable(R.drawable.heat));
                                else
                                    imagen_racha.setImageDrawable(null);
                                FrameLayout fl = container.findViewById(R.id.fl_fragment);
                                fl.setBackground(null);
                            }
                        }else{
                                Resources resources = App.context.getResources();
                                ImageView imagen = container.findViewById(R.id.tier_image);
                                ImageView imagen_racha = container.findViewById(R.id.racha_image);
                                TextView header = container.findViewById(R.id.header_text);
                                TextView puntos = container.findViewById(R.id.puntos_text);
                                TextView name = container.findViewById(R.id.name_text);
                                TextView ganadas = container.findViewById(R.id.ganadas_text);
                                TextView perdidas = container.findViewById(R.id.perdidas_text);
                                TextView footer = container.findViewById(R.id.footer_text);
                                FrameLayout fl = container.findViewById(R.id.fl_fragment);

                                final int resourceId = resources.getIdentifier("bronze_v", "drawable", App.context.getPackageName());
                                //imagen.setImageDrawable(resources.getDrawable(resourceId));
                                fl.setBackground(resources.getDrawable(resourceId));
                                imagen_racha.setImageDrawable(null);
                                footer.setText("");
                                header.setText("Sin datos!");
                                name.setText("UNRANKED");
                                puntos.setText("");
                                ganadas.setText("");
                                perdidas.setText("");
                            }
                        }
                };

                callbackError  = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(container.getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                };
                    clienteWeb2 = new HttpCliente(App.context);
                    clienteWeb2.GetJsonArray(App.context.getString(R.string.API_URL_SUMMONER) + idSummoner + "?api_key=" + App.context.getString(R.string.API_KEY), callbackExito, callbackError, "2");

            }
        };


        callbackErrorP  = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(container.getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };

        clienteWeb = new HttpCliente(App.context);
        //clienteWeb.GetJsonArray(getString(R.string.API_URL_SUMMONER)+"878661?api_key="+getString(R.string.API_KEY), callbackExito, callbackError,"1");

        //PRIMER LLAMADO POR NOMBRE DE SUMMONER, pARA PODER SACARL LA INFO POR ID
        clienteWeb.GetJson(getString(R.string.API_URL_SUMMONER_BY_NAME)+summoner+"?api_key="+getString(R.string.API_KEY), callbackExitoP, callbackErrorP,"1");

        return vista;
    }
}
