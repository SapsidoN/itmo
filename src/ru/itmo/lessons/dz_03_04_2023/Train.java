package ru.itmo.lessons.dz_03_04_2023;

public class Train extends Vehicle implements Repair {

    private String name = "train";

    private int numberWagons;

    public Train(int koll, int wear, String number) {
        super(wear, number, "красный");
        if (koll > 0) this.numberWagons = koll;
        else throw new IllegalArgumentException("нет вагонов");
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



