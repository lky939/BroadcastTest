package com.example.lky.broadcasttest.base;

import android.app.Application;

import com.example.lky.broadcasttest.LoginActivity;

import java.util.Stack;

public class MyApp extends Application {

    private Stack<BaseActivity> appActivitys;

    private static MyApp ins = null;
    public static MyApp getIns() {
        return ins;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appActivitys = new Stack<BaseActivity>();
        ins = this;
    }

    public boolean isStackActivityEmpty() {
        return appActivitys.isEmpty();
    }

    public boolean isHaveLoginActivity(){
        BaseActivity activity = null;
        for(int i=0;i<appActivitys.size();i++){
            if(appActivitys.get(i) instanceof LoginActivity){
                activity = appActivitys.get(i);
            }else{
                continue;
            }
        }
        if(activity == null || !(activity instanceof LoginActivity)){
            return false;
        }else{

        }

        if (activity instanceof LoginActivity) {
            return true;
        }else{
            return false;
        }
    }

    public BaseActivity pop(BaseActivity activity) {
        if (activity == null) {
            return null;
        }
        if(appActivitys!=null && appActivitys.size()!=0){
            BaseActivity top = appActivitys.peek();
            if (activity.equals(top)) {
                return appActivitys.pop();
            }
            return delete(activity);
        }else{
            return activity;
        }
    }

    public BaseActivity push(BaseActivity activity) {
        return appActivitys.push(activity);
    }

    private BaseActivity delete(BaseActivity activity) {
        return appActivitys.remove(activity) ? activity : null;
    }

    public void backToLogin() {
        BaseActivity activity = null;
        while (!appActivitys.isEmpty()
                && !((activity = appActivitys.peek()) instanceof LoginActivity)) {
            activity = appActivitys.pop();
            activity.finish(false);
        }
        if (activity instanceof LoginActivity) {
            ((LoginActivity) activity).onBackLogin();
        }
    }
}
