package com.softserve.edu.controller;

import com.softserve.edu.dto.AddDto;
import com.softserve.edu.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AddController {

    private CalcService calcService;

    @Autowired
    public AddController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/api/add")
    public AddDto addValues(
            //@Valid @RequestBody AddDto addDto
            @RequestParam(value = "firstValue", required = false, defaultValue = "0")
            String firstValue,
            @RequestParam(value = "secondValue", required = false, defaultValue = "0")
            String secondValue) {
        log.info("RestController started, firstValue = " + firstValue + "  secondValue = " + secondValue);
        return calcService.calcAdd(firstValue, secondValue);
    }
}
