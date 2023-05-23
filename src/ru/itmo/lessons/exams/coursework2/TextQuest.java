package ru.itmo.lessons.exams.coursework2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextQuest {
    private List<String> strings;


    public TextQuest() throws IOException {
        strings = new ArrayList<>();
        setStrings();
    }


    private void setStrings() throws IOException {
        File file = new File("file.txt");
        file.createNewFile();
        String text = "";
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("//");
        while (scanner.hasNextLine()) {
            strings.add(scanner.next());
        }

    }

    public String logigGame(String string, User user) {
        Scanner scanner = new Scanner(System.in);
        int kol = -1;
        for (var a : strings) {
            kol++;
            if (a.contains(string.toUpperCase())) {
                System.out.println(a);
                if (a.contains("Игра завершилась неудачей") || a.contains("Игра завершилась успехом")) {
                    return null;
                }
                break;
            }
        }
        String ss = scanner.nextLine();
        if (ss.equals("3")) {
            user.setSaveText(string);
            return string;
        }
        int a = strings.get(kol).lastIndexOf(ss);
        if (ss.contains("1")) {
            string = strings.get(kol).substring(a + 2, strings.get(kol).indexOf("2"));
        } else string = strings.get(kol).substring(strings.get(kol).indexOf("2") + 2, strings.get(kol).length());
        if (string.contains("->")) {
            string = string.substring(string.indexOf(">") + 2);
        }
        logigGame(string, user);
        return null;
    }


    public void print() {
        for (var a : strings) {
            System.out.println(a.toString());
            System.out.println("\n");
        }
    }


}
