package com.softserve.edu.controller;

import com.softserve.edu.dto.AddDto;
import com.softserve.edu.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * This controller returns frontend page when application is built as one.
 */
@Slf4j
@Controller
public class MainController {

    private CalcService calcService;

    @Autowired
    public MainController(CalcService calcService) {
        this.calcService = calcService;
    }

    /**
     * Method returns frontend page when application is built as one.
     *
     * @return index page of frontend.
     */
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("addDto", calcService.getBlank());
        return "index.html";
    }

    @PostMapping("/add")
    public String addValues(Model model,
                           @ModelAttribute("AddDto")
                           AddDto addDto) {
        log.info("MainController started, addDto = " + addDto);
        AddDto result = calcService.calcAdd(addDto);
        model.addAttribute("addDto", result);
        return "index.html";
    }
}
