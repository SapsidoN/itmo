package ru.itmo.lessons.exams.courserwork3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArraySet;

public class ServerWithThreads {
    private int port;
    private CopyOnWriteArraySet<ReadWrite> connections;

    public ServerWithThreads(int port) {
        this.port = port;
        connections = new CopyOnWriteArraySet<>();
    }

    public void startServer(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true) {
                Socket socket = null;
                try {
                    System.out.println("Ожидание подключения ");
                    socket = serverSocket.accept();
                    ReadWrite connection = new ReadWrite(socket);
                    connections.add(connection);
                    System.out.println("Клиент добавлен в коллекцию");
                    ThreadForConnection thread = new ThreadForConnection(connection, connections);
                    thread.start();
                } catch (IOException e) {
                    System.out.println("Не удалось установить соединение с клиентом");
                    if (socket != null) socket.close();
                }
            }

        } catch (IOException e) {
            System.out.println("порт занят");
        }
    }

    public static void main(String[] args) {
        ServerWithThreads serverWithThreads = new ServerWithThreads(2226);
        serverWithThreads.startServer();
    }
}