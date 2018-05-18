package com.disruption.gomental;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SurveyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
    }

    //On pressing the submit button, retrieve the country name string and print out a toast with a score. The toast changes depending
    //checkbox the user checked.
    public void submitSurvey(View view) {
        EditText mNameOfCountry = findViewById(R.id.survey_enter_country_name);
        String countryName = mNameOfCountry.getText().toString();

        CheckBox questionTwoCheckBox1 = findViewById(R.id.question2CheckBox1);
        boolean hasCheckedBox1OfQuestion2 = questionTwoCheckBox1.isChecked();

        CheckBox questionTwoCheckBox2 = findViewById(R.id.question2CheckBox2);
        boolean hasCheckedBox2OfQuestion2 = questionTwoCheckBox2.isChecked();

        CheckBox questionTwoCheckBox3 = findViewById(R.id.question2CheckBox3);
        boolean hasCheckedBox3OfQuestion2 = questionTwoCheckBox3.isChecked();

        int surveyScore = calculateUserSurveyScore();

        if (hasCheckedBox1OfQuestion2 || hasCheckedBox2OfQuestion2) {
            Toast.makeText(this, "The survey team commends you for understanding mental health issues. Great work!"
                    + "\nYour score: " + surveyScore + "/5" + "\nYour country: " + countryName, Toast.LENGTH_LONG).show();
        } else if (hasCheckedBox3OfQuestion2) {
            Toast.makeText(this, "Thank you for your participation! If you can, try to interact with those who have mental health issues" +
                    "so that you can know them better."
                    + "\nYour score: " + surveyScore + "/5" + "\nYour country: " + countryName, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Thank you for your participation!"
                    + "\nYour score: " + surveyScore + "/5" + "\nYour country: " + countryName, Toast.LENGTH_LONG).show();
        }
    }

    //Check for correct answers (where applicable) in the answers given by the user
    private int calculateUserSurveyScore() {

        int userSurveyScore = 0;

        EditText mMentalAwarenessMonth = findViewById(R.id.survey_awareness_month);
        String awarenessMonth = String.valueOf(mMentalAwarenessMonth.getText());

        CheckBox questionFiveCheckBox2 = findViewById(R.id.question5CheckBox2);
        boolean hasCheckedBox2OfQuestion5 = questionFiveCheckBox2.isChecked();

        RadioButton yesQuestion3 = findViewById(R.id.yes_question3);
        boolean hasCheckedYesQuestion3 = yesQuestion3.isChecked();

        RadioButton noQuestion4 = findViewById(R.id.no_question4);
        boolean hasCheckedNoQuestion4 = noQuestion4.isChecked();

        RadioButton noQuestion6 = findViewById(R.id.no_question6);
        boolean hasCheckedNoQuestion6 = noQuestion6.isChecked();


        if (awarenessMonth.equals("May")) {
            userSurveyScore++;
        }
        if (hasCheckedYesQuestion3) {
            userSurveyScore++;
        }
        if (hasCheckedNoQuestion4) {
            userSurveyScore++;
        }
        if (hasCheckedBox2OfQuestion5) {
            userSurveyScore++;
        }
        if (hasCheckedNoQuestion6) {
            userSurveyScore++;
        }
        return userSurveyScore;
    }
}
