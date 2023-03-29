package ru.itmo.lessons.yrok27_03_2027.dz29_03_2023;

public class Climber {
    private String name;
    private String ResidentialAddress;

    public Climber(String name, String adres) {
        SetName(name);
        SetAddress(adres);
    }

    public void SetName(String name) {
        if (name != null && name.length() > 3) {
            this.name = name;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public void SetAddress(String adres) {
        if (adres != null && adres.length() > 5) {
            ResidentialAddress = adres;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public void print() {
        System.out.println(name + " " + ResidentialAddress);
    }
}
