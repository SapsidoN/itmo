package ru.itmo.lessons.dz_24_05_2023;

import ru.itmo.lessons.exams.coursework2.Start;
import ru.itmo.lessons.yrok17_05_2023.ReadWrite;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;

public class Clientt {
    public InetSocketAddress remote;

    private ReadWrite readWrite;

    public Clientt(InetSocketAddress remote) {
        this.remote = remote;
    }


    public void startClient() {
        String text;

            try {
                Socket socket = new Socket(remote.getHostString(), remote.getPort());
                readWrite = new ReadWrite(socket);
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите сообщение для отправки, /exit для выхода ");
                    text = scanner.nextLine();

                    if (text.equals("/exit")) {
                        socket.close();
                        break;
                    }
                    ClientGoMessage clientGoMessage = new ClientGoMessage(text, readWrite);
                    clientGoMessage.start();

                    ClientRead clientRead = new ClientRead(readWrite);
                    clientRead.start();
                    clientRead.join();
                }

            } catch (IOException e) {
                System.out.println("не удалось подлючится к серверу ;(((((");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


    }

    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 2231);
        Clientt clientt = new Clientt(inetSocketAddress);
        clientt.startClient();
    }

}
