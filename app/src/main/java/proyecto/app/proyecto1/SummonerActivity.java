package proyecto.app.proyecto1;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import java.util.ArrayList;

import proyecto.app.proyecto1.Fragments.*;

public class SummonerActivity extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Fragment summonerFragment = new DatosSummonerFragment();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner);


    }
    private void mostrarFragment(android.app.Fragment fragment) {
        FrameLayout contedorFragments = (FrameLayout)findViewById(R.id.contenedor);

        FragmentTransaction transaccion = getFragmentManager().beginTransaction();
        transaccion.replace(R.id.contenedor, fragment);

        transaccion.commit();
    }
}
