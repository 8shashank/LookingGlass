package me.sharmashashank.lookingglass.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import me.sharmashashank.lookingglass.common.Options;
import me.sharmashashank.lookingglass.exception.NotImplementedException;
import me.sharmashashank.lookingglass.model.InstagramVideo;

public class InstagramManager {

    private final String TAG=this.getClass().getSimpleName();
    private String next_url="";
    LinkedBlockingQueue<InstagramVideo> videos=new LinkedBlockingQueue<InstagramVideo>();


    private String mClientID;

    public InstagramManager(String ClientID){

    }

    public List<String> getVideosMatchingTag(String tag){
        String tag_noSpaces=tag.replaceAll("\\s+", "");
        String url= Options.ApiLink(tag_noSpaces);
        JSONArray data = getAPIResults(url);
        ArrayList<JSONObject> matchedObjects=new ArrayList<JSONObject>();
        try {
            //TODO: Create PipeLine module that can take in functions that filter the data
            for (int i = 0; i < data.length(); i++) {
                if (Filters.CheckIfVideo(data.getJSONObject(i))) {
                    matchedObjects.add(data.getJSONObject(i));
                }
            }
        }
        catch(JSONException ex){

        }
    }

    private JSONArray getAPIResults(String url){
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray results = response.getJSONArray("data");
                        }
                        catch(JSONException ex){
                            ex.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        //TODO: Extract request and create callback to get JSON
        return null;
    }
}
