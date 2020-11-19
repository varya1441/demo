package com.example.demo.controller;

import com.example.demo.entity.Case;
import com.example.demo.storage.CaseStorage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class CaseController {

    private final CaseStorage caseStorage;

    public CaseController(CaseStorage caseStorage) {
        this.caseStorage = caseStorage;
    }

    @PostMapping
    public void addCases(@RequestBody List<Case> cases) {
        caseStorage.setCases(cases);
    }

    @GetMapping
    public List<Case> getCases() {
        return caseStorage.getCases();
    }
}
