package proyecto.app.proyecto1.Clases;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import proyecto.app.proyecto1.Modelo.Personaje;

public class HttpCliente {
    private RequestQueue cola;
    public HttpCliente(Context context){
        cola = Volley.newRequestQueue(context);
    }
    public void CancelRequestTag(String tag){
            cola.cancelAll(tag);
    }
    public void Get(String url, Response.Listener<String> callbackSuccess, Response.ErrorListener callbackError){
        StringRequest request = new StringRequest(Request.Method.GET, url, callbackSuccess, callbackError);
        cola.add(request);
    }
    public void GetJson(String url, Response.Listener<JSONObject> callbackSuccess, Response.ErrorListener callbackError,String tag){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null  , callbackSuccess, callbackError);
        request.setTag(tag);
        cola.add(request);
    }
    public void GetJsonArray(String url, Response.Listener<JSONArray> callbackSuccess, Response.ErrorListener callbackError, String tag){
        JsonArrayRequest  request = new JsonArrayRequest(Request.Method.GET, url,null  , callbackSuccess, callbackError);
        request.setTag(tag);
        cola.add(request);
    }
    public Personaje[] GetPersonajes(String url, Response.Listener<JSONObject> callbackSuccess, Response.ErrorListener callbackError){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Personaje[].class);
    }

}
