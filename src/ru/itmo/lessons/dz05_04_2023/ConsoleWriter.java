package ru.itmo.lessons.dz05_04_2023;

public class ConsoleWriter extends AppLogger implements Innnn {


    @Override
    public void log(String str) {
        System.out.println(str);
    }

}
