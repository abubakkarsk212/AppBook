package com.popo.as.appbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Mobikwik extends AppCompatActivity {
InterstitialAd mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobikwik);
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
}
