package com.example.lab2_4095.controller;

public class NextQuestion {

//    public NextQuestion(int total_qs) {
//        total_number_of_questions = total_qs;
//    }

    private static int index = 0;
    // public static int total_number_of_questions = 0;

    public int getCurrentQuestion() {
        return index;
    }

    public static int getNextQuestionIndex() {
        index++;
        return index;
    }
}
