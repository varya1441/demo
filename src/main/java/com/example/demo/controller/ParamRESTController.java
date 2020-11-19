package com.example.demo.controller;

import com.example.demo.entity.Param;
import com.example.demo.storage.ParamStorage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/params")
public class ParamRESTController {

    private final ParamStorage paramStorage;

    public ParamRESTController(ParamStorage paramStorage) {
        this.paramStorage = paramStorage;
    }

    @PostMapping
    public void addParams(@RequestBody List<Param> params) {
        paramStorage.setParams(params);
    }
}
