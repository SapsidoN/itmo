package ru.itmo.lessons.dz_03_04_2023;

public class main {
    public static void main(String[] args) {
        Bus bus = new Bus(10, "0203", "red", false);
        Train train = new Train(5, 0, "34343");
        Car car = new Car(99, "434343", "желный");

        RepairShop repair = new RepairShop();
        repair.addRepair(bus);
        repair.addRepair(train);
        repair.addRepair(car);

        repair.repair();

        repair.print();

    }
}
