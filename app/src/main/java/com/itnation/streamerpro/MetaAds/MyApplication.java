package com.itnation.streamerpro.MetaAds;

import android.app.Application;


import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        AudienceNetworkAds.initialize(this);
        AdSettings.addTestDevice("a8850c22-9493-47a1-9a89-4374e8bf7168");

    }

}
