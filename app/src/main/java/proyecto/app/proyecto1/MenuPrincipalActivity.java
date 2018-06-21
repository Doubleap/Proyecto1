package proyecto.app.proyecto1;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MenuPrincipalActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        getSupportActionBar().setTitle("League of Legends API");

        Button boton_campeones = (Button)findViewById(R.id.button_campeones);
        Button boton_itemes = (Button)findViewById(R.id.button_items);
        Button boton_runas = (Button)findViewById(R.id.button_runas);
        Button boton_maestrias = (Button)findViewById(R.id.button_maestrias);
        Button boton_ranking = (Button)findViewById(R.id.button_ranking);
        Button boton_partidas = (Button)findViewById(R.id.button_partidas);

        boton_campeones.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.drawable_campeones, 0, 0);
        boton_itemes.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.drawable_articulos, 0, 0);
        boton_runas.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.drawable_runas, 0, 0);
        boton_maestrias.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.drawable_maestrias, 0, 0);
        boton_ranking.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.drawable_ranking, 0, 0);
        boton_partidas.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.drawable_partidas, 0, 0);

        //Acciones para botones del menu principal

        boton_campeones.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OpcionMenu(view.getId());
                    }
                }
        );
        boton_itemes.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OpcionMenu(view.getId());
                    }
                }
        );
        boton_runas.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OpcionMenu(view.getId());
                    }
                }
        );
        boton_maestrias.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OpcionMenu(view.getId());
                    }
                }
        );
        boton_ranking.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OpcionMenu(view.getId());
                    }
                }
        );
        boton_partidas.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OpcionMenu(view.getId());
                    }
                }
        );
    }
    private void cargarImagenBackgroundBoton(String url, final Button boton){
        Picasso.get()
                .load(url)
                .into(new Target() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                boton.setBackground(new BitmapDrawable(bitmap));

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }

    private void cargarImagenBackgroundBoton2(String url, final Button boton){
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

    private void OpcionMenu(int id) {
        Intent mensajero = null;
        if(id == R.id.button_campeones) {
            mensajero = new Intent(this, ListaActivity.class);
            //mensajero.putExtra("id", id);
        }
        if(id == R.id.button_items) {
            mensajero = new Intent(this, ListaItemsActivity.class);
            mensajero.putExtra("id", "222");
        }
        if(id == R.id.button_runas) {
            mensajero = new Intent(this, ListaActivity.class);
            //mensajero.putExtra("id", id);
        }
        if(id == R.id.button_maestrias) {
            mensajero = new Intent(this, ListaMaestriasActivity.class);
            //mensajero.putExtra("id", id);
        }
        if(id == R.id.button_ranking) {
            mensajero = new Intent(this, RankingActivity.class);
            //mensajero.putExtra("id", id);
        }
        if(id == R.id.button_partidas) {
            mensajero = new Intent(this, ListaActivity.class);
            //mensajero.putExtra("id", id);
        }
        startActivity(mensajero);
        //startActivity(mensajero, 110);
    }
}
