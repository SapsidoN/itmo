package dz27_03_2023;

import java.util.Arrays;

public class Progect6 {
    public static void main(String[] args) {
       /*7. Как проверить строку на палиндром?
            Есть два способа: первый через вложеность цикла проверя на равенство  индекс который идет сначала, и индекс который идет с конца
            Второй способ: записать строку в  StringBuilder вызвать метод reverse() и сравнить с исходной строкой через toString
         8. Для чего нужны классы StringBuilder и StringBuffer?
            Эти классы классы нужны для работы с текстом (если нам нужно редактировать или выполнять другие операции)
         9. Перечислите способы конкатенации строк
            оператор + или метод equals
         10.Строка вида "Привет" + " мир " + "!" высчитывается на этапе компиляции или во время выполнения прокраммы?
            на этапе компиляции
           11.Есть ли ошибка в следующем коде? Если есть, то какая?
           String someText = значение приходит из другой программы;
        if (someText.startsWith("Java") && someText != null) System.out.println("Речь пойдет о Java");
            текс должен быть в " ";
            могу ошибаться но лучше сначалапроверить на нулл, а затем && someText.startsWith("Java")
// 12. Что будет выведено в консоль (подумайте сами, не запуская программу)?
        boolean String = false;
        System.out.println(String);
        Грубая ошибка использовать String как имя переменной
        // 13. Что будет выведено в консоль (подумайте сами, не запуская программу)?
        String text = "300 р., 4100 р., 911 р., 6500 р.,";
        String[] prices = text.split("р.,");
        System.out.println(Arrays.toString(prices));
        300 4100 911 6500
        // 13. Сколько объектов строк мы получим в программе?
        System.out.println("Строка" + new String("Строка"));
        String str01 = "Строка";
        String str02 = "строка";
        String str03 = new String("Строка");
        4
        // 14. Как узнать количество слов в строке?
        Можно пройти циклом и посчитать пробелы через условия сравнивая charAt(i) c кодом пробела,
        Сделать split(" ") получим массив строк, длинна массива равна количеству слов
        ps если пробелов несколько между словами использоват split(" +")
        // 15. Как узнать количество символов в строке?
        если все символы вклучая пробел вызвать метод length;
        если такой метод не подходит, то циклом пройти по всей строке количество количество итераций будет равна кол символов


// Массивы
        // 1. Является ли массив ссылочным типом? ДА
        // 2. Можно ли хранить в массиве разные типы данных? НЕТ
        // 3. Как добавить новый элемент в массив?
              arr1- изначальный, arr2-новый;
        создаем arr2[arr1.length+1]
        переносим все элименты arr1 в arr2 циклом
        затем добовляем новый элемент.

        если надо добавть на определенное место новый элемент
        то переносим элементы до этого места потом новый элемнт,а затем снова переносим оставшиеся элементы
        надеюсь смог обьяснить

        // 4. Как сравнить массивы?
              сравнить можно ссылки через ==
              можно сравнить элементы через цикл
              if(arr[i]==arr2[i])
              или просто использовать equals
        // 5. Как осуществляет поиск метод Arrays.binarySearch?
              сравнивает поиск с серединой если искомое число больше то смешаем левую границу к середине и +1
              и наоборот
        // 6. Как сортирует метод Arrays.sort?
        быстрая сортировка
        // 7. Почему следующий код приведет к ошибке?
        int[] ints = {34, 78};
        ints.length = 10;
        длинну массива не изменить
        // 8. Может ли длина массива быть равной 0?
        да
        // 9. Что будет выведено в консоль (подумайте сами, не запуская программу)?
        String[] ints = {"7", "34","346", "15", "0"};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        Скорее всего сортирует по ASCII
        0 15 34 346 7
        // 10. Найти сумму значений элементов массива
        int[][] ints = {{1, 4, 7}, {22, 88, 89, 76},};
          */
        int[][] ints = {{1, 4, 7}, {22, 88, 89, 76},};
        int summa = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                summa += ints[i][j];
            }
        }

        // 11. На каких итерация программа выведет true, а на каких false (подумайте сами, не запуская программу)? Почему?
        String[] cats = {"Мурка", new String("Васька"), "Гоша", "Васька", "Рыжик"};
        for (String cat : cats) {
            System.out.println(cat == "Васька");
        }
        // на 4 так как ссылки указывают на одну и туже чать памяти в пулле
        //new String будет false так как он находиться в куче и ссылки отличаются

    }
}
