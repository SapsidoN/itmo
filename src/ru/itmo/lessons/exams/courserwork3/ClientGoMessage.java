package ru.itmo.lessons.exams.courserwork3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ClientGoMessage extends Thread {

    public ReadWrite readWrite;


    public ClientGoMessage(ReadWrite readWrite) {
        this.readWrite = readWrite;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of("C:\\h.txt");
        String text;
        while (true) {
            System.out.println("Введите сообщение для отправки, /exit для выхода ");
            text = scanner.nextLine();
            if (text.equals("/exit")) {
                readWrite.close();
                break;
            }
            FileTxt fileTxt = new FileTxt();
            fileTxt.addFile("C:\\h.txt","хуйня");
            Message message = new Message(text);
            try {
             //   readWrite.readFile();
                readWrite.writeMessage(message);
                readWrite.writeFile(fileTxt);
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
