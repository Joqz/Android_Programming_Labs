package com.example.eggtimer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //Getting the timer intent and the extra attached to it
        Intent intent = getIntent();
        String string = intent.getStringExtra("Timer activity");

        final TextView textView = findViewById(R.id.timer);
        textView.setText(string);

        //Constructing countdowntimer
        assert string != null;
        new CountDownTimer(Integer.parseInt(string) * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText("" + millisUntilFinished / 1000);
            }

            //Once the timer finishes, play nuclear meltdown alert ':D'
            public void onFinish() {
                textView.setText("Time's up!");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarm);
                mediaPlayer.start();
            }
        }.start();
    }

    //Cancel the alarm when going back
    @Override
    public void onBackPressed() {

        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            super.onBackPressed();
        }

        else{
            super.onBackPressed();
        }
    }
}
