package me.sharmashashank.lookingglass.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import me.sharmashashank.lookingglass.exception.MetadataNotFoundException;

public class Options {
    private static Options mUniqueInstance = null;

    private static String ClientID="";
    private static String clientIdName="Instagram_Client_ID";
    private static String apiLink="https://api.instagram.com/v1/tags/#SEARCHTAG#/media/recent?client_id=";

    public static Options instance() {
        if (mUniqueInstance == null)
            mUniqueInstance = new Options();

        return mUniqueInstance;
    }

    public static void setClientID(Context context){
        try {
            Bundle bundle = context.getPackageManager().
                    getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData;
            ClientID=bundle.getString(clientIdName,"");
            if (ClientID.isEmpty()){
                throw new MetadataNotFoundException();
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (MetadataNotFoundException e) {
            Utils.showToast(context, "Please configure Instagram Client ID to run application");
            e.printStackTrace();
        }
    }

    public static String ClientID(){
        return ClientID;
    }

    public static String ApiLink(String searchTag){
        return apiLink.replace("#SEARCHTAG", searchTag)+ClientID;
    }

    private Options(){
    }
}
