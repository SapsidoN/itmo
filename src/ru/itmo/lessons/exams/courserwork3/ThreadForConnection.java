package ru.itmo.lessons.exams.courserwork3;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadForConnection extends Thread {
    private CopyOnWriteArraySet<ReadWrite> arr;
    private ReadWrite clien;

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
                }
            }
        } catch (IOException e) {
            System.out.println("ошибка");


        }
    }

}
