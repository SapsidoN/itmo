package dz22_03_2023;

import java.util.Scanner;

public class Project5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //1
        for (int i = 2; i < 21; i += 2) {
            System.out.print(i + " ");
        }
        //2
        System.out.println("\nВведите любое положительное число");
        int number = in.nextInt();
        int count = 0;
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
            count++;

        }
        System.out.println("summa=" + result);
        //3
        int rand = 2 + (int) (Math.random() * 8);
        boolean start = true;
        do {
            System.out.println("Введите число от 2 до 9");
            short gam = in.nextShort();
            if (gam == rand) {
                System.out.println("Поздравляю вы угадали");
                start = false;
            } else if (gam > rand) {
                System.out.println("Ваше число больше, попробуйте снова ");
            } else if (gam < rand) {
                System.out.println("Ваше число меньше, попробуйте снова ");
            } else if (gam == 0) {
                System.out.println("выход из программы");
                start = false;
            } else
                System.out.println("ошибка ввода, попробуйте снова ");

        } while (start);

        //4
        System.out.println("Введите число от 2 до 100");
        number = in.nextInt();
        int first = 2;
        int last = 100;
        while (first <= last) {
            if (number < 2 || number > 100) {
                System.out.println("нарушать нельзя давай сначала!!!!");
                System.out.println("Ввеидте число от 2 до 100");
                number = in.nextInt();
                continue;
            }
            int numberCPU = (first + last) / 2;
            System.out.println("ваше число это " + numberCPU + " (0-no 1-yes)");
            short boll = in.nextShort();
            if (boll == 0) {
                System.out.println("ваше число больше? (0-no 1-yes)");
                boll = in.nextShort();
                if (boll == 1) {
                    first = numberCPU + 1;
                } else if (boll == 0) {
                    last = numberCPU - 1;
                }
            } else if (boll == 1) {
                System.out.println("Спасибо за игру");
                break;
            }

        }
    }
}


