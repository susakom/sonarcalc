package com.softserve.edu.service;

import com.softserve.edu.dto.AddDto;
import com.softserve.edu.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CalcServiceTest {
    @Autowired
    private CalcService calcService;

    @DisplayName("Verification of natural numbers")
    @ParameterizedTest
    @CsvSource(value = {"4,5,9", "1,1,2", "1,0,1"}, delimiter = ',')
    void checkNaturalNumbers(String arg0, String arg1, String expected) {
        log.info("@Test Verification of natural numbers");
        Assertions.assertEquals(expected, calcService.calcAdd(arg0, arg1).getResult());
    }

    @DisplayName("Checking negative numbers")
    @ParameterizedTest
    @CsvSource(value = {"-1,1,2", "-1,-1,2", "0,-1,1"}, delimiter = ',')
    void checkNegativeNumbers(String arg0, String arg1, String expected) {
        log.info("@Test Checking negative numbers");
        Assertions.assertEquals(expected, calcService.calcAdd(arg0, arg1).getResult());
    }

    @DisplayName("Validation of multi-digit numbers")
    @ParameterizedTest
    @CsvSource(value = {"99,1,100", "10,11,21", "1001,10000,11001"}, delimiter = ',')
    void checkMultiDigitNumbers(String arg0, String arg1, String expected) {
        log.info("@Test Validation of multi-digit numbers");
        Assertions.assertEquals(expected, calcService.calcAdd(arg0, arg1).getResult());
    }

}
