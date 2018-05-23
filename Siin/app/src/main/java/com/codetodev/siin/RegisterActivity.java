package com.codetodev.siin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        setTitle("Register - Bummp!");

        //Action click btn register
        final Button btnRegister = findViewById(R.id.RegisterBtn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(RegisterActivity.class.getSimpleName(), "CLick!");
            }
        });
    }
}
