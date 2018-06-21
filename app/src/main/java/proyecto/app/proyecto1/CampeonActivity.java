package proyecto.app.proyecto1;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

import org.json.JSONObject;

import proyecto.app.proyecto1.Clases.App;
import proyecto.app.proyecto1.Clases.HttpCliente;
import proyecto.app.proyecto1.Modelo.Campeon;
import proyecto.app.proyecto1.Modelo.ListaCampeones;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static proyecto.app.proyecto1.R.color.colorLightGreen;

public class CampeonActivity extends AppCompatActivity {

    //Declaracion de CALLBACKS
    private Response.Listener<JSONObject> callbackExito;
    private Response.ErrorListener callbackError;

    private static Campeon personaje;
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campeon);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ImageView imageView = (ImageView)findViewById(R.id.campeon_image);
        TextView apodo = (TextView) findViewById(R.id.apodo);
        TextView lore = (TextView) findViewById(R.id.lore);
        TextView allytips = (TextView) findViewById(R.id.allytips);
        TextView enemytips = (TextView) findViewById(R.id.enemytips);
        TextView stats_col1 = (TextView) findViewById(R.id.stats_col1);
        final Campeon campeon = (Campeon)getIntent().getSerializableExtra(Campeon.class.toString());
        LinearLayout myGallery = (LinearLayout)findViewById(R.id.skins);
        LinearLayout abilities = (LinearLayout)findViewById(R.id.abilities);
        final String nombre = campeon.getName();
        //SKINS
        for(int x=0; x < campeon.getSkins().length; x++){
            LinearLayout layout = new LinearLayout(getApplicationContext());
            layout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
            layout.setGravity(Gravity.CENTER);
            //layout.setPadding(5,0,5,0);
            final ImageView skin_image = new ImageView(getApplicationContext());
            skin_image.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
            skin_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            skin_image.setPadding(0,0,1,0);
;
            final String nombre_skin = campeon.getSkins()[x].getName();
            final String imagePath = getString(R.string.path_imagenes) + campeon.getKey()+"_"+campeon.getSkins()[x].getNum()+".jpg";
            Picasso.get().load(imagePath).into(skin_image);
            skin_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView imageView = findViewById(R.id.campeon_image);
                    TextView name = findViewById(R.id.name_text);
                    CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
                    if(nombre_skin != "default")
                        mCollapsingToolbarLayout.setTitle(nombre_skin);
                    else
                        mCollapsingToolbarLayout.setTitle(nombre);
                    Picasso.get().load(imagePath).into(imageView);
                }
            });

            layout.addView(skin_image);
            myGallery.addView(layout);
        }

        //Habilidades y Pasiva
        for(int x=0; x < campeon.getSpells().length; x++){
            LinearLayout layout = new LinearLayout(getApplicationContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
            params.bottomMargin = 2;
            layout.setBackground(getResources().getDrawable(R.color.colorDarkGrey));
            layout.setLayoutParams(params);
            layout.setGravity(Gravity.TOP);
            layout.setPadding(5,0,5,0);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout layoutv = new LinearLayout(getApplicationContext());
            layoutv.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
            layoutv.setGravity(Gravity.CENTER);
            layoutv.setPadding(10,0,5,0);
            layoutv.setOrientation(LinearLayout.VERTICAL);


            final ImageView spell_image = new ImageView(getApplicationContext());
            spell_image.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
            spell_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            TextView text_nombre = new TextView(getApplicationContext());
            text_nombre.setTextColor(getResources().getColor(R.color.colorYellow));
            TextView text_info = new TextView(getApplicationContext());
            text_info.setTextColor(getResources().getColor(R.color.colorLightBrown));

            String nombre_spell = campeon.getSpells()[x].getName();
            String info_spell = campeon.getSpells()[x].getDescription();
            String imagePath = getString(R.string.path_imagenes_abilities) + campeon.getSpells()[x].getKey()+".png";
            Picasso.get().load(imagePath).error(App.context.getResources().getDrawable(R.drawable.imagennodisponible)).into(spell_image);
            text_nombre.setText(nombre_spell);
            text_info.setText(info_spell);

            layout.addView(spell_image);
            layout.addView(layoutv);
            layoutv.addView(text_nombre);
            layoutv.addView(text_info);
            abilities.addView(layout);
        }



        String llave = campeon.getKey();
        String imagePath = getString(R.string.path_imagenes) + llave+"_0.jpg";
        Picasso.get().load(imagePath).into(imageView);
        apodo.setText(campeon.getTitle());
        lore.setText(campeon.getLore());
        String consejoAlly = "";
        for(int x=0; x < campeon.getAllytips().length; x++){
            consejoAlly += (x+1)+") "+campeon.getAllytips()[x]+"\n";
        }
        String consejoEnemy = "";
        for(int x=0; x < campeon.getEnemytips().length; x++){
            consejoEnemy += (x+1)+") "+campeon.getEnemytips()[x]+"\n";
        }

        String stats = "";
        String stats2 = "";
        stats += "Armadura: <b>"+String.valueOf(campeon.getStats().getArmor())+"</b>\n";
        stats += "Armadura por nivel: "+String.valueOf(campeon.getStats().getArmorperlevel())+"\n";
        stats += "Ataque: "+String.valueOf(campeon.getStats().getAttackdamage())+"\n";
        stats += "Ataque por nivel: "+String.valueOf(campeon.getStats().getAttackdamageperlevel())+"\n";
        stats += "Rango de ataque: "+String.valueOf(campeon.getStats().getAttackrange())+"\n";
        stats += "Velocidad de ataque: "+String.valueOf(campeon.getStats().getAttackspeedoffset())+"\n";
        stats += "Velocidad de ataque por nivel: "+String.valueOf(campeon.getStats().getAttackspeedperlevel())+"\n";
        stats += "Critico: "+String.valueOf(campeon.getStats().getCrit())+"\n";
        stats += "Critico por nivel: "+String.valueOf(campeon.getStats().getCritperlevel())+"\n";
        stats += "Vida: "+String.valueOf(campeon.getStats().getHp())+"\n";
        stats += "Vida por nivel: "+String.valueOf(campeon.getStats().getHpperlevel())+"\n";
        stats += "Regeneracion de vida: "+String.valueOf(campeon.getStats().getHpregen())+"\n";
        stats += "Regeneracion de vida por nivel: "+String.valueOf(campeon.getStats().getHpregenperlevel())+"\n";
        stats += "Velocidad de movimiento: "+String.valueOf(campeon.getStats().getMovespeed())+"\n";
        stats += "Poder magico: "+String.valueOf(campeon.getStats().getMp())+"\n";
        stats += "Poder magico por nivel: "+String.valueOf(campeon.getStats().getMpperlevel())+"\n";
        stats += "Regenaracion de poder magico: "+String.valueOf(campeon.getStats().getMpregen())+"\n";
        stats += "Regenaracion de poder magico por nivel: "+String.valueOf(campeon.getStats().getMpregenperlevel())+"\n";
        stats += "Armadura magica: "+String.valueOf(campeon.getStats().getSpellblock())+"\n";
        stats += "Armadura magicapor nivel: "+String.valueOf(campeon.getStats().getSpellblockperlevel())+"\n";

        allytips.setText(consejoAlly);
        enemytips.setText(consejoEnemy);
        stats_col1.setText(stats);
        //stats_col2.setText(stats2);

        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitle(nombre);

    }
}
