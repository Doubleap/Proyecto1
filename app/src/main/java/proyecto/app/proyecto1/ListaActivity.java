package proyecto.app.proyecto1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import proyecto.app.proyecto1.Adapters.CampeonAdapter;
import proyecto.app.proyecto1.Clases.HttpCliente;
import proyecto.app.proyecto1.Modelo.Campeon;
import proyecto.app.proyecto1.Modelo.ListaCampeones;

public class ListaActivity extends AppCompatActivity {
    private CampeonAdapter adapter;
    private Response.Listener<JSONObject> callbackExito;
    private Response.ErrorListener callbackError;
    private static ListaCampeones personajes;
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //Callback de la clase 6
        callbackExito = new Response.Listener<JSONObject>(){
            @SuppressLint("NewApi")
            @Override
            public void onResponse(JSONObject response){
                //Actualziar ViewPager despues de obtener los datos
                JsonElement mJsonAll=null;
                JsonParser parser = new JsonParser();
                adapter = new CampeonAdapter(getApplicationContext(), R.layout.campeon, new ArrayList<Campeon>());
                lista = findViewById(R.id.lista);

                try {
                    //JsonElement mJson =  parser.parse(response.getJSONObject("data").getJSONArray("results").getJSONObject(getArguments().getInt(ARG_SECTION_NUMBER)).toString());
                    mJsonAll =  parser.parse(response.getJSONObject("data").toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    Gson gson = new Gson();
                    personajes = gson.fromJson(mJsonAll, ListaCampeones.class);

                    //Llenar el adapter con la informacion recibida del API
                    for(int x=1;x<=personajes.getTotalCampeones();x++){
                        adapter.getItems().add(personajes.getCampeon(x));
                    }
                    lista.setAdapter(adapter);
                    lista.deferNotifyDataSetChanged();
                    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Campeon elemento = (Campeon) adapter.getItem(i);
                            Intent mensajero = new Intent(getBaseContext(), CampeonActivity.class);
                            mensajero.putExtra(Campeon.class.toString(), elemento);
                            startActivity(mensajero);
                            //Toast.makeText(getBaseContext(), "HOLA", Toast.LENGTH_LONG).show();
                        }
                    });


                }catch (Exception e){
                    Toast.makeText(getBaseContext(), e.getMessage()+"No se encontraron resultados1", Toast.LENGTH_LONG).show();
                }
            }
        };
        callbackError = new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(), error.getMessage()+"No se encontraron resultados2", Toast.LENGTH_LONG).show();
            }
        };

        //final ListView lista = findViewById(R.id.lista);
        //lista.setAdapter(adapter);


        String url = getString(R.string.API_URL_ALLCHAMP) + "&api_key=" + getString(R.string.API_KEY);
        //LLamado a la API
        HttpCliente clienteWeb = new HttpCliente(getBaseContext());
        clienteWeb.GetJson(url,callbackExito,callbackError,"Inicio");

        //ListView lista = findViewById(R.id.lista);
        /*lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Campeon elemento = (Campeon) lista.getSelectedItem();
                //Intent mensajero = new Intent(getBaseContext(), CampeonActivity.class);
                //mensajero.putExtra(Campeon.class.toString(), elemento);
                //startActivity(mensajero);
                Toast.makeText(getBaseContext(), "HOLA", Toast.LENGTH_LONG).show();
            }
        });*/
    }
    private void cargarImagenBackgroundBoton(String url, final Button boton){
        final ImageView img = new ImageView(this);
        Picasso.get()
                .load(url)
                .into(img, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        boton.setBackgroundDrawable(img.getDrawable());
                    }
                    @Override
                    public void onError(Exception e) {

                    }
                });

    }
}
