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

    private void displayForTeamA(int score) {
        TextView scoreTeamA = (TextView) findViewById(R.id.tv_team_a_score);
        scoreTeamA.setText(String.valueOf(score));
    }
}
