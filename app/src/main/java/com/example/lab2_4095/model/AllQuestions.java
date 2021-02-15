package com.example.lab2_4095.model;
import com.example.lab2_4095.R;

public class AllQuestions {

    // 'questionIndex' may not even be needed
    private int questionIndex;

    public  Question[] allQuestions = {
            new Question(R.string.q_start, true),
            new Question(R.string.q_seas, true),
            new Question(R.string.q_continent, true),
            new Question(R.string.q_add3_4, true),
            new Question(R.string.q_add5_4, true),
            new Question(R.string.q_us, true),
            new Question(R.string.q_most_populated, true),
            new Question(R.string.q_color, true),
            new Question(R.string.q_alphabet, true),
            new Question(R.string.q_violet, true),
            new Question(R.string.q_start, true),
    };

    public AllQuestions() {
        questionIndex = 0;
    }

    public Question getQuestion (int index) {
        index = index % allQuestions.length;
        return allQuestions[index];
    }
}
