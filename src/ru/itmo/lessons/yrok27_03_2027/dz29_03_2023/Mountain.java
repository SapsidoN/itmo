package ru.itmo.lessons.yrok27_03_2027.dz29_03_2023;

public class Mountain {
    private String Name;
    private String Country;
    private double Height;

    public Mountain(String name, String Country, int Height) {
        SetName(name);
        SetCountry(Country);
        SetHeight(Height);
    }

    public void SetName(String name) {
        if (name != null && name.length() > 4) {
            this.Name = name;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public void SetCountry(String count) {
        if (count != null && count.length() > 4) {
            Country = count;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public void SetHeight(double he) {
        if (he > 100) {
            Height = he;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public  void print(){
        System.out.println(Name + " " + Country + " " + Height );
    }
}
