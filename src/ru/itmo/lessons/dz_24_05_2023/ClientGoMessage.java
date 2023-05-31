package ru.itmo.lessons.dz_24_05_2023;

import ru.itmo.lessons.yrok17_05_2023.Message;
import ru.itmo.lessons.yrok17_05_2023.ReadWrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class ClientGoMessage extends Thread {

    public ReadWrite readWrite;


    public ClientGoMessage(ReadWrite readWrite) {
        this.readWrite = readWrite;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String text;
        while (true) {
            System.out.println("Введите сообщение для отправки, /exit для выхода ");
            text = scanner.nextLine();
            if (text.equals("/exit")) {
                readWrite.close();
                break;
            }
            Message message = new Message(text);
            try {
                readWrite.writeMessage(message);
            } catch (IOException e) {
                System.out.println("Соеденение с сервером потеряно");
                try (FileWriter writer = new FileWriter("message.txt", true)) {
                    // запись всей строки
                    writer.write(text);
                }catch (IOException ex){
                    System.out.println("ошибка создания файла");
                    ;
                }
            }
        }
    }
}
