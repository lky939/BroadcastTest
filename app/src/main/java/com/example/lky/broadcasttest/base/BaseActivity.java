package com.example.lky.broadcasttest.base;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lky.broadcasttest.broadcast.ForceofflineReceiver;

public class BaseActivity extends AppCompatActivity {

    protected Activity activity;
    private ForceofflineReceiver forceofflineReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
//        ActivityCollector.addActivity(this);
        MyApp.getIns().push(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("FORCE_OFFLINE");
        forceofflineReceiver = new ForceofflineReceiver();
        registerReceiver(forceofflineReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(forceofflineReceiver!=null){
            unregisterReceiver(forceofflineReceiver);
            forceofflineReceiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void finish() {
        pop();
    }

    public void finish(boolean isPop) {
        if (isPop) {
            pop();
        } else {
            super.finish();
        }
    }

    private void pop() {
        super.finish();
        MyApp.getIns().pop(this);
    }
}
