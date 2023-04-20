package ru.itmo.lessons.dz21_04_2023.bounded;

public class Bus extends Vehicle{
    private boolean wifi;

    public Bus(String number) {
        super(number);
    }

    public boolean isWifi() {
        return wifi;
    }

    @Override
    public void repair() {
        super.repair();
        if (!wifi) wifi = true;
    }
}
