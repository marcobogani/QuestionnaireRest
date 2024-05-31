package com.torbogatti.questionnairerest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {
    @JsonProperty("id")
    private int questionId;
    @JsonProperty("value")
    private String text;

    public Answer(){}

    public Answer(int questionId, String text) {
        this.questionId = questionId;
        this.text = text;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
