package com.torbogatti.questionnairerest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Submission {
    private UUID uuid;
    @JsonProperty("tax_id")
    private String taxId;

    private Answer[] answers;

    private boolean isRisk;

    public Submission(){}

    public Submission(UUID uuid, String taxId, Answer[] answers, boolean isRisk) {
        this.uuid = uuid;
        this.taxId = taxId;
        this.answers = answers;
        this.isRisk = isRisk;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }

    public boolean isRisk() {
        return isRisk;
    }

    public void setRisk(boolean risk) {
        isRisk = risk;
    }
}
