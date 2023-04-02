package ru.itmo.lessons.dz_03_04_2023;

public class RepairShop implements Repair {

    private Repair arr[] = new Repair[10];
    private int count = 0;
    private String[] color = {"красный", "черный", "зеленый", "желтный", " синий"};

    public void addRepair(Repair a) {
        if (a != null && count != 10) {
            arr[count] = a;
            count++;
        }
    }

    @Override
    public void repair() {
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (arr[i] instanceof Car) {
                    arr[i].repair();
                    ((Car) arr[i]).setColor(color[(int) (Math.random() * 5)]);
                } else arr[i].repair();
            }
        }

    }

    public void print() {
        for (int i = 0; i < count; i++) {
            arr[i].print();
        }
    }
}
