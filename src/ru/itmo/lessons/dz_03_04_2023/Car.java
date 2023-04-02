package ru.itmo.lessons.dz_03_04_2023;

public class Car extends Vehicle implements Repair {

    private String name = "car";

    public Car(int wear, String number, String color) {
        super(wear, number, color);
    }

    @Override
    public void setColor(String color) {
        if (color != null && color.length() > 3) this.Color = color;
        else throw new IllegalArgumentException("ошибка нулл или цвет<3");
    }

    @Override
    public void repair() {
        if (this != null) {
            this.wearLevel = 0;
        }

    }

    @Override
    public void print() {
        System.out.println(name + "\n" + "износ= " + this.wearLevel + "\nномер:" + number + "\nцвет " + Color);
    }

}
