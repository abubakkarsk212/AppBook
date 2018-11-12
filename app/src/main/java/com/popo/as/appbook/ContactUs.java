package com.popo.as.appbook;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ContactUs extends AppCompatActivity {
private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        mAdView = (AdView) findViewById(R.id.adViewcontact);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest1);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_SHORT).show();
                super.onAdFailedToLoad(errorCode);
            }
        });
    }
    public void contmail(View view) {
        Intent intent1 = new Intent(Intent.ACTION_SENDTO);
        intent1.setData(Uri.parse("mailto:"));
        intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"help.appbook@gmail.com"});
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        }
    }
    public void whatsapp(View view) {
        String smsNumber = "918700600109";
        boolean isWhatsAppInstalled =true;
        if(isWhatsAppInstalled){


            Intent intent1 = new Intent("android.intent.action.MAIN");
            intent1.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            intent1.putExtra("jid", PhoneNumberUtils.stripSeparators(smsNumber)+"@s.whatsapp.net");
            if (intent1.resolveActivity(getPackageManager()) != null) {
                startActivity(intent1);
            }
         else {
                Uri uri = Uri.parse("market://details?id=com.whatsapp");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW,uri);
                Toast.makeText(this,"WhatsApp is not installed",Toast.LENGTH_SHORT).show();
                startActivity(goToMarket);
            }
        }
    }
}
