package com.house.maintain.housemaintain.convertors;

import com.house.maintain.housemaintain.util.DateUtil;
import org.dozer.DozerConverter;

import java.time.LocalDate;

public class StringToLocalDateConverter extends DozerConverter<String, LocalDate> {

    public StringToLocalDateConverter(){
        super(String.class,LocalDate.class);
    }

    @Override
    public LocalDate convertTo(String source, LocalDate destination) {
        return DateUtil.convert(source);
    }

    @Override
    public String convertFrom(LocalDate source, String destination) {
        return null;
    }
}
