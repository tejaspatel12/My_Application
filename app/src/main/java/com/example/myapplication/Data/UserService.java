package com.example.myapplication.Data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import com.example.myapplication.Model.User;

import android.content.Context;
import org.json.JSONArray;

public interface UserService {

    String BASE_URL = "https://video.activeapp.in/api/";

    static void insertUser(Context context, User user, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        String url = BASE_URL + "insert_user.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("name", user.getName());
                params.put("email", user.getEmail());
                return params;
            }
        };

        Volley.newRequestQueue(context).add(request);
    }

    static void getUsers(Context context, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        String url = BASE_URL + "get_users.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener);

        Volley.newRequestQueue(context).add(request);
    }
}


