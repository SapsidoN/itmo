package ru.itmo.lessons.dz_03_04_2023;

public abstract class Vehicle {

    protected int wearLevel = 0;
    protected final String number;

    protected String Color;

    public Vehicle(int waer, String number, String color) {
        if (waer >= 0 && number != null && color != null) {
            this.wearLevel = waer;
            this.number = number;
            this.Color = color;
        } else throw new IllegalArgumentException("ОШИБКА ДАННЫХ");
    }

    public void setColor(String color) {
        if (color != null) {
            this.Color = color;
        } else throw new IllegalArgumentException("ОШИБКА ДАННЫХ");
    }


}


