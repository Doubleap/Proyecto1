package proyecto.app.proyecto1;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import proyecto.app.proyecto1.Clases.HttpCliente;
import proyecto.app.proyecto1.Modelo.Campeon;
import proyecto.app.proyecto1.Modelo.ListaCampeones;

public class CampeonActivity extends AppCompatActivity {

    //Declaracion de CALLBACKS
    private Response.Listener<JSONObject> callbackExito;
    private Response.ErrorListener callbackError;

    private static Campeon personaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campeon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Campeon campeon = (Campeon)getIntent().getSerializableExtra(Campeon.class.toString());
        callbackExito = new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){
                //Actualziar ViewPager despues de obtener los datos
                JsonElement mJsonAll=null;
                JsonParser parser = new JsonParser();
                ImageView imageView = (ImageView)findViewById(R.id.campeon_image);
                try {
                    //JsonElement mJson =  parser.parse(response.getJSONObject("data").getJSONArray("results").getJSONObject(getArguments().getInt(ARG_SECTION_NUMBER)).toString());
                    mJsonAll =  parser.parse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Gson gson = new Gson();
                    personaje = gson.fromJson(mJsonAll, Campeon.class);

                    String nombre = personaje.getName();
                    String llave = personaje.getKey();
                    String imagePath = getString(R.string.path_imagenes) + llave+"_0.jpg";
                    Picasso.get().load(imagePath).into(imageView);
                    CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
                    mCollapsingToolbarLayout.setTitle(nombre);
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

        // Instanciar request a la cola de Volley
        final RequestQueue queue = Volley.newRequestQueue(this);
        String id_personaje = getIntent().getStringExtra("id");
        String url = getString(R.string.API_URL_CHAMP, id_personaje)+ "&api_key=" + getString(R.string.API_KEY);

        HttpCliente clienteWeb = new HttpCliente(this);
        clienteWeb.GetJson(url,callbackExito,callbackError,"Inicio");
        //Fin llamado API

    }
}
