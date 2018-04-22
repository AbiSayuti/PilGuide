package com.pramudana.sam.edubanten.loginregister;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pramudana.sam.edubanten.MainActivity;
import com.pramudana.sam.edubanten.R;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    public final int SPLASH_DISPLAY_LENGH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                String lang = String.valueOf(Locale.ENGLISH);
                Locale locale = new Locale(lang);
                Locale.setDefault(locale);
                Configuration config = new Configuration ();
                config.locale = locale;

                SplashActivity.this.getResources().updateConfiguration(config,
                        SplashActivity.this.getResources().getDisplayMetrics()) ;
                //after three seconds, it will execute all of this code.
                //as such, we then want to redirect to the master-activity
                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                //then we finish this class. Dispose of it as it is longer needed
                SplashActivity.this.finish();

            }
        }, SPLASH_DISPLAY_LENGH);
    }
}