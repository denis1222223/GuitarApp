package com.example.denis.guitarapp.api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.denis.guitarapp.fragment.OnAdapterNotification;

import org.json.JSONArray;

import static com.example.denis.guitarapp.api.ApiConfig.BASE_URL;

public class SongApiService implements Response.Listener<JSONArray>,Response.ErrorListener {

    private static SongApiService instance ;
    private Context context;
    private OnAdapterNotification currentAdapterNotification;

    public SongApiService(Context context) {
        this.context = context;
        instance = this;
    }

    public static synchronized SongApiService getInstance() {
        return instance;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONArray response) {
        currentAdapterNotification.onDataResponse(response);
    }

    public void getAllSongs(OnAdapterNotification adapterNotification) {
        currentAdapterNotification = adapterNotification;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, BASE_URL + "song", null, this, this);
        RequestQueueSingleton.getInstance().addToRequestQueue(request);
    }
}
