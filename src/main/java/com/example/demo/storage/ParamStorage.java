package com.example.demo.storage;

import com.example.demo.entity.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParamStorage {

    private List<Param> params;

    public List<String> getValues(String paramName) {
        return params.stream()
                .filter(p -> p.getName().equals(paramName))
                .flatMap(p -> p.getValues().stream())
                .collect(Collectors.toList());
    }

    public Param getByName(String name) {
        return params.stream()
                .filter(p -> p.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }
}
