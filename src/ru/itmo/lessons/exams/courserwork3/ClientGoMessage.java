package ru.itmo.lessons.exams.courserwork3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClientGoMessage extends Thread {


    public ReadWrite readWrite;
    public String menu = "Введите сообщение или команду для продолжения" +
            "\n/Отправить файл" +
            "\n/Выход";

    public ClientGoMessage(ReadWrite readWrite) {
        this.readWrite = readWrite;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String text;
        boolean flag = true;
        while (flag) {
            System.out.println(menu);
            text = scanner.nextLine();
            try {
                switch (text) {
                    case "/Отправить файл" -> fileMessageToServers();
                    case "/Выход" -> {
                        readWrite.close();
                        flag = false;
                    }
                    default -> textMessage(text);
                }
            } catch (IOException e) {
                System.out.println("Соеденение с сервером потеряно");
                try (FileWriter writer = new FileWriter("message.txt", true)) {
                    // запись всей строки
                    writer.write(text);
                } catch (IOException ex) {
                    System.out.println("ошибка создания файла");

                }
            }
        }
    }

    public void textMessage(String string) throws IOException {       // Cоздание и отправка сообшения
        readWrite.writeMessage(new Message(string));
    }

    public void fileMessageToServers() throws IOException {  // Cоздание и отправка файла
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до файла, и комент");
        String text = scanner.nextLine();
        String com = scanner.nextLine();
        FileTxt fileTxt = new FileTxt();
        fileTxt.addFile(text, com);
        readWrite.writeFile(fileTxt);


    }
}
