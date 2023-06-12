package ru.itmo.lessons.exams.courserwork3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class ThreadForConnection extends Thread {
    private CopyOnWriteArraySet<ReadWrite> arr;
    private ReadWrite clien;

    private HashMap<String, Commands> commandsArr = new HashMap<>();

    public ThreadForConnection(ReadWrite clien, CopyOnWriteArraySet<ReadWrite> arr) {
        this.arr = arr;
        this.clien = clien;
        this.commandsArr.put("/Файлы", new EnterFile(clien));
        this.commandsArr.put("/Загрузить", new FileEnterUser(clien));
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread thread = new Thread(()->{ //Отдельный поток для приема файлов
                    FileTxt fileTxt = null;
                    try {
                        fileTxt = clien.readFiletxt();
                    } catch (IOException e) {
                        arr.remove(clien);
                    }
                    messageForwarding(new Message(fileTxt.loadingFile()));
                });
                Message message = clien.readMessage();
                if (message == null) {
                    arr.remove(clien);
                    break;
                }
                messageForwarding(message);
            }
        } catch (IOException e) {
            System.out.println("ошибка");


        }
    }

    public void messageForwarding(Message message) {   //Метод для отправки сообшений всем пользователям

        arr.stream().forEach(readWrite -> {
            try {
                readWrite.writeMessage(message);
            } catch (IOException e) {
                System.out.println("Клиент отвалился");
                arr.remove(readWrite);
            }
            if (message.getText().startsWith("/")) {
                startComand(message);
            }
        });
    }

    public void addComands(Commands commands, String key) { // Для добовления функционала(команд)
        commandsArr.put(key, commands);
    }

    public void startComand(Message message) {  // Старт выполнения команд
        if (message == null || !commandsArr.containsKey(message.getText())) {
            try {
                clien.writeMessage(new Message("Данной команды нет"));
            } catch (IOException e) {
                System.out.println("Соединение с клиентом отвалилось");
                arr.remove(clien);
            }
        } else {
            commandsArr.get(message.getText()).comandEnter();
        }
    }


}
