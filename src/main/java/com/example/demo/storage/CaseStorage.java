package com.example.demo.storage;

import com.example.demo.entity.Case;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseStorage {

    private List<Case> cases;

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }
}
