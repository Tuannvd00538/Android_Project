package com.codetodev.siin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;


public class LoginActivity extends AppCompatActivity {

    ServerConnect sc = new ServerConnect();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setTitle("Login - Bummp!");

        //Action Button Sign In
        final Button btnLogin = findViewById(R.id.loginBtn);
        final TextView usernameLogin = findViewById(R.id.usernameLogin);
        final TextView passwordLogin = findViewById(R.id.passwordLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameLogin.getText().length() == 0 || passwordLogin.getText().length() == 0) {
                    Log.d(LoginActivity.class.getSimpleName(), "NullPointerException");
                } else {
                    try {
                        sc.login(usernameLogin.getText().toString(), passwordLogin.getText().toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //Create Account
        final TextView createAcc = findViewById(R.id.createAcc);
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });
    }
    public void  openRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
