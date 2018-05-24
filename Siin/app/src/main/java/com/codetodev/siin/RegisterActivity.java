package com.codetodev.siin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

public class RegisterActivity extends AppCompatActivity {

    ServerConnect sc = new ServerConnect();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        setTitle("Register - Bummp!");

        //Action click btn register
        final Button btnRegister = findViewById(R.id.RegisterBtn);
        final TextView usernameRegister = findViewById(R.id.usernameRegister);
        final TextView passwordRegister = findViewById(R.id.passwordRegister);
        final TextView emailRegister = findViewById(R.id.emailRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameRegister.getText().length() == 0 || passwordRegister.getText().length() == 0 || emailRegister.getText().length() == 0) {
                    Log.d(LoginActivity.class.getSimpleName(), "NullPointerException");
                } else {
                    try {
                        sc.register(usernameRegister.getText().toString(), passwordRegister.getText().toString(), emailRegister.getText().toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
