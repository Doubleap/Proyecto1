package proyecto.app.proyecto1.Clases;

import android.os.AsyncTask;

import org.json.JSONObject;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import proyecto.app.proyecto1.Modelo.Personaje;

public class AsyncTaskActivity extends AsyncTask<URL, Integer, JSONObject> {
    JSONObject personajes;
    protected JSONObject doInBackground(URL... urls) {
        try {
            String API_URL = "https://gateway.marvel.com:443/v1/public/characters";
            String API_KEY = "8af40c9eefc0afca02b462e53d1ff595";
            String API_PRIV_KEY = "e5114c4db0b922be085e05d320804cf71248dc32";
            String TS = "2016-11-16 06:43:19.77";
            String MD5 = "5d837201ec232e1244fc1e7b13e6397a";
            String url = API_URL + "?apikey=" + API_KEY + "&ts=" + TS + "&hash=" + MD5;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            personajes = restTemplate.getForObject(url, JSONObject.class);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return personajes;
    }

    protected void onPostExecute(JSONObject result) {
        personajes = result;
    }
}
