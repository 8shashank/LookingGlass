package me.sharmashashank.lookingglass.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.sharmashashank.lookingglass.R;
import me.sharmashashank.lookingglass.common.Options;
import me.sharmashashank.lookingglass.model.InstagramManager;

public class MainActivity extends AppCompatActivity {

    InstagramManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeSettings();
        manager=new InstagramManager(Options.getClientID());
    }

    private void initializeSettings() {
        Options.setClientID(getApplicationContext());
    }
}
