package ru.itmo.lessons.dz_24_05_2023;

import ru.itmo.lessons.yrok17_05_2023.Message;
import ru.itmo.lessons.yrok17_05_2023.ReadWrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class ClientGoMessage extends Thread {
    public String text;
    public  ReadWrite readWrite;


    public ClientGoMessage(String text, ReadWrite readWrite){
        this.text=text;
        this.readWrite= readWrite;
    }
    @Override
    public void run(){
        Message message = new Message(text);
        try {
            readWrite.writeMessage(message);
        } catch (IOException e) {
            System.out.println("Соеденение с сервером потеряно");
            try {
                File file = new File("message.txt");
                FileWriter fileWriter = new FileWriter(file);
                Files.createFile(file.toPath());
                fileWriter.write(text);
            } catch (IOException i) {
                i.printStackTrace();

            }
        }
    }
}
