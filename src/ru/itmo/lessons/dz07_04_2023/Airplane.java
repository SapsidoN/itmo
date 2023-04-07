package ru.itmo.lessons.dz07_04_2023;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class Airplane {

    private String name="Боинг";
    private Calendar calendar;

    public Airplane(Calendar a){
        calendar=a;
    }


    public Calendar getCalendar() {
        return calendar;
    }
}
