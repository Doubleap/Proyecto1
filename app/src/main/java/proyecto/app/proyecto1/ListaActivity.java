package proyecto.app.proyecto1;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
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
import proyecto.app.proyecto1.Fragments.DatosSummonerFragment;
import proyecto.app.proyecto1.Modelo.Campeon;
import proyecto.app.proyecto1.Modelo.ListaCampeones;

public class ListaActivity extends AppCompatActivity {
    private CampeonAdapter adapter;
    private CampeonAdapter filteredadapter;
    private Response.Listener<JSONObject> callbackExito;
    private Response.ErrorListener callbackError;
    private static ListaCampeones personajes;
    private ListView lista;
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                /*Fragment summonerFragment = new DatosSummonerFragment();
                Bundle bundl = new Bundle();
                ArrayList<String>   argumentos = new ArrayList<String>();
                argumentos.add(query);
                bundl.putStringArrayList("argumentos", argumentos);
                summonerFragment.setArguments(bundl);
                mostrarFragment(summonerFragment);
                // Check if no view has focus:
                View view = getWindow().getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(getBaseContext().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }*/
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Campeon> campeonesFiltrados = searchByName(newText,adapter.getItems());
                filteredadapter.clear();
                for(int x=0;x < campeonesFiltrados.size();x++){
                    filteredadapter.getItems().add(campeonesFiltrados.get(x));
                }
                lista.setAdapter(filteredadapter);
                lista.deferNotifyDataSetChanged();
                return true;
            }
        });

        return true;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        final ProgressBar progreso = findViewById(R.id.progressBar);

        getSupportActionBar().setTitle("Lista de Campeones");
        //Callback de la clase 6
        callbackExito = new Response.Listener<JSONObject>(){
            @SuppressLint("NewApi")
            @Override
            public void onResponse(JSONObject response){
                //Actualziar ViewPager despues de obtener los datos
                JsonElement mJsonAll=null;
                JsonParser parser = new JsonParser();
                adapter = new CampeonAdapter(getApplicationContext(), R.layout.campeon, new ArrayList<Campeon>());
                filteredadapter = new CampeonAdapter(getApplicationContext(), R.layout.campeon, new ArrayList<Campeon>());
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
                        filteredadapter.getItems().add(personajes.getCampeon(x));
                    }
                    lista.setAdapter(adapter);
                    lista.deferNotifyDataSetChanged();
                    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Campeon elemento = (Campeon) filteredadapter.getItem(i);
                            Intent mensajero = new Intent(getBaseContext(), CampeonActivity.class);
                            mensajero.putExtra(Campeon.class.toString(), elemento);
                            startActivity(mensajero);
                            //Toast.makeText(getBaseContext(), "HOLA", Toast.LENGTH_LONG).show();
                        }
                    });

                    progreso.setVisibility(View.GONE);
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
    public ArrayList<Campeon> searchByName(String name,ArrayList<Campeon> campeones){
        String searchString = name;
        ArrayList<Campeon> resList = new ArrayList<Campeon>();

        for (Campeon curVal : campeones){
            if (curVal.getName().toLowerCase().contains(searchString.toLowerCase())){
                resList.add(curVal);
            }
        }
        return resList;
    }
}
