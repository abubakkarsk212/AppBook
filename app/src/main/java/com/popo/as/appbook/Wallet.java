package com.popo.as.appbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Wallet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        final ArrayList<CustomBanking> words = new ArrayList<CustomBanking>();

//        words.add("One");
        words.add(new CustomBanking("Paytm", "by One97 Communications Ltd",R.drawable.paytm ,"50 million downloads"));
//        words.add("Two");
        words.add(new CustomBanking("MobiKwik", "by Mobikwik",R.drawable.mobikwik,"10 million downloads"));
//        words.add("Four");
        words.add(new CustomBanking("FreeCharge", "by FreeCharge",R.drawable.freecharge,"10 million downloads"));

        words.add(new CustomBanking("Oxigen", "by Oxigen Service(India)",R.drawable.oxigen,"5 million downloads"));
//        words.add("Six");
        words.add(new CustomBanking("JioMOney", "by Reliance payment Solution",R.drawable.jiomoney,"10 million downloads"));
//        words.add("Seven");
        words.add(new CustomBanking("Ola Money", "by olacabs",R.drawable.ola,"500 thousand downloads"));


        BankAdapter itemAdapter = new BankAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.walletList);

        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent b1 = new Intent(Wallet.this, Paytm.class);
                    startActivity(b1);
                }
                 else if (position == 1) {
                    Intent b3 = new Intent(Wallet.this, Mobikwik.class);
                    startActivity(b3);
                } else if (position == 2) {
                    Intent b = new Intent(Wallet.this, Freecharge.class);
                    startActivity(b);
                } else if (position == 3) {
                    Intent b4 = new Intent(Wallet.this, Oxigen.class);
                    startActivity(b4);
                } else if (position == 4) {
                    Intent b5 = new Intent(Wallet.this, Jiomoney.class);
                    startActivity(b5);
                } else if (position == 5) {
                    Intent b6 = new Intent(Wallet.this, Olamoney.class);
                    startActivity(b6);
                }


            }
        });

    }

    }

