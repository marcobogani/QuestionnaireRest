package com.torbogatti.questionnairerest.model;

import java.util.List;

public class Questionnaire {
    private final String title = "General Questionnaire";
    private final List<Question> questions = List.of(
            new Question(1, "Are you over 65 years old?"),  // Age
            new Question(2, "Do you have any pre-existing medical conditions such as heart disease, " +
                    "diabetes, hypertension, asthma, chronic respiratory conditions, or cancer?"),  //  Medical History
            new Question(3, "Have you experienced any of the following symptoms in the past two weeks: " +
                    "fever (temperature above 100.4°F or 38°C), persistent cough, difficulty breathing, loss " +
                    "of taste or smell, or fatigue/weakness?"),  // Symptoms
            new Question(4, "Have you been in close contact with someone diagnosed with COVID-19 or " +
                    "suspected to have it in the past two weeks?"),  // Exposure
            new Question(5, "Have you traveled internationally or to areas with known outbreaks in the " +
                    "past month?")  // Travel History
    );

    public Questionnaire() {
    }

    public String getTitle() {
        return title;
    }


    public List<Question> getQuestions() {
        return questions;
    }

}
