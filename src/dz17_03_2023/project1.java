package dz17_03_2023;

import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);

//       1)   Даны длина, ширина прямоугольника. Найти и вывести в консоль его площадь.
            int square, length, width;
            System.out.print("Введите длинну, и ширину: ");
            length = in.nextInt();
            width = in.nextInt();
            System.out.println("площадь =" + (square = length * width));

//       2)   Дано целое число. Найти и вывести в консоль данное число в кубе.
            System.out.print("Введите число: ");
            int number = in.nextInt();
            ;
            System.out.println("куб числа " + number + " равен =" + (number * number * number));
//       3)   Даны две переменные типа double: время (в часах) и расстояние (в километрах). Найти и вывести в консоль скорость, выраженную в метрах в секунду.
            double distance, time;
            System.out.print("Введите расстояние( км.ч), время(в часах):");
            distance = in.nextDouble();
            time = in.nextDouble();
            ;
            System.out.println("скорость равна=" + ((distance / time) * 1000) / 3600 + "м/c");

//       4)   Найти сумму цифр 2х значного числа
            System.out.print("Введите число(2х значное)");
            int num = in.nextInt();
            int num1 = num % 10;
            int num2 = num / 10;
            System.out.println("сумма двух чисел=" + (num1 + num2));

        }
        // Сделал с вводом так как так проще проверять.
    }




