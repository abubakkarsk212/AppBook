package com.popo.as.appbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Banking extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);

        final ArrayList<CustomBanking> words = new ArrayList<CustomBanking>();
        words.add(new CustomBanking("iMobile", "by ICICI Bank",R.drawable.icici,"10 million downloads" ));
        words.add(new CustomBanking("SBI Anywhere Personal", "by STATE BANK OF INDIA",R.drawable.sbi2,"10 million downloads"));
        words.add(new CustomBanking("HDFC Mobile Banking", "by HDFC Bank",R.drawable.hdfc,"10 million downloads"));
        words.add(new CustomBanking("PNB mBanking", "by PNB",R.drawable.pnb,"1 million downloads"));
        words.add(new CustomBanking("CANMOBILE", "by CANARA BANK",R.drawable.canara,"1 million downloads"));
        words.add(new CustomBanking("Kotak Bharat Banking", "by Kotak Mahindra Bank",R.drawable.kotak,"5 million downloads"));
        words.add(new CustomBanking("Axis Mobile", "by Axis Bank Ltd",R.drawable.axis,"5 million downloads"));
        BankAdapter itemAdapter = new BankAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.banklist);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent b1 = new Intent(Banking.this, Icici.class);
                    startActivity(b1);
                } else if (position == 1) {
                    Intent b2 = new Intent(Banking.this, Sbi.class);
                    startActivity(b2);
                } else if (position == 2) {
                    Intent b3 = new Intent(Banking.this, Hdfc.class);
                    startActivity(b3);
                } else if (position == 3) {
                    Intent b3 = new Intent(Banking.this, Pnb.class);
                    startActivity(b3);
                } else if (position == 4) {
                    Intent b4 = new Intent(Banking.this, Canara.class);
                    startActivity(b4);
                } else if (position == 5) {
                    Intent b5 = new Intent(Banking.this, Kotak.class);
                    startActivity(b5);
                } else if (position == 6) {
                    Intent b6 = new Intent(Banking.this, Axis.class);
                    startActivity(b6);
                }
            }
        });
    }
}
