package com.example.lab2_4095;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;

import com.example.lab2_4095.controller.NextQuestion;
import com.example.lab2_4095.controller.Score;
import com.example.lab2_4095.model.AllQuestions;
import com.example.lab2_4095.model.Question;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_INDEX = "GAME_MAIN_ACTIVITY";

    private TextView questionView;
    private TextView scoreView;
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button summaryButton;

    AllQuestions allQuestions = new AllQuestions();
    NextQuestion nextQuestion = new NextQuestion();
    Score score = new Score();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        questionView = findViewById(R.id.question_view);
        scoreView = findViewById(R.id.score_view);

        questionView.setText(R.string.q_start);
        scoreView.setText(R.string.initial_score);


        trueButton = findViewById(R.id.t_button);
        falseButton = findViewById(R.id.f_button);
        nextButton = findViewById(R.id.next_button);
        summaryButton = findViewById(R.id.summary_button);


        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = nextQuestion.getCurrentQuestion();
                Question question = null;
                try {
                    question = allQuestions.getQuestion(index);
                } catch (Exception e) {
                    Log.d(TAG_INDEX, "index out of bounds");
                }

                if (question.isQuestionTrue()) {
                    score.correctAnswer();
                    scoreView.setText(String.valueOf(score.getScore()));
                }

                index = nextQuestion.getNextQuestionIndex();
                questionView.setText(allQuestions.getQuestion(index).getQuestionID());
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = nextQuestion.getCurrentQuestion();
                Question question = null;
                try {
                    question = allQuestions.getQuestion(index);
                } catch (Exception e) {
                    Log.d(TAG_INDEX, "index out of bounds");
                }

                if (!question.isQuestionTrue()) {
                    score.correctAnswer();
                    scoreView.setText(String.valueOf(score.getScore()));
                }

                index = nextQuestion.getNextQuestionIndex();
                questionView.setText(allQuestions.getQuestion(index).getQuestionID());
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = nextQuestion.getCurrentQuestion();
                Question question = null;
                try {
                    question = allQuestions.getQuestion(index);
                } catch (Exception e) {
                    Log.d(TAG_INDEX, "index out of bounds");
                }

                score.skipQuestion();
                index = nextQuestion.getNextQuestionIndex();
                scoreView.setText(String.valueOf(score.getScore()));

                questionView.setText(allQuestions.getQuestion(index).getQuestionID());

            }
        });

        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SummaryActivity(view);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void SummaryActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
        intent.putExtra("score", score.getScore());
        startActivity(intent);
        MainActivity.this.finish();
    }
}