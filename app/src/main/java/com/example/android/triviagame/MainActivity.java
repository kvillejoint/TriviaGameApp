package com.example.android.triviagame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreQ1 = 0;
    int scoreQ2 = 0;
    int scoreQ3 = 0;
    int scoreQ4 = 0;
    int scoreQ5 = 0;
    int scoreQ6 = 0;
    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Calculate score for quiz questions
    public void onRadioButtonClicked (View view) {
        //Check if button is selected
        boolean checked = ((RadioButton) view).isChecked();
        //List of correct Radio buttons and IDs
//         RadioButton rightAnswerOne = findViewById(R.id.q1_a1);
//         RadioButton rightAnswerTwo = findViewById(R.id.q2_a2);
//         RadioButton rightAnswerThree = findViewById(R.id.q3_a1);
//         RadioButton rightAnswerFour = findViewById(R.id.q4_a2);
        //Cases for when correct answer is selected
        //Adds 1 point where correct radio button is clicked. Adds zero points for wrong answers
        switch (view.getId()) {
            //Question 1
            //Answer 1 - Correct
            case R.id.q1_a1:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    scoreQ1 += 1;
                }
                break;

            //Question 2
            //Answer 2 - Correct
            case R.id.q2_a2:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    scoreQ2 += 1;
                }
                break;

            //Question 3
            //Answer 1 - Correct
            case R.id.q3_a1:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    scoreQ3 += 1;
                }
                break;

            //Question 4
            //Answer 2
            case R.id.q4_a2:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    scoreQ4 += 1;
                }
                break;
        }
    }
    //Question 5
    public void onCheckboxClicked (View view) {
        CheckBox Checkbox1 = findViewById(R.id.q5_a1);
        CheckBox Checkbox2 = findViewById(R.id.q5_a2);
        CheckBox Checkbox3 = findViewById(R.id.q5_a3);
        CheckBox Checkbox4 = findViewById(R.id.q5_a4);
        //If all CheckBoxes are selected add 1 to score
        if (Checkbox1.isChecked() && Checkbox2.isChecked() && Checkbox3.isChecked() && Checkbox4.isChecked()) {
            scoreQ5 += 1;
        }
//        break;
    }

    //Question 6
    public void validateTextField() {
        //Calculate score Question 6
        //Convert user input into string for comparison to right answer
        EditText userInput = (EditText) findViewById(R.id.q6_a1);
//            Editable userInputFormatted = userInput.getText();
        String userAnswer = userInput.getText().toString().toLowerCase();
        String correctAnswer = "green";
        //compare user input to correct answer
        if (userAnswer.equals(correctAnswer)) {
            scoreQ6 += 1;
        } else scoreQ6 = 0;
    }

    //Add up user score for all questions
    public int calculateGrade(int scoreQ1, int scoreQ2, int scoreQ3, int scoreQ4, int scoreQ5, int scoreQ6) {
        int totalScore = scoreQ1 + scoreQ2 + scoreQ3 + scoreQ4 + scoreQ5 + scoreQ6;
        return totalScore;
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void showResults (View view) {
        // Get user's name for toast message
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String nameInput = nameField.getText().toString();

        //Call validateTextField function for Question 6
        validateTextField();

        //Call calculateGrade function to totalScore
        calculateGrade();

        //Display toast message with results
        Toast.makeText (this, "Congrats " + nameInput + ", You scored " + totalScore + " out of 6!", Toast.LENGTH_LONG).show();
    }
}
