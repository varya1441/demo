package com.example.demo.entity;

import java.util.List;

public class Case {

    private List<Choice> choices;
    private Choice answer;

    public Choice getAnswer() {
        return answer;
    }

    public void setAnswer(Choice answer) {
        this.answer = answer;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
