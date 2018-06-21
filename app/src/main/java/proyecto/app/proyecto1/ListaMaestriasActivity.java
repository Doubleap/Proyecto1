package proyecto.app.proyecto1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import proyecto.app.proyecto1.Adapters.MaestriaAdapter;
import proyecto.app.proyecto1.Clases.HttpCliente;
import proyecto.app.proyecto1.Modelo.Maestria;

public class ListaMaestriasActivity extends AppCompatActivity {
    private MaestriaAdapter adapter;
    private MaestriaAdapter filteredadapter;
    private Response.Listener<JSONObject> callbackExito;
    private Response.ErrorListener callbackError;

    private GridView lista;

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Maestria> maestriasFiltrados = searchByName(newText,adapter.getItems());
                filteredadapter.clear();
                for(int x=0;x < maestriasFiltrados.size();x++){
                    filteredadapter.getItems().add(maestriasFiltrados.get(x));
                }
                lista.setAdapter(filteredadapter);
                lista.deferNotifyDataSetChanged();
                return true;
            }
        });

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_maestrias);
        final ProgressBar progreso = findViewById(R.id.progressBar);

        getSupportActionBar().setTitle("Lista de Maestrias");

        callbackExito = new Response.Listener<JSONObject>(){
            @SuppressLint("NewApi")
            @Override
            public void onResponse(JSONObject response){
                //Actualziar ListView despues de obtener los datos
                JsonElement mJsonAll=null;
                JsonParser parser = new JsonParser();
                adapter = new MaestriaAdapter(getApplicationContext(), R.layout.item_maestria, new ArrayList<Maestria>());
                filteredadapter = new MaestriaAdapter(getApplicationContext(), R.layout.item_maestria, new ArrayList<Maestria>());
                lista = findViewById(R.id.gridview);

                try {
                    //JsonElement mJson =  parser.parse(response.getJSONObject("data").getJSONArray("results").getJSONObject(getArguments().getInt(ARG_SECTION_NUMBER)).toString());
                    mJsonAll =  parser.parse(response.getJSONObject("data").toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    Map<String,Object> prueba = toMap(response.getJSONObject("data"));
                    Gson gson = new Gson();

                    for(Map.Entry<String, Object> entry : prueba.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        JSONObject elemento = MapToJson((Map)value);
                        mJsonAll =  parser.parse(elemento.getJSONObject("data").toString());
                        Maestria maestria = gson.fromJson(mJsonAll, Maestria.class);
                        adapter.getItems().add(maestria);
                        filteredadapter.getItems().add(maestria);
                    }
                    lista.setAdapter(adapter);
                    lista.deferNotifyDataSetChanged();
                    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            /*Items elemento = (Items) adapter.getItem(i);
                            Intent mensajero = new Intent(getBaseContext(), ItemActivity.class);
                            mensajero.putExtra(Items.class.toString(), elemento);
                            startActivity(mensajero);*/
                            Toast.makeText(getBaseContext(), "Abrir detalle Maestria", Toast.LENGTH_LONG).show();
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

        String url = getString(R.string.API_URL_ALLMAESTRIAS) + "&api_key=" + getString(R.string.API_KEY);
        //LLamado a la API
        HttpCliente clienteWeb = new HttpCliente(getBaseContext());
        clienteWeb.GetJson(url,callbackExito,callbackError,"Inicio");
    }
    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }
            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }
            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }

    public static JSONObject MapToJson(Map map)throws JSONException{

        JSONObject obj = new JSONObject();
        JSONObject main = new JSONObject();
        Set set = map.keySet();

        Iterator iter = set.iterator();

        while (iter.hasNext()) {
            String key = (String) iter.next();
            obj.accumulate(key, map.get(key));
        }
        main.accumulate("data",obj);

        return main;
    }
    public ArrayList<Maestria> searchByName(String name,ArrayList<Maestria> maestrias){
        String searchString = name;
        ArrayList<Maestria> resList = new ArrayList<Maestria>();

        for (Maestria curVal : maestrias){
            if (curVal.getName().toLowerCase().contains(searchString.toLowerCase())){
                resList.add(curVal);
            }
        }
        return resList;
    }
}