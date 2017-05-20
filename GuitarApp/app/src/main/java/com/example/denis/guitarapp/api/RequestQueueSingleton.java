package com.example.denis.guitarapp.api;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestQueueSingleton {
    private static RequestQueueSingleton instance ;

    private RequestQueue requestQueue;
    private static Context context;

    public RequestQueueSingleton(Context context) {
        this.context = context;
        instance = this;
        requestQueue = getRequestQueue();
    }

    public static synchronized RequestQueueSingleton getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
