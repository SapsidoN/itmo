package ru.itmo.lessons.dz05_04_2023;

public class Delimiter extends AppLogger {

    private Upper up;

    private AppFileWriter ap;

    public Delimiter(Upper up) {
        if (up != null) {
            this.up = up;
        } else throw new IllegalArgumentException("НУЛЛ");
    }

    public Delimiter(AppFileWriter ap) {
        if (ap != null) {
            this.ap = ap;
        } else throw new IllegalArgumentException("НУЛЛ");
    }

    @Override
    public void log(String str) {
        if (str != null) {
            str = new String("===" + str + "===");
            this.str = str;
        } else throw new IllegalArgumentException("нулл");
        if (up == null) ap.log(this.str);
        else up.log(this.str);

    }


}
