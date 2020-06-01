package com.example.lky.broadcasttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lky.broadcasttest.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_user)
    EditText loginUser;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_login)
    Button loginLogin;

    private String password;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = loginUser.getText().toString();
                password = loginPassword.getText().toString();
               if(username.equals("admin") && password.equals("123456")){
                   MainActivity.startAction(activity);
                   finish();
               }else{
                   Toast.makeText(activity, "user or password is invalid", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    public void onBackLogin() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (loginPassword!= null) loginPassword.setText("");
                if (loginUser != null) {
                    loginUser.setSelection(loginUser.getText().toString().length());
                    loginUser.requestFocus();
                }
            }
        });
    }
}