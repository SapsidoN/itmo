package ru.itmo.lessons.dz05_04_2023;

public class Upper extends AppLogger implements Innnn {

    private Innnn D;

    public Upper(Innnn d) {
        if (d != null) {
            this.D = d;
        } else throw new IllegalArgumentException("нулл");

    }


    @Override
    public void log(String str) {
        if (str != null) {
            str = str.toUpperCase();
            this.str = str;

        } else throw new IllegalArgumentException("null");
        D.log(this.str);
    }
}
