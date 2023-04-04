package ru.itmo.lessons.dz05_04_2023;
//
public class Delimiter extends AppLogger implements Innnn {

    private Innnn up;

    private AppFileWriter ap;

    public Delimiter(Innnn up) {
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
        str = new String("===" + str + "===");
        this.str = str;
        if (up == null) ap.log(this.str);
        else
            up.log(this.str);
    }

}
