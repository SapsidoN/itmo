package ru.itmo.lessons.exams.coursework2;

import java.io.IOException;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) throws IOException {

        User user = null;
        boolean flag = false;
        TextQuest textQuest = new TextQuest();
        Users users = new Users();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (flag == false) {
                System.out.println(Menu.menuL());
            } else {
                System.out.println(Menu.menuS());
            }
            String men = scanner.nextLine();
            switch (men) {
                case "1":
                    if (user == null) {
                        System.out.println("Чтоб начать игру выберите пользователя");
                        user = users.enterUsers();
                        break;
                    }
                    new Start().on(user);
                    flag = true;
                    textQuest.logigGame(user.getSaveText(), user);
                    break;
                case "2":
                    if (flag == true) {
                        new Save().on(user);
                        break;
                    }
                    new Loading().on(user);
                    break;
                case "3":
                    user = users.enterUsers();
                    break;
                case "4":
                    return;
            }
        }


    }
}
