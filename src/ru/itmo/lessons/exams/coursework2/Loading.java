package ru.itmo.lessons.exams.coursework2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Loading implements Command {
    @Override
    public void on(User user) {
        System.out.println("Меню загрузки");
        try {
            File fileReader = new File("SaveS.txt");
            ArrayList<String> text = new ArrayList<>();
            Scanner scanner = new Scanner(fileReader);
            scanner.useDelimiter("//");
            while (scanner.hasNext()) {
                text.add(scanner.next());
            }
            for (int i = 0; i < text.size(); i++) {
                System.out.println(i + 1 + " " + text.get(i));
            }
            scanner = new Scanner(System.in);
            System.out.println("Выберите сохранение");
            int a = scanner.nextInt();
            user.setSaveText(text.get(a - 1).substring(text.get(a - 1).indexOf(";") + 1));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }


    }

