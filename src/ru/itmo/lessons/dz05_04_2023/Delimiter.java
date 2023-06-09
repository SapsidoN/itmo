package ru.itmo.lessons.dz05_04_2023;

//
public class Delimiter extends AppLogger {

    private Inter up;


    public Delimiter(Inter up) {
        if (up != null) {
            this.up = up;
        } else throw new IllegalArgumentException("НУЛЛ");
    }

    @Override
    public void log(String str) {
        str = new String("===" + str + "===");
        this.str = str;
        if (up != null) up.log(this.str);
    }

}
