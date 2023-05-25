package ru.itmo.lessons.dz_24_05_2023;

import ru.itmo.lessons.yrok17_05_2023.Message;
import ru.itmo.lessons.yrok17_05_2023.ReadWrite;

import java.io.IOException;

public class ClientRead  extends  Thread{
    private ReadWrite readWrite;


    public ClientRead(ReadWrite readWrite){
        this.readWrite=readWrite;
    }

    @Override
    public  void run(){
        try {
            Message message = readWrite.readMessage();
            System.out.println(message.getText());
        } catch (IOException e) {
            System.out.println("Соеденение сервером потеряно");
        }
    }
}
