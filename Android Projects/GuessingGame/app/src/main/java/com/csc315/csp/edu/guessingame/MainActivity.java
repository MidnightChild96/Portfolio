package com.csc315.csp.edu.guessingame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    int answer = random.nextInt(100);
    int counter = 0;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button giveUp = (Button) findViewById(R.id.giveUpButton);
        giveUp.setOnClickListener(new giveUpClickListener());

        Button guess = (Button) findViewById(R.id.guessButton);
        guess.setOnClickListener(new guessClickListener());

        Button newGame = (Button) findViewById(R.id.newGameButton);
        newGame.setOnClickListener(new newGameClickListener());

        Button ok = (Button) findViewById(R.id.okButton);
        ok.setOnClickListener(new okClickListener());

        tv = (TextView) findViewById(R.id.textOuput);
        tv.setText("Good Luck!");
    }


    class giveUpClickListener implements View.OnClickListener {
        public void onClick(View v){
            tv = (TextView) findViewById(R.id.textOuput);
            tv.setText("The answer was " + String.valueOf(answer) + ". You guessed " + String.valueOf(counter) + " times.");
        }
    }

    class guessClickListener implements View.OnClickListener{
        public void onClick(View v){
            counter++;
            tv = (TextView) findViewById(R.id.guessInput);
            int guess = Integer.parseInt(tv.getText().toString());
            tv = (TextView) findViewById(R.id.textOuput);
            if(guess > answer){
                tv.setText("Guess is too high. Try again!");
            }
            if(guess < answer){
                tv.setText("Guess is too low. Try again!");
            }
            if(guess == answer){
                tv.setText("Guess is correct. It took " + String.valueOf(counter) + " attemps.");
            }
        }
    }

    class newGameClickListener implements View.OnClickListener{
        public void onClick(View v){
            answer = random.nextInt(100);
            counter = 0;
            tv = (TextView) findViewById(R.id.textOuput);
            tv.setText("Good Luck!");
        }
    }

    class okClickListener implements View.OnClickListener{
        public void onClick(View v) {
            tv = (TextView) findViewById(R.id.textOuput);
            tv.setText("");
        }
    }
}