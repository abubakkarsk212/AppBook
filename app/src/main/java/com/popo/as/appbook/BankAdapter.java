package com.popo.as.appbook;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abubakkar on 17-10-2017.
 */
public class BankAdapter extends ArrayAdapter<CustomBanking> {

    public BankAdapter(Activity context , ArrayList<CustomBanking> wordMeaning ){
        super(context , 0 , wordMeaning);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.bankinglist, parent, false);
        }

        CustomBanking currentWord = getItem(position);

        TextView txt = (TextView) itemView.findViewById(R.id.text11);
        txt.setText(currentWord.getmBanking());

        TextView txt1 = (TextView) itemView.findViewById(R.id.text22);
        txt1.setText(currentWord.getmTitle());


        TextView txt2 = (TextView) itemView.findViewById(R.id.text222);
        txt2.setText(currentWord.getmDownloads());



        ImageView imgBank = (ImageView) itemView.findViewById(R.id.bankImage);
        imgBank.setImageResource(currentWord.getmImage());

        return itemView;
    }
}
