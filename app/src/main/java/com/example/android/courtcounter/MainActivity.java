package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.android.courtcounter.R.id.pointb_3_btn;

public class MainActivity extends AppCompatActivity {

    final int POINTS_FOR_FREE_THROW = 1;
    final int POINTS_FOR_3POINT_THROW = 3;
    final int POINTS_FOR_2POINT_THROW = 2;
    final int RESET_SCORE = 0;
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button point_3_btn = (Button) findViewById(R.id.point_3_btn);
        Button point_2_btn = (Button) findViewById(R.id.point_2_btn);
        Button freeThrowButton = (Button) findViewById(R.id.freeThrowBtn);
        Button resetBtn = (Button) findViewById(R.id.reset);
        Button pointb_3_btn = (Button) findViewById(R.id.pointb_3_btn);
        Button pointb_2_btn = (Button) findViewById(R.id.pointb_2_btn);
        Button freeThrowButtonb = (Button) findViewById(R.id.freeThrowBtnb);
        point_2_btn.setOnClickListener(btnHandler);
        point_3_btn.setOnClickListener(btnHandler);
        freeThrowButton.setOnClickListener(btnHandler);
        pointb_2_btn.setOnClickListener(btnHandler);
        pointb_3_btn.setOnClickListener(btnHandler);
        freeThrowButtonb.setOnClickListener(btnHandler);
        resetBtn.setOnClickListener(btnHandler);

    }
    View.OnClickListener btnHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.freeThrowBtn: {
                    scoreTeamA += POINTS_FOR_FREE_THROW;
                    displayForTeamA(scoreTeamA);
                    break;
                }
                case R.id.point_2_btn: {
                    scoreTeamA += POINTS_FOR_2POINT_THROW;
                    displayForTeamA(scoreTeamA);
                    break;
                }
                case R.id.point_3_btn: {
                    scoreTeamA += POINTS_FOR_3POINT_THROW;
                    displayForTeamA(scoreTeamA);
                    break;
                }
                case R.id.freeThrowBtnb: {
                    scoreTeamB += POINTS_FOR_FREE_THROW;
                    displayForTeamB(scoreTeamB);
                    break;
                }
                case R.id.pointb_2_btn: {
                    scoreTeamB += POINTS_FOR_2POINT_THROW;
                    displayForTeamB(scoreTeamB);
                    break;
                }
                case pointb_3_btn: {
                    scoreTeamB += POINTS_FOR_3POINT_THROW;
                    displayForTeamB(scoreTeamB);
                    break;
                }
                case R.id.reset:{
                    resetGame();
                }

            }
        }
    };

    private void resetGame() {
        scoreTeamA = RESET_SCORE;
        scoreTeamB = RESET_SCORE;
        displayForTeamA(RESET_SCORE);
        displayForTeamB(RESET_SCORE);
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
