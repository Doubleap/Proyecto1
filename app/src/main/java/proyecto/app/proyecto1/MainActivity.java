package proyecto.app.proyecto1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;

import proyecto.app.proyecto1.Clases.HttpCliente;
import proyecto.app.proyecto1.Modelo.Campeon;
import proyecto.app.proyecto1.Modelo.ListaCampeones;
import proyecto.app.proyecto1.Modelo.Personaje;
import proyecto.app.proyecto1.Modelo.Thumbnail;

import static proyecto.app.proyecto1.R.id.container;

public class MainActivity extends AppCompatActivity {
    private View.OnClickListener nuevoListener;

    //Declaracion de CALLBACKS

    private Response.Listener<JSONObject> callbackExito;
    private Response.ErrorListener callbackError;

    private FragmentStatePagerAdapter mSectionsPagerAdapter;

    private static ViewPager mViewPager;

    private static LinkedHashMap<String,Campeon> hashMap;
    private static ListaCampeones personajes;
    //private static ArrayList<Campeon> personajes;

    ScrollView mScrollView;
    ImageView mPhotoIV;
    FrameLayout mWrapperFL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonNuevo = (Button)findViewById(R.id.button);
        nuevoListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NuevoActivity("222");
            }
        };

        botonNuevo.setOnClickListener(nuevoListener);
        //Callback de la clase 6
        callbackExito = new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){
                //Actualziar ViewPager despues de obtener los datos
                JsonElement mJsonAll=null;
                JsonParser parser = new JsonParser();
                try {
                    //JsonElement mJson =  parser.parse(response.getJSONObject("data").getJSONArray("results").getJSONObject(getArguments().getInt(ARG_SECTION_NUMBER)).toString());
                    mJsonAll =  parser.parse(response.getJSONObject("data").toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    Gson gson = new Gson();
                    personajes = gson.fromJson(mJsonAll, ListaCampeones.class);
                    //for(Field f : lista.getClass().getDeclaredFields()){
                        //System.out.println(f.getName());//or do other stuff with it
                    //}
                    //personajes = (new ArrayList<Campeon>(lista));
                    mSectionsPagerAdapter.notifyDataSetChanged();
                    mViewPager.setCurrentItem(0);
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
        String url = getString(R.string.API_URL_ALLCHAMP) + "&api_key=" + getString(R.string.API_KEY);

        HttpCliente clienteWeb = new HttpCliente(this);
        clienteWeb.GetJson(url,callbackExito,callbackError,"Inicio");
        //Fin llamado API

        EditText buscar = (EditText) findViewById(R.id.editText);

        buscar.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                // Instanciar request a la cola de Volley
                final RequestQueue queue = Volley.newRequestQueue(getBaseContext());

                String API_URL = "https://gateway.marvel.com:443/v1/public/characters";
                String API_KEY = "8af40c9eefc0afca02b462e53d1ff595";
                String API_PRIV_KEY = "e5114c4db0b922be085e05d320804cf71248dc32";
                String  TS = "2016-11-16 06:43:19.77";
                String MD5 = "5d837201ec232e1244fc1e7b13e6397a";
                String url = API_URL + "?apikey=" + API_KEY+ "&ts=" + TS+ "&hash=" + MD5+"&nameStartsWith="+s;

                HttpCliente clienteWeb = new HttpCliente(getBaseContext());
                clienteWeb.CancelRequestTag("Buscando");
                clienteWeb.GetJson(url,callbackExito,callbackError,"Buscando");
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each personaje
        mSectionsPagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    @SuppressLint("ValidFragment")
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        //Numero de seccion del Page Viewer
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, ListaCampeones personaje) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            if(personaje != null)
                args.putSerializable("personaje",personaje.toString());
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            //Setear los contenidos desde la informacion del API
            if(personajes != null) {
                String nombre = personajes.getCampeon(getArguments().getInt(ARG_SECTION_NUMBER)).getName();
                String llave = personajes.getCampeon(getArguments().getInt(ARG_SECTION_NUMBER)).getKey();
                String imagePath = null;
                imagePath = getString(R.string.path_imagenes) + llave+"_0.jpg";
                //textView.setText(getString(R.string.section_format, personajes.get(getArguments().getInt(ARG_SECTION_NUMBER)).get("name")));
                textView.setText(getString(R.string.section_format, nombre));
                textView.setClickable(true);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                //textView.setOnClickListener(comicsListener);
                Picasso.get().load(imagePath).into(imageView);
            }
            else
                textView.setText(getString(R.string.section_format, "Cargando null..."));
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class FragmentStatePagerAdapter extends FragmentPagerAdapter {

        public FragmentStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(personajes != null)
                return PlaceholderFragment.newInstance(position ,personajes);
            return PlaceholderFragment.newInstance(position ,null);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            // Mostrar la cantidad de personajes recibidos
            if (personajes != null) {
                return 100;
            }
            return 0;
        }
    }

    public static void DetalleComics(Context context) {
        Toast.makeText(context, "Abrir Detalle de Comics", Toast.LENGTH_LONG).show();
        //Intent mensajero = new Intent(this, NuevoElementoActivity.class);
        //mensajero.putExtra("mensaje", "hola desde MainActivity");
        //startActivityForResult(mensajero, 110);
    }
    private void NuevoActivity(String id) {
        Intent mensajero = new Intent(this, CampeonActivity.class);
        mensajero.putExtra("id", id);

        startActivityForResult(mensajero, 110);
    }

}
