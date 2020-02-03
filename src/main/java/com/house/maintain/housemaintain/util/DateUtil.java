package com.house.maintain.housemaintain.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDate convert(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-d-yyyy");
        return LocalDate.parse(date, formatter);
    }
}
