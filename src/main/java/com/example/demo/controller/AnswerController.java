package com.example.demo.controller;

import com.example.demo.service.AnswerService;
import com.example.demo.entity.Choice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;
    private static final String DONT_KNOW = "Не знаю";

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public String getAnswer(@RequestParam(value = "По строению скелета", required = false) String bySkeletonValue,
                            @RequestParam(value = "Морские", required = false) String seaValue,
                            @RequestParam(value = "По содержанию жира", required = false) String byFatContentValue,
                            @RequestParam(value = "По длине", required = false) String lengthValue,
                            @RequestParam(value = "Хищная", required = false) String predatorValue,
                            Model model) {
        List<Choice> choices = new ArrayList<>();
        if (!StringUtils.isEmpty(bySkeletonValue) && !DONT_KNOW.equals(bySkeletonValue)) {
            choices.add(new Choice("По строению скелета", bySkeletonValue));
        }
        if (!StringUtils.isEmpty(seaValue)&& !DONT_KNOW.equals(seaValue)) {
            choices.add(new Choice("Морские", seaValue));
        }
        if (!StringUtils.isEmpty(byFatContentValue)&& !DONT_KNOW.equals(byFatContentValue)) {
            choices.add(new Choice("По содержанию жира", byFatContentValue));
        }
        if (!StringUtils.isEmpty(lengthValue)&& !DONT_KNOW.equals(lengthValue)) {
            choices.add(new Choice("По длине", lengthValue));
        }
        if (!StringUtils.isEmpty(predatorValue)&& !DONT_KNOW.equals(predatorValue)) {
            choices.add(new Choice("Хищная", predatorValue));
        }

        model.addAttribute("answers", answerService.getAnswerByChoices(choices));
        return "answer";
   }
}
