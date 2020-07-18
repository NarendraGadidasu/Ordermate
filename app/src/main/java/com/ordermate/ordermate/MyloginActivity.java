package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.connect.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyloginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**set the content on load*/
        setContentView(R.layout.activity_mylogin);

        /**hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        /**hide action bar*/
        getSupportActionBar().hide();

        /**Define what should happen on clicking the button login*/
        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MyloginActivity.this, MyRequestsActivity.class);
                startActivity(intent);
            }
        });
    }
}