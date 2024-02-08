package com.itnation.streamerpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.google.android.material.tabs.TabLayout;
import com.itnation.streamerpro.Fragment.CategoryFragment;
import com.itnation.streamerpro.Fragment.HomeFragment;
import com.itnation.streamerpro.Utility.NetworkChangeListener;

public class MainActivity extends AppCompatActivity {


    NetworkChangeListener networkChangeListener = new NetworkChangeListener();

    FrameLayout frameLayout;

    TabLayout tabLayout;

    AdView adView;
    int bannerAdsClick=0;
    LinearLayout banner_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frameLayout= findViewById(R.id.frame_layout);
        tabLayout= findViewById(R.id.tab_layout);

        loadBannerAds();





        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, new HomeFragment());
        fragmentTransaction.commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int tabPosition= tab.getPosition();

                if (tabPosition==0){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frame_layout, new HomeFragment());
                    fragmentTransaction.commit();





                }

                else if (tabPosition==1){




                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, new CategoryFragment());
                    fragmentTransaction.commit();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {



            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });






    }

    @Override
    protected void onStart() {

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);

        super.onStart();
    }


    @Override
    protected void onStop() {

        unregisterReceiver(networkChangeListener);

        super.onStop();
    }


    //banner ads
    private void loadBannerAds(){

        adView = new AdView(this, "IMG_16_9_APP_INSTALL#1550045112495030_1550060882493453", AdSize.BANNER_HEIGHT_50);

// Find the Ad Container
        banner_container= findViewById(R.id.banner_container);

// Add the ad view to your activity layout
        banner_container.addView(adView);




        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {


            }

            @Override
            public void onAdLoaded(Ad ad) {
// Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {

                bannerAdsClick++;

                if (bannerAdsClick>=2){

                    if (adView!=null){
                        adView.destroy();
                        banner_container.setVisibility(View.GONE);
                    }
                }
// Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
// Ad impression logged callback
            }
        };

        adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());
    }
    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}