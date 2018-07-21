package com.example.kushal.leandigit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText Username,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username=(EditText)findViewById(R.id.etUsername);
        Password=(EditText)findViewById(R.id.etPassword);
    }

    public void onRegister(View view){

        String usernsme = Username.getText().toString();
        String password = Password.getText().toString();
        String type = "register";

        Add add=new Add(this);
        add.execute(type,usernsme,password);

    }
}
