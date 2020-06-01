package com.example.lky.broadcasttest.broadcast;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.lky.broadcasttest.LoginActivity;
import com.example.lky.broadcasttest.base.MyApp;

public class ForceofflineReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder builder =  new AlertDialog.Builder(context);
        builder.setTitle("Warning");
        builder.setMessage("you are forced to be offline. Please try to login again");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                ActivityCollector.finishAll();
//                Intent intent = new Intent(context, LoginActivity.class);
//                context.startActivity(intent);

                if (MyApp.getIns().isStackActivityEmpty()) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                }else if(!MyApp.getIns().isHaveLoginActivity()){
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                }
                else {
                    MyApp.getIns().backToLogin();
                }

            }
        });
        builder.show();
    }
}