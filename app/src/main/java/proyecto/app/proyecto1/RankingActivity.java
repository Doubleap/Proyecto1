package proyecto.app.proyecto1;

import android.annotation.TargetApi;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import proyecto.app.proyecto1.Fragments.DatosSummonerFragment;
import proyecto.app.proyecto1.Modelo.Summoner;

public class RankingActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private static ViewPager mViewPager;

    public static final ArrayList<Summoner> rankings = new ArrayList<Summoner>();
    private static HttpCliente _clienteWeb;
    private static HttpCliente _clienteWeb2;
    private static Response.Listener<JSONArray> _callbackExito;
    private static Response.Listener<JSONObject> _callbackExitoP;
    private static Response.ErrorListener _callbackError;
    private static Response.ErrorListener _callbackErrorP;
    private final String URL_GOOGLE = "http://www.google.com";
    private final String URL_JSON = "http://httpbin.org/json";
    private final String URL_PAISES = "https://restcountries.eu/rest/v2/name/colombia?fullText=true";

    private void mostrarFragment(android.app.Fragment fragment) {
        ViewPager contedorFragments = (ViewPager)findViewById(R.id.contenedor);

        FragmentTransaction transaccion = getFragmentManager().beginTransaction();
        transaccion.replace(R.id.contenedor, fragment);

        transaccion.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void Buscar(String busqueda){
        /**/
        //here is your list array
        //ArrayList<String> parametros = (ArrayList<String>)bundle.get("argumentos");
        //String summoner = parametros.get(0);
        _callbackExitoP = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String idSummoner=null;
                try {
                    idSummoner = response.getString("id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                _callbackExito = new Response.Listener<JSONArray>() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResponse(JSONArray response) {
                        //adapter = new SummonerAdapter();
                        JSONObject respuesta = null;
                        rankings.clear();
                        //int x = sectionNumber;
                        if (response != null) {
                            for (int x = 0; x < response.length(); x++) {
                                try {
                                    respuesta = (JSONObject) response.get(x);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Gson gson = new Gson();
                                Summoner summoner = gson.fromJson(respuesta.toString(), Summoner.class);
                                rankings.add(summoner);
                            }
                        }
                        // Create the adapter that will return a fragment for each of the three
                        // primary sections of the activity.
                        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

                        // Set up the ViewPager with the sections adapter.
                        mViewPager = (ViewPager) findViewById(R.id.container);
                        mViewPager.setAdapter(mSectionsPagerAdapter);
                    }

                };

                _callbackError  = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        rankings.clear();
                        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

                        // Set up the ViewPager with the sections adapter.
                        mViewPager = (ViewPager) findViewById(R.id.container);
                        mViewPager.setAdapter(mSectionsPagerAdapter);
                        //Toast.makeText(App.context, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                };
                _clienteWeb2 = new HttpCliente(App.context);
                _clienteWeb2.GetJsonArray(App.context.getString(R.string.API_URL_SUMMONER) + idSummoner + "?api_key=" + App.context.getString(R.string.API_KEY), _callbackExito, _callbackError, "2");

            }
        };

        _callbackErrorP  = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                rankings.clear();
                mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

                // Set up the ViewPager with the sections adapter.
                mViewPager = (ViewPager) findViewById(R.id.container);
                mViewPager.setAdapter(mSectionsPagerAdapter);
                //Toast.makeText(App.context, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };

        _clienteWeb = new HttpCliente(App.context);
        //PRIMER LLAMADO POR NOMBRE DE SUMMONER, pARA PODER SACARL LA INFO POR ID
        String summonername = busqueda;
        _clienteWeb.GetJson(App.context.getString(R.string.API_URL_SUMMONER_BY_NAME)+summonername+"?api_key="+App.context.getString(R.string.API_KEY), _callbackExitoP, _callbackErrorP,"1");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ArrayList<String> tags = new ArrayList<String>();
                tags.add("Titulo 1");
                tags.add("Titulo 2");
                Buscar(query);
                /*android.app.Fragment summonerFragment = new DatosSummonerFragment();
                Bundle bundl = new Bundle();
                ArrayList<String>   argumentos = new ArrayList<String>();
                argumentos.add(query);
                bundl.putStringArrayList("argumentos", argumentos);
                summonerFragment.setArguments(bundl);
                mostrarFragment(summonerFragment);*/
                // Check if no view has focus:
                View view = getWindow().getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(getBaseContext().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

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
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(final int sectionNumber) {
            final PlaceholderFragment fragment = new PlaceholderFragment();
            final Bundle args = new Bundle();

            /**/
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
/*****************************************************************************************/
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_summoner, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.name_text);
            textView.setText(getString(R.string.section_format2, getArguments().getInt(ARG_SECTION_NUMBER)));
            Summoner summoner = null;
            if(rankings.size() > 0) {
                summoner = rankings.get(getArguments().getInt(ARG_SECTION_NUMBER));
                ImageView imagen = rootView.findViewById(R.id.tier_image);
                ImageView imagen_racha = rootView.findViewById(R.id.racha_image);
                TextView header = rootView.findViewById(R.id.header_text);
                TextView puntos = rootView.findViewById(R.id.puntos_text);
                TextView name = rootView.findViewById(R.id.name_text);
                TextView ganadas = rootView.findViewById(R.id.ganadas_text);
                TextView perdidas = rootView.findViewById(R.id.perdidas_text);
                TextView footer = rootView.findViewById(R.id.footer_text);
                TextView league = rootView.findViewById(R.id.league_text);

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
                FrameLayout fl = rootView.findViewById(R.id.fl_fragment);
                fl.setBackground(null);
            }else{
                Resources resources = App.context.getResources();
                ImageView imagen = rootView.findViewById(R.id.tier_image);
                ImageView imagen_racha = rootView.findViewById(R.id.racha_image);
                TextView header = rootView.findViewById(R.id.header_text);
                TextView puntos = rootView.findViewById(R.id.puntos_text);
                TextView name = rootView.findViewById(R.id.name_text);
                TextView ganadas = rootView.findViewById(R.id.ganadas_text);
                TextView perdidas = rootView.findViewById(R.id.perdidas_text);
                TextView footer = rootView.findViewById(R.id.footer_text);
                FrameLayout fl = rootView.findViewById(R.id.fl_fragment);

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


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return rankings.size();
        }
    }
}
