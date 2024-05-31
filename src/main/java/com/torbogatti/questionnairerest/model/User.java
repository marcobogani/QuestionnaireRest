package com.torbogatti.questionnairerest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("tax_id")
    private String taxId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;

    public User() {
    }

    public User(String taxId, String name, String surname) {
        this.taxId = taxId;
        this.name = name;
        this.surname = surname;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "taxId='" + taxId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
