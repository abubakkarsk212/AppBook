package com.popo.as.appbook;

/**
 * Created by abubakkar on 17-10-2017.
 */
public class CustomBanking {

    private String mBanking;
    private String mTitle;
    private  int mImage;
    private String mDownloads;

    public CustomBanking(String b , String t ,int i , String d){
        mBanking = b;
        mTitle = t;
        mImage = i;
        mDownloads = d;
    }

    public String getmBanking(){
        return mBanking;
    }

    public String getmTitle() {
        return mTitle;
    }

    public int getmImage(){
        return mImage;
    }

    public String getmDownloads(){
        return mDownloads;
    }
}
