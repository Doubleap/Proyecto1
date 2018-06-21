package proyecto.app.proyecto1;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import proyecto.app.proyecto1.Clases.App;
import proyecto.app.proyecto1.Modelo.Items;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        final Items item = (Items)getIntent().getSerializableExtra(Items.class.toString());

        final ImageView imageView = (ImageView)findViewById(R.id.imagen);
        TextView nombre = (TextView) findViewById(R.id.nombre);
        TextView precio = (TextView) findViewById(R.id.precio);
        TextView venta = (TextView) findViewById(R.id.venta);
        TextView stats = (TextView) findViewById(R.id.stats);
        LinearLayout buildsfrom = (LinearLayout) findViewById(R.id.buildsfrom);
        LinearLayout buildsinto = (LinearLayout) findViewById(R.id.buildsinto);

        String url_imagen = App.context.getString(R.string.path_imagenes_articulos) + item.getId() + ".png";
        Picasso.get().load(url_imagen).into(imageView);

        nombre.setText(item.getName());
        precio.setText("Costo:"+String.valueOf(item.getGold().getTotal())+"");
        venta.setText("Venta:"+String.valueOf(item.getGold().getSell())+"");
        stats.setText(item.getSanitizedDescription());

        //VIENE DE
        if(item.getFrom() != null) {
            TextView titulo = new TextView(getApplicationContext());
            titulo.setText("PROVIENE DE");
            for (int x = 0; x < item.getFrom().size(); x++) {
                LinearLayout layout = new LinearLayout(getApplicationContext());
                layout.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
                layout.setGravity(Gravity.CENTER);
                layout.setPadding(5, 0, 5, 0);
                final ImageView item_image = new ImageView(getApplicationContext());
                item_image.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
                item_image.setScaleType(ImageView.ScaleType.CENTER_CROP);

                final String imagePath = getString(R.string.path_imagenes_articulos) + item.getFrom().get(x) + ".png";
                Picasso.get().load(imagePath).into(item_image);
                item_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    /*Items elemento = item;
                    Intent mensajero = new Intent(getBaseContext(), ItemActivity.class);
                    mensajero.putExtra(Items.class.toString(), elemento);
                    startActivity(mensajero);*/
                        Toast.makeText(getBaseContext(), "Abrir item anidado", Toast.LENGTH_LONG).show();
                    }
                });
                layout.addView(titulo);
                layout.addView(item_image);
                buildsfrom.addView(layout);
            }
        }
        //SE CONVIERTE EN
        if(item.getInto() != null) {
            TextView titulo = new TextView(getApplicationContext());
            titulo.setText("SE CONVIERTE EN");
            for (int x = 0; x < item.getInto().size(); x++) {
                LinearLayout layout = new LinearLayout(getApplicationContext());
                layout.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
                layout.setGravity(Gravity.CENTER);
                layout.setPadding(5, 0, 5, 0);
                final ImageView item_image = new ImageView(getApplicationContext());
                item_image.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
                item_image.setScaleType(ImageView.ScaleType.CENTER_CROP);

                final String imagePath = getString(R.string.path_imagenes_articulos) + item.getInto().get(x) + ".png";
                Picasso.get().load(imagePath).into(item_image);
                item_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                layout.addView(titulo);
                layout.addView(item_image);
                buildsfrom.addView(layout);
            }
        }

    }
}
