package com.example.hchirinos.dbremota;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.textclassifier.TextLinks;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    ArrayList<ConstructorProducto> listProductos;
    RecyclerView recyclerProducto;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerProducto = (RecyclerView)findViewById(R.id.recycler_lista_productos);
        recyclerProducto.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerProducto.setHasFixedSize(true);

        listProductos = new ArrayList<>();

        request = Volley.newRequestQueue(getApplicationContext());
        
        cargarWebservices();




    }

    private void cargarWebservices() {


        String url = "http://192.168.3.34:8080/elmejorprecio/conectar.php";

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);


    }


    @Override
    public void onErrorResponse(VolleyError error) {



    }

    @Override
    public void onResponse(JSONObject response) {

        ConstructorProducto producto= null;

        JSONArray json = response.optJSONArray("producto");

        try {

        for (int i=0; i<json.length();i++){
            producto = new ConstructorProducto();
            JSONObject jsonObject = null;
            jsonObject = json.getJSONObject(i);

            producto.setNombre_producto(jsonObject.optString("nombre_plu"));
            producto.setPrecio_producto(jsonObject.optDouble("precio_plu"));

            listProductos.add(producto);


            }

            // Envío de ArrayList al Adaptador
            AdapterProductos adapterProductos = new AdapterProductos(listProductos);
            recyclerProducto.setAdapter(adapterProductos);



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
