package ru.itmo.lessons.exams.courserwork3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class EnterFile implements Commands {
    private ReadWrite clien;


    public EnterFile(ReadWrite clien) {
        this.clien = clien;
    }

    @Override
    public void comandEnter() {         // Отправка клиенту список файлов тхт
        try {

            Files.find(new File(".").toPath(), 1, (p, d) -> d.isRegularFile() && p.getFileName()
                    .toString().endsWith(".txt")).forEach(p -> {
                try {
                    clien.writeMessage(new Message(p.getFileName().toString()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException h) {
            h.printStackTrace();
        }
    }

}
