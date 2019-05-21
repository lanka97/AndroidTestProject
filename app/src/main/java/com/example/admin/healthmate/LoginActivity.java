package com.example.admin.healthmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView attempts;
    private TextView btn_signup;
    private CardView btn_login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        attempts = (TextView) findViewById(R.id.log_attempt);
        btn_login = (CardView) findViewById(R.id.btn_login);
        btn_signup = (TextView) findViewById(R.id.signup);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUser(username.getText().toString(), password.getText().toString());
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Signup.class);
                startActivity(intent);
            }
        });



    }

    private void validateUser(String username, String password){
        if((username.equals("user")) && password.equals("user")){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }else{
            counter --;

            attempts.setText(String.valueOf(counter) + " attempts remaining!");

            if(counter == 0){
                btn_login.setEnabled(false);
            }
        }
    }












}
