package ru.itmo.lessons.exams.courserwork3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Clientt {
    public InetSocketAddress remote;



    public Clientt(InetSocketAddress remote) {
        this.remote = remote;
    }


    public void startClient() {
                try {
                    Socket socket = new Socket(remote.getHostString(), remote.getPort());
                    ReadWrite readWrite = new ReadWrite(socket);
                    ClientGoMessage clientGoMessage = new ClientGoMessage(readWrite);
                    clientGoMessage.start();
                    ClientRead clientRead = new ClientRead(readWrite);
                    clientRead.start();
                } catch (IOException e) {
                    System.out.println("не удалось подлючится к серверу ;(((((");

                }

    }

    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 2228);
        Clientt clientt = new Clientt(inetSocketAddress);
        clientt.startClient();
    }

}
