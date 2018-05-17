package com.disruption.gomental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Declare and implement an intent to go to the InformativeActivity
    public void beginInformative(View view) {
        Intent intent = new Intent(this, InformativeActivity.class);
        intent.resolveActivity(getPackageManager());
        startActivity(intent);
    }

    //Declare and implement an intent to go to the SurveyActivity
    public void beginSurvey(View view) {
        Intent intent = new Intent(this, SurveyActivity.class);
        intent.resolveActivity(getPackageManager());
        startActivity(intent);
    }
}
