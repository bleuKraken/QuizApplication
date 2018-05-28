package com.example.android.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizapplication.R;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;
    int score = 0;

    // Method runs when submit button at bottom of app clicked
    public void submitAnswersButton(View view) {
        // gets the name that the user typed into the text field
        EditText name =  (EditText) findViewById(R.id.name_field); // players NAME
        String userName = name.getText().toString();

        // RADIO BUTTON CHECKER BELOW
        // CHECKS QUESTIONS 1, 2, 3, 5, 7, 8, 9.
        RadioButton answerOne, answerTwo, answerThree, answerFive, answerSeven, answerEight, answerNine;

        // where the answers are located at.
        answerOne = (RadioButton) findViewById(R.id.question1_Answer4);
        answerTwo = (RadioButton) findViewById(R.id.question2_Answer1);
        answerThree = (RadioButton) findViewById(R.id.question3_Answer1);
        answerFive = (RadioButton) findViewById(R.id.question5_Answer3);
        answerSeven = (RadioButton) findViewById(R.id.question7_Answer2);
        answerEight = (RadioButton) findViewById(R.id.question8_Answer2);
        answerNine = (RadioButton) findViewById(R.id.question9_Answer1);

        //If any of the ABOVE are correct, the IF statements below add a point
        if (answerOne.isChecked()) {
            score = score +1;
        }
        if (answerTwo.isChecked()) {
            score = score +1;
        }
        if (answerThree.isChecked()) {
            score = score +1;
        }
        if (answerFive.isChecked()) {
            score = score +1;
        }
        if (answerSeven.isChecked()) {
            score = score +1;
        }
        if (answerEight.isChecked()) {
            score = score +1;
        }
        if (answerNine.isChecked()) {
            score = score +1;
        }
        ////////////////////////////////////////END OF MULTIPLE CHOICE CHECK

        /////////////// CHECKBOX CHECKER /////////////////////

        // QUESTION 4
        //the checkboxes, and where they are located
        CheckBox question4_LetterB , question4_letterD;
        question4_LetterB = (CheckBox) findViewById(R.id.question4_Answer2);
        question4_letterD = (CheckBox) findViewById(R.id.question4_Answer4);

        // if the checkboxes the user selected are corrent or not
        if(question4_LetterB.isChecked() && question4_letterD.isChecked()) {
            score = score +1;
        }
        // END OF CHECKBOX CHECK 4

        //CHECKBOXES FOR QUESTION 6
        CheckBox question6_LetterB, question6_LetterC;
        question6_LetterB = (CheckBox) findViewById(R.id.question6_Answer2);
        question6_LetterC = (CheckBox) findViewById(R.id.question6_Answer3);

        // checks if they match to correct answers
        if( question6_LetterB.isChecked() && question6_LetterC.isChecked()) {
            score = score +1;
        }
        // END OF CHECKBOX CHECK QUESTION 6


        ////////////// CHECKS QUESTION 10
        // checks if the number in the box is 3
        if(quantity == 8) {
            score = score + 1;
        }
        ////////// END FOR QUESTION 10

        // Displays the score at the bottom
        TextView textArea = findViewById(R.id.textArea);
        textArea.setText("Congratulations " + userName + ". You scored " + score + " out of 10 points!");
        Toast.makeText(this, "Score: " + score + " out of 10", Toast.LENGTH_SHORT).show();


    }

    // Methods below of display(), increment(), decrement() all relate to question 10
    /**
     * This method displays the given quantity value on the little box.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText( "" + number);
    }

    /**
     * This method is called when the + button is clicked. It increments the current number
     * in the box by 1.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the - button is clicked. It decrements the current number
     * in the box by 1
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You cannot have less than 1 season buddy.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }

    public void resetQuiz(View view) {
        score = 0;
        TextView textArea = findViewById(R.id.textArea);
        textArea.setText("Quiz reset, change your answers.");
    }



}
