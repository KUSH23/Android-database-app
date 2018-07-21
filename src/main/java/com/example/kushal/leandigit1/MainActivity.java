package com.example.kushal.leandigit1;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener{

    EditText Username,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.usernameEditText);
        Password = (EditText)findViewById(R.id.passwordEditText);
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        if (i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {

            login(view);

        }

        return false;
    }

    @Override
    public void onClick(View view) {

         if (view.getId() == R.id.backgroundRelativeLayout || view.getId() == R.id.logoImageView) {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


        }

    }

    public void login(View view){
        String usernsme = Username.getText().toString();
        String password = Password.getText().toString();
        String type = "login";

        if (isNetworkAvailable()){

            BackgroundWorker backgroundWorker=new BackgroundWorker(this);
            backgroundWorker.execute(type,usernsme,password);

        }else{
            AlertDialog alertDialog=new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Status");
            alertDialog.setMessage("No internet access");
            alertDialog.show();
        }
    }

}


