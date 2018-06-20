package proyecto.app.proyecto1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import proyecto.app.proyecto1.Adapters.ItemsAdapter;
import proyecto.app.proyecto1.Clases.HttpCliente;
import proyecto.app.proyecto1.Modelo.Items;

public class ListaItemsActivity extends AppCompatActivity {
    private ItemsAdapter adapter;
    private Response.Listener<JSONObject> callbackExito;
    private Response.ErrorListener callbackError;
    //private static ListaCampeones personajes;
    private GridView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_items);
        final ProgressBar progreso = findViewById(R.id.progressBar);
        callbackExito = new Response.Listener<JSONObject>(){
            @SuppressLint("NewApi")
            @Override
            public void onResponse(JSONObject response){
                //Actualziar ListView despues de obtener los datos
                JsonElement mJsonAll=null;
                JsonParser parser = new JsonParser();
                adapter = new ItemsAdapter(getApplicationContext(), R.layout.item_item, new ArrayList<Items>());
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
                        mJsonAll =  parser.parse(elemento.getJSONObject("data").toString().replace("\"[","[").replace("]\"","]"));
                        Items articulo = gson.fromJson(mJsonAll, Items.class);
                        adapter.getItems().add(articulo);
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
                            Toast.makeText(getBaseContext(), "Abrir detalle de Articulo", Toast.LENGTH_LONG).show();
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

        String url = getString(R.string.API_URL_ALLITEMS) + "&api_key=" + getString(R.string.API_KEY);
        //LLamado a la API
        HttpCliente clienteWeb = new HttpCliente(getBaseContext());
        clienteWeb.GetJson(url,callbackExito,callbackError,"Inicio");
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

}

