package com.softserve.edu.service.impl;

import com.softserve.edu.dto.AddDto;
import com.softserve.edu.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalcServiceImpl implements CalcService {

    public AddDto getBlank() {
        return AddDto.builder()
                .firstValue("")
                .secondValue("")
                .result("")
                .build();
    }

    public AddDto calcAdd(AddDto addDto) {
        int arg0 = strToInt(addDto.getFirstValue());
        int arg1 = strToInt(addDto.getSecondValue());
        addDto.setFirstValue(intToStr(arg0));
        addDto.setSecondValue(intToStr(arg1));
        addDto.setResult(intToStr(add(arg0, arg1)));
        log.info("CalcServiceImpl done, result = " + addDto);
        return addDto;
    }

    public AddDto calcAdd(String firstValue, String secondValue) {
        AddDto addDto = getBlank();
        addDto.setFirstValue(firstValue);
        addDto.setSecondValue(secondValue);
        return calcAdd(addDto);
    }

    public int add(int arg0, int arg1) {
        int result = arg0 + arg1;
        return result;
    }

    public String intToStr(int value) {
        String result = String.valueOf(value);
        return result;
    }

    public int strToInt(String value) {
        int result = Integer.valueOf(value.replaceAll("\\D",""));
        return result;
    }
}
