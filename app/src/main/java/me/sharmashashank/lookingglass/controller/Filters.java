package me.sharmashashank.lookingglass.controller;

import org.json.JSONObject;

import me.sharmashashank.lookingglass.exception.NotImplementedException;

public class Filters {

    private Filters(){
    }

    /*
    Returns true if the JSONObject has a video media type
     */
    public static boolean CheckIfVideo(JSONObject object){
        return object.has("videos")==true;
    }

    /*
    Not implemented. Checks if location falls within given boundaries
     */
    private static void CheckLocation (long lat, long lon, int radius) throws NotImplementedException{
        throw new NotImplementedException();
    }
}
