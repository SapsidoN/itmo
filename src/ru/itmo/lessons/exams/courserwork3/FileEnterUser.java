package ru.itmo.lessons.exams.courserwork3;

import java.io.IOException;


public class FileEnterUser implements Commands {
    private ReadWrite clien;


    public FileEnterUser(ReadWrite clien) {
        this.clien = clien;
    }

    @Override
    public void comandEnter() {
        try {

            clien.writeMessage(new Message("Ввидите название файла"));
            Message message = (Message) clien.readMessage();
            FileTxt fileTxt = new FileTxt();
            fileTxt.addFile(message.getText(), "");
            clien.writeMessage(new Message(fileTxt.getText().toString()));
        } catch (IOException e) {
            System.out.println("Клиент отвалился");
        }


    }

}

