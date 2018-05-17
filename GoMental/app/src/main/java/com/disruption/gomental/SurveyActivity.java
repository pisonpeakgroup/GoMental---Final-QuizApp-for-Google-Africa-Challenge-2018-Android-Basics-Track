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

   //On pressing the submit button, retrieve the country name string and print out a toast with a score
    public void submitSurvey(View view) {
        EditText mNameOfCountry = findViewById(R.id.survey_enter_country_name);
        String countryName = mNameOfCountry.getText().toString();

        int surveyScore = calculateUserSurveyScore();

        Toast.makeText(this, "Thank you for your participation! \nYour grade: "
                + surveyScore + " of the possible five. \nYour Country: " + countryName, Toast.LENGTH_SHORT).show();
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

        RadioButton yesQuestion4 = findViewById(R.id.yes_question4);
        boolean hasCheckedYesQuestion4 = yesQuestion4.isChecked();

        RadioButton yesQuestion6 = findViewById(R.id.yes_question6);
        boolean hasCheckedYesQuestion6 = yesQuestion6.isChecked();


        if (awarenessMonth.equals("May")) {
            userSurveyScore++;
        }
        if (hasCheckedYesQuestion3) {
            userSurveyScore++;
        } else {
            return userSurveyScore;
        }
        if (!hasCheckedYesQuestion4) {
            userSurveyScore++;
        } else {
            return userSurveyScore;
        }
        if (hasCheckedBox2OfQuestion5) {
            userSurveyScore++;
        }
        if (hasCheckedYesQuestion6) {
            return userSurveyScore;
        } else {
            userSurveyScore++;
        }
        return userSurveyScore;
    }
}
