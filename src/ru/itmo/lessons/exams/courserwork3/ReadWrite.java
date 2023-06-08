package ru.itmo.lessons.exams.courserwork3;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

public class ReadWrite implements AutoCloseable{
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private  OutputStream  outputStream;
    private  InputStream inputStream;
    private FileInputStream fis = null;
    private BufferedInputStream bis = null;
    private OutputStream os = null;
    private FileOutputStream fos = null;
    private BufferedOutputStream bos = null;
    private InputStream is = null;

    public ReadWrite(Socket socket) throws IOException {
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        this.socket = socket;
    }

    public void writeFile(FileTxt fileTxt) throws IOException{
      output.writeObject(fileTxt);
      output.flush();

    }

    public FileTxt readFiletxt() throws IOException {
        try {
            return  (FileTxt) input.readObject();
        }catch (ClassNotFoundException c){
            System.out.println("класс не найден");
        }
        return null;
    }

    public void readFile() throws IOException {
        int bytesRead;
        int current = 0;
        fos = null;
        bos = null;
        byte[] bytes = new byte[1024];
        is = socket.getInputStream();
        fos = new FileOutputStream("POP.txt");
        bos = new BufferedOutputStream(fos);
        bytesRead = is.read(bytes,0,bytes.length);
        current = bytesRead;
          do{
              bytesRead = is.read(bytes,current,(bytes.length));
              if(bytesRead >= 0) current += bytesRead;
          }while (bytesRead > -1);
          bos.write(bytes,0,current);
          bos.flush();
        System.out.println("File " + "POP.txt"
                + " downloaded (" + current + " bytes read)");
    }

    public Message readMessage() throws IOException /*, ClassNotFoundException*/ {
        try {
            return (Message) input.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Класс Message не найден");
        }
        return null;
    }
    public void writeMessage(Message message) throws IOException {
        message.setSent(LocalDateTime.now());
        output.writeObject(message);
        output.flush();
    }

    @Override
    public void close()  {
        try {
            input.close();
            output.close();
            socket.close();
            if(os!=null) {
                bis.close();
                fis.close();
            }
            if(is != null){
                is.close();
                fos.close();
                bos.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка закрытия ресурсов. " +
                    "Например, обрыв соединения произошел по время закрытия");
        }
    }
}