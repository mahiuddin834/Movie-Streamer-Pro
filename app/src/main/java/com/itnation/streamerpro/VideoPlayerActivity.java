package com.itnation.streamerpro;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class VideoPlayerActivity extends AppCompatActivity {



    YouTubePlayerView youTubePlayerView;

    InterstitialAd interstitialAd;



    boolean isFullScreen = false;

    public static String video_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_player);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        fullScreenAds();




        //>>>>>>>>>>>>>>>>>>>>>>>>

        //>>>>>>>>>>>>>>>>>>>>>>>>




        youTubePlayerView = findViewById(R.id.youtube_player_view);
         getLifecycle().addObserver(youTubePlayerView);









// full screen mode ----------------



        if (isFullScreen) {
            youTubePlayerView.wrapContent();
        } else {
            youTubePlayerView.matchParent();
        }
        isFullScreen = !isFullScreen;




        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = video_id;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });


       /* full_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isFullScreen) {
                    youTubePlayerView.wrapContent();
                } else {
                    youTubePlayerView.matchParent();
                }
                isFullScreen = !isFullScreen;
            }
        });
        */

//<<<--------------------------------------









    }// close onCreate Method-----------------------------//////////////////////////////////////


    //Reworded Video Ads start.io ==============================



    @Override
    public void onBackPressed() {

        if (interstitialAd!=null && interstitialAd.isAdLoaded()){
            interstitialAd.show();
        }
        super.onBackPressed();

    }

    //Full Screen ADs---------------------------

    private void fullScreenAds(){


        interstitialAd = new InterstitialAd(VideoPlayerActivity.this, "1550045112495030_1550098302489711");
        // Create listeners for the Interstitial Ad
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(com.facebook.ads.Ad ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(com.facebook.ads.Ad ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.");



            }

            @Override
            public void onError(com.facebook.ads.Ad ad, AdError adError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(com.facebook.ads.Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");




            }

            @Override
            public void onAdClicked(com.facebook.ads.Ad ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!");


            }

            @Override
            public void onLoggingImpression(com.facebook.ads.Ad ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!");
            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());




    }




    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }



}