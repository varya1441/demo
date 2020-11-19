package com.example.demo.controller;

import com.example.demo.storage.ParamStorage;
import com.example.demo.entity.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/params")
public class ParamController {

    private final ParamStorage paramStorage;
    private Map<String, String> map = Map.of("По строению скелета", "BySkeleton",
                                             "Морские", "Sea",
                                             "По содержанию жира", "ByFatContent",
                                             "Хищная",  "Predator",
                                             "По длине", "Length");

    public ParamController(ParamStorage paramStorage) {
        this.paramStorage = paramStorage;
    }

    @GetMapping
    public String getAllParams(Model model) {
        List<String> paramNames = paramStorage.getParams().stream()
                .map(Param::getName)
                .collect(Collectors.toList());

        paramNames.forEach(name -> {
            model.addAttribute("param" + map.get(name) + "Name", name);
            model.addAttribute("param" + map.get(name) + "Values", paramStorage.getValues(name));
        });
        return "select";
    }
}
