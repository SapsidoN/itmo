package ru.itmo.lessons.exams.courserwork3;

import java.io.IOException;

public class ClientRead  extends  Thread{
    private ReadWrite readWrite;


    public ClientRead(ReadWrite readWrite){
        this.readWrite=readWrite;
    }

    @Override
    public  void run(){
        while (true) {
            try {
                Message message = (Message) readWrite.readMessage();
                System.out.println("Сообщение от сервера " + message.getText());
            } catch (IOException e) {
                System.out.println("Соеденение сервером потеряно");
                break;
            }
        }
    }
}
