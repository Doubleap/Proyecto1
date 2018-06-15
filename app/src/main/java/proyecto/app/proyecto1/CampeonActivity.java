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
        ImageView imageView = (ImageView)findViewById(R.id.campeon_image);
        Campeon campeon = (Campeon)getIntent().getSerializableExtra(Campeon.class.toString());
        String nombre = campeon.getName();
        String llave = campeon.getKey();
        String imagePath = getString(R.string.path_imagenes) + llave+"_0.jpg";
        Picasso.get().load(imagePath).into(imageView);
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitle(nombre);

    }
}
