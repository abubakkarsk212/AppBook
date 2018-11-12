package com.popo.as.appbook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Paytm extends AppCompatActivity {
InterstitialAd  mInterstitial;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytm);



        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getResources().getString((R.string.interstitial_ad_id)));
        AdRequest ad = new AdRequest.Builder().build();
        mInterstitial.loadAd(ad);
    }

    @Override
    public void onBackPressed() {
        if (mInterstitial.isLoaded()) {
            mInterstitial.show();
            mInterstitial.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    public void paytm_install(View view){
        try{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("market://details?id=net.one97.paytm"));
            startActivity(i);
        }catch(Exception e){
            Intent i = new Intent(Intent.ACTION_VIEW);
            //It will open a browser
            i.setData(Uri.parse("https://play.google.com/store/apps/details?id=net.one97.paytm"));
        }
    }

}
