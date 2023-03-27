package dz27_03_2023;

import java.util.Arrays;
import java.util.Scanner;

public class Progect6 {
    public static void main(String[] args) {

        //1
        Scanner in = new Scanner(System.in);
        String str;
        char bwt;
        System.out.println("Напишите строки");
        do {
            str = in.nextLine();
            StringBuilder wtf = new StringBuilder(str.strip());
            wtf.setCharAt(0, Character.toUpperCase(wtf.charAt(0)));
            str = wtf.toString();
            System.out.println(str + " \n чтоб выйти напишите exit");

        } while (!"exit".equalsIgnoreCase(str));

        String text = "Дан текст: JAVA стоит первым в рейтинге популярности использования языков; JAVA один из наиболее мощных высокоуровневых языков программирования;\n " +
                "JAVA поддерживает большое количество встроенных библиотех, которые позволяют быстро писать проекты любого класса сложности; курс «JUNIOR JAVA DEVELOPER»\n" +
                "предназначен для подготовки программистов-профессионалов, специализирующихся на разработке программного обеспечения различного класса и уровня сложности. ";
// 3

        String poisk = "JAVA";
        int count = 0;
        String[] arr = text.split(" ");
        for (var a : arr) {
            if ("JAVA".equals(a)) count++;
        }
        System.out.println(count);
        //2

        text = text.replaceAll(" JAVA", "PYTHON");
        System.out.println(text);

//massiv
//1
        System.out.println("Введите размер массива ");
        int size = in.nextInt();
        int arr_int[] = new int[size];
        for (int i = 0; i < arr_int.length; i++) {
            arr_int[i] = (int) (Math.random() * 101);
        }
        int sum = arr_int[0];
        int min = arr_int[0];
        int max = arr_int[0];
        double sred = 0;
        for (int i = 1; i < arr_int.length; i++) {
            if (i == 0) min = arr_int[i];
            if (min > arr_int[i]) min = arr_int[i];
            if (max < arr_int[i]) max = arr_int[i];
            sum += arr_int[i];
        }
        sred = sum / arr_int.length;
        System.out.println("max= " + max + "  min= " + min + " sred= " + sred + " sum= " + sum);
        //2
        int rand = 1;
        int[] arr_2 = new int[10];
        for (int i = 0; i < arr_2.length; ) {
            rand = (int) (Math.random() * 21);
            if (rand % 2 == 0) {
                arr_2[i] = rand;
                i++;
            }
        }
        Arrays.sort(arr_2);
        for (int i = arr_2.length - 1; i > 0; i--) {
            System.out.println(arr_2[i]);
        }

        //3
        System.out.println("Введие размер массива");
        size = in.nextInt();
        String[] arr2 = new String[size];
        String end;
        int size_str = 0;
        boolean prov = true;

        for (int i = size_str; i < arr2.length; ) {
            prov = true;
            System.out.println("Введие слово");
            end = in.next();
            if ("Exit".equalsIgnoreCase(end)) break;
            for (int j = 0; j < i; j++) {
                if (arr2[j].equalsIgnoreCase(end)) {
                    prov = false;
                    break;
                }
            }
            if (prov == true) {
                arr2[i] = end;
                i++;
                size_str++;
            }


        }
        for (int i = 0; i < size_str; i++) {
            System.out.println(arr2[i]);
        }

        String text1 = "в предложении все слова разной длины";
        arr2 = text1.split(" ");

        StringBuilder a = new StringBuilder(text1);
        StringBuilder maxx = new StringBuilder(arr2[0]);
        for (int i = 1; i < arr2.length; i++) {
            if (maxx.length() < arr2[i].length()) maxx = new StringBuilder(arr2[i]);
        }
        System.out.println("самое длинное слово = " + maxx);

        //5
        int coutn = 0;
        int[] arr1 = new int[100];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 200 - 100);
            if (arr1[i] < 0) coutn++;
        }
        int[] arr11 = new int[coutn];
        for (int i = 0, j = 0; i < arr1.length; i++) {
            if (arr1[i] < 0) {
                arr11[j] = arr1[i];
                j++;
            }
        }
        for (var c : arr11) {
            System.out.println(c);

        }

//
    }

}
