package com.github.viqbgrg.jackson.parsedeparse;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.StdConverter;

/**
 * @author hhj
 */
public class MyConverter extends StdConverter<String, Integer> {


    @Override
    public Integer convert(String value) {
        if ("admin".equals(value)){
            return 1;
        }else {
            return 2;
        }
    }

}
