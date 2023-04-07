package ru.itmo.lessons.dz07_04_2023;

import java.time.ZoneId;
import java.util.*;

public class main {
    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar(2016,7,16,19,0);
        calendar.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Australia/Sydney")));
        Date date=calendar.getTime();
        System.out.println(date);
        Airplane airplane=new Airplane(calendar);

        airplane.getCalendar().add(calendar.HOUR_OF_DAY,15);
        airplane.getCalendar().add(calendar.MINUTE,35);
        airplane.getCalendar().setTimeZone(TimeZone.getTimeZone(ZoneId.of("America/Chicago")));
        airplane.getCalendar().add(calendar.HOUR_OF_DAY,1);
        System.out.println("вылет из Хьюстона :" + airplane.getCalendar().getTime());
        airplane.getCalendar().add(calendar.HOUR_OF_DAY,2);
        airplane.getCalendar().add(calendar.MINUTE,49);
        airplane.getCalendar().setTimeZone(TimeZone.getTimeZone(ZoneId.of("America/New_York")));
        airplane.getCalendar().add(calendar.HOUR_OF_DAY,1);
        airplane.getCalendar().add(calendar.MINUTE,10);
        System.out.println("вылет из Вышингтон :" + airplane.getCalendar().getTime());
        airplane.getCalendar().add(calendar.HOUR_OF_DAY,1);
        airplane.getCalendar().add(calendar.MINUTE,40);
        airplane.getCalendar().setTimeZone(TimeZone.getTimeZone(ZoneId.of("America/Toronto")));
        System.out.println("Время прибытия! в аэропорт Оттавы :" + airplane.getCalendar().getTime());

        Date datee = new Date();
        System.out.println(datee.getHours());

        if(datee.getHours()>=7 && datee.getHours()<=15){
            System.out.println("1 смена");
        } else if (datee.getHours()>=15 && datee.getHours()<=32) {
            System.out.println("2 смена");
        }else if (datee.getHours()>=23 && datee.getHours()<=7) {
        System.out.println("3 смена");
    }


    }
}
