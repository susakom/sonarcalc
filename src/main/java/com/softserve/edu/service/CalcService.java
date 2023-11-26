package com.softserve.edu.service;

import com.softserve.edu.dto.AddDto;

public interface CalcService {

    AddDto getBlank();

    AddDto calcAdd(AddDto addDto); // public abstract

    AddDto calcAdd(String firstValue, String secondValue);

    int add(int arg0, int arg1);

    String intToStr(int value);

    int strToInt(String value);
}
