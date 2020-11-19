package com.example.demo.service;

import com.example.demo.entity.Case;
import com.example.demo.entity.Choice;
import com.example.demo.storage.CaseStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    private final CaseStorage caseStorage;

    public AnswerService(CaseStorage caseStorage) {
        this.caseStorage = caseStorage;
    }

    public List<Choice> getAnswerByChoices(List<Choice> choices) {

        Predicate<Case> predicate = aCase -> aCase.getChoices().stream()
                .allMatch(choice -> assertChoice(choice, choices));

        return caseStorage.getCases().stream()
                .filter(predicate)
                .map(Case::getAnswer)
                .collect(Collectors.toList());
    }

    private boolean assertChoice(Choice choice, List<Choice> choices) {
        return choices.stream()
                .anyMatch(c -> c.equals(choice));
    }
}
