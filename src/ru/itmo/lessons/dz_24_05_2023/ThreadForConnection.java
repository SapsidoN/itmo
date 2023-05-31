package ru.itmo.lessons.dz_24_05_2023;

import ru.itmo.lessons.yrok17_05_2023.Message;
import ru.itmo.lessons.yrok17_05_2023.ReadWrite;

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
                    for (var a : arr) {
                        a.writeMessage(message);
                        if (a == null) arr.remove(a);
                    }
                }
                }catch(IOException e){
                System.out.println("Клиент отключен ");
                arr.remove(clien);
            }

    }

}
