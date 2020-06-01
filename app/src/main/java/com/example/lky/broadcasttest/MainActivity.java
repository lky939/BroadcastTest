package com.example.lky.broadcasttest;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lky.broadcasttest.base.BaseActivity;
import com.example.lky.broadcasttest.broadcast.LocalBroadcastReceiver;
import com.example.lky.broadcasttest.broadcast.NetworkChangeReceiver;

public class MainActivity extends BaseActivity {

//    private NetworkChangeReceiver networkChangeReceiver;
//    private IntentFilter intentFilter;

//    private LocalBroadcastManager localBroadcastManager;
//    private LocalBroadcastReceiver localBroadcastReceiver;

    public static void startAction(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver,intentFilter);

//        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent("com.example.lky.My_BROADCAST");
//                sendBroadcast(intent);
//
//                Intent intent = new Intent("LOCAL_BROADCAST");
//                localBroadcastManager.sendBroadcast(intent);

                Intent intent = new Intent("FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
//        IntentFilter localFilter =  new IntentFilter();
//        localFilter.addAction("LOCAL_BROADCAST");
//        localBroadcastReceiver = new LocalBroadcastReceiver();
//        localBroadcastManager.registerReceiver(localBroadcastReceiver,localFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(networkChangeReceiver);
//        unregisterReceiver(localBroadcastReceiver);
    }
}