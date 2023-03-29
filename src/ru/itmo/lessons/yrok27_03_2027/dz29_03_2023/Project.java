package ru.itmo.lessons.yrok27_03_2027.dz29_03_2023;

import ru.itmo.lessons.yrok27_03_2027.dz29_03_2023.Task2.MyAllowedProducts;
import ru.itmo.lessons.yrok27_03_2027.dz29_03_2023.Task2.Product;

public class Project {
    public static void main(String[] args) {
        //1
        String[] Name_gor = {"Эверест", "Тибет", "Чогори", "эльбрус"};
        String[] NameCliber = {"олег", "маша ", "паша ", "ира ", "илья "};
        String[] Countru = {"Россия", "Молдавия ", "Украина", "Беларусия", "Англия"};
        Climber[] ArrCli = new Climber[3];
        Climber[] ArrCli2 = new Climber[2];
        Climber[] ArrCli3 = new Climber[2];
        Mountain[] gor = new Mountain[3];
        Group[] arr = new Group[3];
        for (int i = 0; i < 3; i++) {
            gor[i] = new Mountain(Name_gor[(int) (Math.random() * 4)], Countru[(int) (Math.random() * 4)], 101 + (int) (Math.random() * 10000));
            ArrCli[i] = new Climber(NameCliber[(int) (Math.random() * 5)], Countru[(int) (Math.random() * 5)]);
        }
        for (int i = 0; i < 2; i++) {
            ArrCli2[i] = new Climber(NameCliber[(int) (Math.random() * 5)], Countru[(int) (Math.random() * 5)]);
            ArrCli3[i] = new Climber(NameCliber[(int) (Math.random() * 5)], Countru[(int) (Math.random() * 5)]);
        }


        arr[0] = new Group(false, ArrCli, gor[(int) Math.random() * 3]);
        arr[1] = new Group(true, ArrCli2, gor[(int) Math.random() * 3]);
        arr[2] = new Group(true, ArrCli3, gor[(int) Math.random() * 3]);


        for (var a : arr) {
            a.print();
            System.out.println("\n");
        }

        //2


        Product p1 = new Product("мясо", 5, 5, 5, 5);
        Product p2 = new Product("молоко", 5, 5);
        Product p3 = new Product("яйцо", 5, 5, 5);
        Product p4 = new Product("хлеб", 5);
        Product p5 = new Product("вода", 5, 5, 5, 0);

        MyAllowedProducts my = new MyAllowedProducts(5, 5, 5, 0);


        my.AddProduct(p1);
        my.AddProduct(p2);
        my.AddProduct(p3);
        my.AddProduct(p4);
        my.AddProduct(p5);

        my.PrintProduct();

    }


}
