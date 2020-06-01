package com.example.lky.broadcasttest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(activeNetworkInfo!=null && activeNetworkInfo.isAvailable()){
            Toast.makeText(context,"newwork is available",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
        }

    }
}
