package com.example.boombz.myapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boombz.myapplication.Models.User;
import com.example.boombz.myapplication.Service.SessionManager;
import com.example.boombz.myapplication.app.App;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by boombz on 23/09/16.
 */
public class MainActivity  extends AppCompatActivity {

    private SessionManager sessionManager;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = new SessionManager(getApplicationContext());
        if (!sessionManager.isLoggedIn()) {
            sessionManager.startLoginActivity();
            finish();
            return;
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Connecting Server");
        progressDialog.setMessage("Fetching User Information");
        progressDialog.isIndeterminate();


        String accessToken = sessionManager.getLoggedAccessToken();
        App.setUserService(accessToken);

        if(App.currentUser == null) {
            getCurrentUser();
        }

        setContentView(R.layout.activity_main);
        String myLoginEmailAddress = getLoginEmailAddress();
        TextView loginInformation = (TextView)findViewById(R.id.login_email);
        if(myLoginEmailAddress != null || !myLoginEmailAddress.equals("")){
            loginInformation.setText("Welcome!!! You have logged in as " + myLoginEmailAddress);
        }else {
            loginInformation.setText("Your login email is missing");
        }

        Button btnMap = (Button)findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(loginIntent);
            }
        });


    }
    private String getLoginEmailAddress(){
        String storedEmail = "";
        Intent mIntent = getIntent();
        Bundle mBundle = mIntent.getExtras();
        if(mBundle != null){
            storedEmail = mBundle.getString("EMAIL");
        }
        return storedEmail;
    }

    public void getCurrentUser() {
        progressDialog.show();


        Call<User> call = App.getUserService().getCurrentUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                User user = response.body();

                if(user != null) {
                    App.setCurrentUser(user);
                } else {
                    Toast.makeText(getBaseContext(), "An error has occured getting user: " + response.code(), Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getBaseContext(), "An error has occured get user: " + t.getMessage(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }
}
