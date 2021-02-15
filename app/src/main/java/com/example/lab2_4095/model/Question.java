package com.example.lab2_4095.model;

public class Question {

    private int id;
    private boolean answerIsTrue;

    public Question(int id, boolean isTrue) {
        this.id = id;
        answerIsTrue = isTrue;
    }

    public int getQuestionID() {
        return id;
    }
    public boolean isQuestionTrue() {return answerIsTrue;}

}
