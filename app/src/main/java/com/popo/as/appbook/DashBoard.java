package com.popo.as.appbook;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.ProgressBar;

import android.widget.TextView;
import android.widget.Toast;

import com.appnext.base.Appnext;
import com.appnext.core.AppnextError;
import com.appnext.nativeads.MediaView;
import com.appnext.nativeads.NativeAdListener;
import com.appnext.nativeads.NativeAdRequest;
import com.appnext.nativeads.NativeAdView;
import com.appnext.nativeads.PrivacyIcon;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.maps.model.Dash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static com.popo.as.appbook.R.id.description;
import static com.popo.as.appbook.R.id.rating;

public class DashBoard extends AppCompatActivity {

    private InterstitialAd mInterstitial;
    boolean doubleBackToExitPressedOnce = false;
    NativeAdView nativeAdView;
    ImageView imageView;
    TextView textView;
    MediaView mediaView;
    ProgressBar progressBar;
    Button button;
    TextView description;
    TextView rating;
    ArrayList viewArrayList;
    ArrayList viewArrayList1;
    ArrayList viewArrayList2;
    ArrayList viewArrayList3;
    ArrayList viewArrayList4;
    ArrayList viewArrayList5;
    com.appnext.nativeads.NativeAd nativeAd;
    com.appnext.nativeads.NativeAd nativeAd1;
    NativeAdView nativeAdView1;
    TextView textView1;
    Button button1;
    TextView description1;
    ImageView imageView1;
    ProgressBar progressBar1;
    com.appnext.nativeads.NativeAd nativeAd2;
    NativeAdView nativeAdView2;
    TextView textView2;
    Button button2;
    ImageView imageView2;
    com.appnext.nativeads.NativeAd nativeAd3;
    NativeAdView nativeAdView3;
    TextView textView3;
    Button button3;
    ImageView imageView3;
    com.appnext.nativeads.NativeAd nativeAd4;
    NativeAdView nativeAdView4;
    TextView textView4;
    Button button4;
    ImageView imageView4;
    com.appnext.nativeads.NativeAd nativeAd5;
    NativeAdView nativeAdView5;
    TextView textView5;
    Button button5;
    ImageView imageView5;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Appnext.init(this);
        setViews();
        setViews1();
        setViews2();
        setViews3();
        setViews4();
        setViews5();
        MobileAds.initialize(this, getResources().getString(R.string.banner_ad_id));
        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getResources().getString((R.string.interstitial_ad_id)));
        mInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdOpened() {
                Toast.makeText(getApplicationContext(), "AD Opened", Toast.LENGTH_SHORT).show();
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                Toast.makeText(getApplicationContext(), "AD Loaded", Toast.LENGTH_SHORT).show();
                super.onAdLoaded();

            }
        });
        mediaView.setMute(true);
        mediaView.setAutoPLay(true);
        mediaView.setClickEnabled(true);
         nativeAd = new com.appnext.nativeads.NativeAd(this, "5d32ae77-1949-4322-808e-c08705deec84");
        new NativeAdRequest()
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL)
  /* You set the creative caching policy:
     CachingPolicy.ALL - video and wide image
     CachingPolicy.NOTHING - video and wide image will not be cached
     CachingPolicy.VIDEO_ONLY - only the video will be cached
     CachingPolicy.STATIC_ONLY - only the wide image will be cached
     assets that were not cached will be streamed */
                .setCreativeType(NativeAdRequest.CreativeType.ALL)
  /* You filter the ad content based on your preferred creative:
     CreativeType.ALL - both video and static
     CreativeType.VIDEO_ONLY - video type creatives only
     CreativeType.STATIC_ONLY - wide (static) creatives only */
                .setVideoLength(NativeAdRequest.VideoLength.SHORT)
                .setVideoQuality(NativeAdRequest.VideoQuality.HIGH);

        nativeAd.setPrivacyPolicyColor(PrivacyIcon.PP_ICON_COLOR_LIGHT);
        nativeAd.setAdListener(new NativeAdListener() {
            @Override
            public void onAdLoaded(com.appnext.nativeads.NativeAd nativeAd) {
                super.onAdLoaded(nativeAd);
                progressBar.setVisibility(View.GONE);
                nativeAd.downloadAndDisplayImage(imageView, nativeAd.getIconURL());
                textView.setText(nativeAd.getAdTitle());
                nativeAd.setMediaView(mediaView);
                rating.setText(nativeAd.getStoreRating());
                description.setText(nativeAd.getAdDescription());
                nativeAd.registerClickableViews(viewArrayList);
                nativeAd.setNativeAdView(nativeAdView);
            }

            @Override
            public void onAdClicked(com.appnext.nativeads.NativeAd nativeAd) {
                super.onAdClicked(nativeAd);
            }

            @Override
            public void onError(com.appnext.nativeads.NativeAd nativeAd, AppnextError appnextError) {
                super.onError(nativeAd, appnextError);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Internet problem", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void adImpression(com.appnext.nativeads.NativeAd nativeAd) {
                super.adImpression(nativeAd);
            }
        });

        nativeAd.loadAd(new NativeAdRequest()
                // optional - config your ad request:
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL)
                .setCreativeType(NativeAdRequest.CreativeType.ALL)
                .setVideoLength(NativeAdRequest.VideoLength.SHORT)
                .setVideoQuality(NativeAdRequest.VideoQuality.HIGH)

        );

        //For native small ads---------------------------------------------------------------------------------------------
        nativeAd1 = new com.appnext.nativeads.NativeAd(this, "5d32ae77-1949-4322-808e-c08705deec84");
        new NativeAdRequest()
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL);


        nativeAd1.setPrivacyPolicyColor(PrivacyIcon.PP_ICON_COLOR_LIGHT);
        nativeAd1.setAdListener(new NativeAdListener() {
                                    @Override
                                    public void onAdLoaded(com.appnext.nativeads.NativeAd nativeAd1) {
                                        super.onAdLoaded(nativeAd1);
                                        progressBar1.setVisibility(View.GONE);
                                        nativeAd1.downloadAndDisplayImage(imageView1, nativeAd1.getIconURL());
                                        textView1.setText(nativeAd1.getAdTitle());
                                        description1.setText(nativeAd1.getAdDescription());
                                        nativeAd1.registerClickableViews(viewArrayList1);
                                        nativeAd1.setNativeAdView(nativeAdView1);
                                    }
            @Override
            public void onAdClicked(com.appnext.nativeads.NativeAd nativeAd1) {
                super.onAdClicked(nativeAd1);
            }

            @Override
            public void onError(com.appnext.nativeads.NativeAd nativeAd1, AppnextError appnextError) {
                super.onError(nativeAd1, appnextError);
                progressBar1.setVisibility(View.GONE);
            }

            @Override
            public void adImpression(com.appnext.nativeads.NativeAd nativeAd1) {
                super.adImpression(nativeAd1);
            }
        });

        nativeAd1.loadAd(new NativeAdRequest()
                // optional - config your ad request:
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL)


        );
// For icon ads1------------------------------------------------------------------------------------------------------------

        nativeAd2 = new com.appnext.nativeads.NativeAd(this, "5d32ae77-1949-4322-808e-c08705deec84");
        new NativeAdRequest()
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL);


        nativeAd2.setPrivacyPolicyColor(PrivacyIcon.PP_ICON_COLOR_LIGHT);
        nativeAd2.setAdListener(new NativeAdListener() {
            @Override
            public void onAdLoaded(com.appnext.nativeads.NativeAd nativeAd2) {
                super.onAdLoaded(nativeAd2);
                nativeAd2.downloadAndDisplayImage(imageView2, nativeAd2.getIconURL());
                textView2.setText(nativeAd2.getAdTitle());
                nativeAd2.registerClickableViews(viewArrayList2);
                nativeAd2.setNativeAdView(nativeAdView2);
            }
            @Override
            public void onAdClicked(com.appnext.nativeads.NativeAd nativeAd1) {
                super.onAdClicked(nativeAd2);
            }

            @Override
            public void onError(com.appnext.nativeads.NativeAd nativeAd2, AppnextError appnextError) {
                super.onError(nativeAd2, appnextError);            }

            @Override
            public void adImpression(com.appnext.nativeads.NativeAd nativeAd2) {
                super.adImpression(nativeAd2);
            }
        });

        nativeAd2.loadAd(new NativeAdRequest()
                // optional - config your ad request:
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL)


        );
// For icon ads2------------------------------------------------------------------------------------------------------------

        nativeAd3 = new com.appnext.nativeads.NativeAd(this, "5d32ae77-1949-4322-808e-c08705deec84");
        new NativeAdRequest()
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL);


        nativeAd3.setPrivacyPolicyColor(PrivacyIcon.PP_ICON_COLOR_LIGHT);
        nativeAd3.setAdListener(new NativeAdListener() {
            @Override
            public void onAdLoaded(com.appnext.nativeads.NativeAd nativeAd3) {
                super.onAdLoaded(nativeAd3);
                nativeAd3.downloadAndDisplayImage(imageView3, nativeAd3.getIconURL());
                textView3.setText(nativeAd3.getAdTitle());
                nativeAd3.registerClickableViews(viewArrayList3);
                nativeAd3.setNativeAdView(nativeAdView3);
            }
            @Override
            public void onAdClicked(com.appnext.nativeads.NativeAd nativeAd3) {
                super.onAdClicked(nativeAd3);
            }

            @Override
            public void onError(com.appnext.nativeads.NativeAd nativeAd3, AppnextError appnextError) {
                super.onError(nativeAd3, appnextError);

            }

            @Override
            public void adImpression(com.appnext.nativeads.NativeAd nativeAd3) {
                super.adImpression(nativeAd3);
            }
        });
        nativeAd3.loadAd(new NativeAdRequest()
                // optional - config your ad request:
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL));
        // For icon ads3------------------------------------------------------------------------------------------------------------

        nativeAd4 = new com.appnext.nativeads.NativeAd(this, "5d32ae77-1949-4322-808e-c08705deec84");
        new NativeAdRequest()
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL);


        nativeAd4.setPrivacyPolicyColor(PrivacyIcon.PP_ICON_COLOR_LIGHT);
        nativeAd4.setAdListener(new NativeAdListener() {
            @Override
            public void onAdLoaded(com.appnext.nativeads.NativeAd nativeAd4) {
                super.onAdLoaded(nativeAd4);
                nativeAd4.downloadAndDisplayImage(imageView4, nativeAd4.getIconURL());
                textView4.setText(nativeAd4.getAdTitle());
                nativeAd4.registerClickableViews(viewArrayList4);
                nativeAd4.setNativeAdView(nativeAdView4);
            }
            @Override
            public void onAdClicked(com.appnext.nativeads.NativeAd nativeAd4) {
                super.onAdClicked(nativeAd4);
            }

            @Override
            public void onError(com.appnext.nativeads.NativeAd nativeAd4, AppnextError appnextError) {
                super.onError(nativeAd4, appnextError);
            }

            @Override
            public void adImpression(com.appnext.nativeads.NativeAd nativeAd4) {
                super.adImpression(nativeAd4);
            }
        });
        nativeAd4.loadAd(new NativeAdRequest()
                // optional - config your ad request:
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL));
        // For icon ads4------------------------------------------------------------------------------------------------------------

        nativeAd5 = new com.appnext.nativeads.NativeAd(this, "5d32ae77-1949-4322-808e-c08705deec84");
        new NativeAdRequest()
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL);


        nativeAd5.setPrivacyPolicyColor(PrivacyIcon.PP_ICON_COLOR_LIGHT);
        nativeAd5.setAdListener(new NativeAdListener() {
            @Override
            public void onAdLoaded(com.appnext.nativeads.NativeAd nativeAd5) {
                super.onAdLoaded(nativeAd5);
                nativeAd5.downloadAndDisplayImage(imageView5, nativeAd5.getIconURL());
                textView5.setText(nativeAd5.getAdTitle());
                nativeAd5.registerClickableViews(viewArrayList5);
                nativeAd5.setNativeAdView(nativeAdView5);
            }
            @Override
            public void onAdClicked(com.appnext.nativeads.NativeAd nativeAd5) {
                super.onAdClicked(nativeAd5);
            }

            @Override
            public void onError(com.appnext.nativeads.NativeAd nativeAd5, AppnextError appnextError) {
                super.onError(nativeAd5, appnextError);
            }

            @Override
            public void adImpression(com.appnext.nativeads.NativeAd nativeAd5) {
                super.adImpression(nativeAd5);
            }
        });
        nativeAd5.loadAd(new NativeAdRequest()
                // optional - config your ad request:
                .setPostback("")
                .setCategories("")
                .setCachingPolicy(NativeAdRequest.CachingPolicy.ALL));
//Intent------------------------------------------------------------------------------------------------------------------------
        TextView banking = (TextView) findViewById(R.id.banking);
        banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(DashBoard.this, Banking.class);
                startActivity(i1);
            }

        });


        TextView wallet = (TextView) findViewById(R.id.wallet);
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(DashBoard.this, Wallet.class);
                startActivity(i2);


            }

        });

        TextView contact = (TextView) findViewById(R.id.contactus);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(DashBoard.this, ContactUs.class);
                startActivity(i7);
            }

        });
    }
    //set view for native large-----------------------------------------------------------------------------------------
    private void setViews() {
        nativeAdView = (NativeAdView) findViewById(R.id.na_view);
        imageView = (ImageView) findViewById(R.id.na_icon);
        textView = (TextView) findViewById(R.id.na_title);
        mediaView = (MediaView) findViewById(R.id.na_media);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        button = (Button) findViewById(R.id.install);
        rating = (TextView) findViewById(R.id.rating);
        description = (TextView) findViewById(R.id.description);
        viewArrayList = new ArrayList<>();
        viewArrayList.add(button);
        viewArrayList.add(mediaView);}

    //setview for native small----------------------------------------------------------------------------------------------
    private void setViews1() {
        nativeAdView1 = (NativeAdView) findViewById(R.id.startapp_view);
        imageView1 = (ImageView) findViewById(R.id.startappicon);
        textView1 = (TextView) findViewById(R.id.startapp_title);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        button1 = (Button) findViewById(R.id.startapp_install);
        description1 = (TextView) findViewById(R.id.startapp_description);
        viewArrayList1 = new ArrayList<>();
        viewArrayList1.add(button1);
       }
    //setview for icon ads1------------------------------------------------------------------------------------------------------
    private void setViews2() {
        nativeAdView2 = (NativeAdView) findViewById(R.id.iconad_view);
        imageView2 = (ImageView) findViewById(R.id.iconad_icon);
        textView2 = (TextView) findViewById(R.id.iconad_title);
        button2 = (Button) findViewById(R.id.iconad_install);
        viewArrayList2 = new ArrayList<>();
        viewArrayList2.add(button2);
    }
    //setview for icon ads2------------------------------------------------------------------------------------------------------
    private void setViews3() {
        nativeAdView3 = (NativeAdView) findViewById(R.id.iconad_view1);
        imageView3 = (ImageView) findViewById(R.id.iconad_icon1);
        textView3 = (TextView) findViewById(R.id.iconad_title1);
        button3 = (Button) findViewById(R.id.iconad_install1);
        viewArrayList3 = new ArrayList<>();
        viewArrayList3.add(button3);
    }

  //  -------------------------------------------------------------------------------------------------------------------------------
  //setview for icon ads3------------------------------------------------------------------------------------------------------
  private void setViews4() {
      nativeAdView4 = (NativeAdView) findViewById(R.id.iconad_view2);
      imageView4 = (ImageView) findViewById(R.id.iconad_icon2);
      textView4 = (TextView) findViewById(R.id.iconad_title2);
      button4 = (Button) findViewById(R.id.iconad_install2);
      viewArrayList4 = new ArrayList<>();
      viewArrayList4.add(button4);
  }
    //---------------------------------------------------------------------------------------------------------------------------
    //setview for icon ads3------------------------------------------------------------------------------------------------------
    private void setViews5() {
        nativeAdView5 = (NativeAdView) findViewById(R.id.iconad_view3);
        imageView5 = (ImageView) findViewById(R.id.iconad_icon3);
        textView5 = (TextView) findViewById(R.id.iconad_title3);
        button5 = (Button) findViewById(R.id.iconad_install3);
        viewArrayList5 = new ArrayList<>();
        viewArrayList5.add(button5);
    }
    //---------------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onDestroy() {
        super.onDestroy();
        nativeAd.destroy();
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to close AppBook", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 3000);


    }

    public void feedBack(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"help.appbook@gmail.com"});
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }






}
