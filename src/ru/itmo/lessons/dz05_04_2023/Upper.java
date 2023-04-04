package ru.itmo.lessons.dz05_04_2023;

public class Upper extends AppLogger {

    private ConsoleWriter C;
    private Delimiter D;

    public Upper(ConsoleWriter c) {
        if (c != null) {
            this.C = c;
        } else throw new IllegalArgumentException("нулл");

    }

    public Upper(Delimiter d) {
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
        if (C == null) D.log(this.str);
        else C.log(this.str);
    }
}
