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

    private HashMap<String,Commands> commandsArr;

    public ThreadForConnection(ReadWrite clien, CopyOnWriteArraySet<ReadWrite> arr) {
        this.arr = arr;
        this.clien = clien;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = clien.readMessage();
                FileTxt fileTxt = clien.readFiletxt();
                if (fileTxt != null) {
                    fileTxt.loadingFile();
                    for (var a : arr) {
                        a.writeMessage(new Message("загружен файл"));
                    }
                } else System.out.println("нулл файл");
                if (message == null) {
                    arr.remove(clien);
                    break;
                }
                for (var a : arr) {
                    try {
                        a.writeMessage(message);
                        System.out.println(arr.size());
                    } catch (IOException e) {
                        arr.remove(a);
                    }

                    if (message.getText().equals("Файлы")) {
                      /*  try {

                            Files.find(new File(".").toPath(), 1, (p, d) -> d.isRegularFile() && p.getFileName()
                                    .toString().endsWith(".txt")).forEach(p -> {
                                for (var b : arr) {
                                    try {
                                        b.writeMessage(new Message(p.getFileName().toString()));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        }catch (IOException h){
                            h.printStackTrace();
                        }*/
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("ошибка");


        }
    }
    public void addComands(Commands commands,String key){
        commandsArr.put(key,commands);
    }

    public void startComand(Message message){
        if(message == null || !commandsArr.containsKey(message.getText())){
            System.out.println("Данной команды нет");
        }else {
            commandsArr.get(message.getText()).comandEnter();
        }
    }



}
