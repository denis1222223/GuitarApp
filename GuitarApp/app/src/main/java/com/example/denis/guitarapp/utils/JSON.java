package com.example.denis.guitarapp.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSON {

    public static <T> List<T> toList(JSONArray jsonArray, Class<T> type) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, UnixEpochDateTypeAdapter.getUnixEpochDateTypeAdapter())
                .create();
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(gson.fromJson(jsonObject.toString(), type));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;
    }

}
