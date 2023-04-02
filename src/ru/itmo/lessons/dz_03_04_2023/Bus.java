package ru.itmo.lessons.dz_03_04_2023;

public class Bus extends Vehicle implements Repair {

    private String name = "bus";
    private boolean wifi = false;

    public Bus(int wear, String number, String color, boolean wifi) {
        super(wear, number, color);
        this.wifi = wifi;
    }

    @Override
    public void repair() {
        if (this != null) {
            this.wifi = true;
            this.wearLevel = 0;
        }
    }

    @Override
    public void print() {
        System.out.println(name + "\n" + "wifi: " + wifi + "\nизнос= " + this.wearLevel + "\nномер:" + number + "\nцвет " + Color);
    }
}

