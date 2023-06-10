package ru.itmo.lessons.exams.courserwork3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.CopyOnWriteArraySet;

public class EnterFile implements Commands{
    private CopyOnWriteArraySet<ReadWrite> arr;
    private ReadWrite clien;

    public EnterFile(CopyOnWriteArraySet<ReadWrite> arr, ReadWrite clien) {
        this.arr = arr;
        this.clien = clien;
    }

    @Override
    public void comandEnter() {
        try {

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
        }
    }
}
