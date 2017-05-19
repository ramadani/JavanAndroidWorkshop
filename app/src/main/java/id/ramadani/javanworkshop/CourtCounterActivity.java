package id.ramadani.javanworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CourtCounterActivity extends AppCompatActivity {
    private final int POINT_FOR_THREE_POINT = 3;
    private final int POINT_FOR_TWO_POINT = 2;
    private final int POINT_FOR_FREE_THROW = 1;

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_counter);
        setTitle(R.string.court_counter);

        displayForTeamA(scoreTeamA);
    }

    public void addThreeForTeamA(View view) {
        scoreTeamA += POINT_FOR_THREE_POINT;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA(View view) {
        scoreTeamA += POINT_FOR_TWO_POINT;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamA(View view) {
        scoreTeamA += POINT_FOR_FREE_THROW;
        displayForTeamA(scoreTeamA);
    }

    public void addThreeForTeamB(View view) {
        scoreTeamB += POINT_FOR_THREE_POINT;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View view) {
        scoreTeamB += POINT_FOR_TWO_POINT;
        displayForTeamB(scoreTeamB);
    }

    public void addOneForTeamB(View view) {
        scoreTeamB += POINT_FOR_FREE_THROW;
        displayForTeamB(scoreTeamB);
    }

    private void displayForTeamA(int score) {
        TextView scoreTeamA = (TextView) findViewById(R.id.tv_team_a_score);
        scoreTeamA.setText(String.valueOf(score));
    }

    private void displayForTeamB(int score) {
        TextView scoreTeamB = (TextView) findViewById(R.id.tv_team_b_score);
        scoreTeamB.setText(String.valueOf(score));
    }
}
