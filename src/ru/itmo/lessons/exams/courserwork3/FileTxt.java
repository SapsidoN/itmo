package ru.itmo.lessons.exams.courserwork3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileTxt implements Serializable {
    private String nameFile;

    private String commentFile;

    private ArrayList<String> text;
    private static int length = 5;

    private static int size = 300;

    public FileTxt() {
        text = new ArrayList<>();
    }

    public ArrayList<String> getText() {
        return text;
    }


    public void addFile(String put, String comment) {    // найти и обернуть файл в обертку
        Path path = Path.of(put);
        this.commentFile = "#" + comment + "#";
        this.nameFile = path.getFileName().toString();
        int ind = path.toString().indexOf(".");
        String n = path.toString().substring(ind, path.toString().length());
        BufferedReader bufferedReader = null;
        if (n.equals(".txt") && size >= path.toFile().length() / (1024 * 1024) && length > path.toFile().length()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(path.toFile()));

                String line = bufferedReader.readLine();
                while (line != null) {
                    text.add(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
            } catch (FileNotFoundException f) {
                System.out.println("файл не найден");
            } catch (IOException io) {
                System.out.println("Ошибка во время чтения файла");
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }

            }
        } else {
            System.out.println("файл не подходит. Допускается только txt, или слишком большой ");
        }

    }

    public String loadingFile() {     // Создать физически файл которой пришел с клиента
        String status = null;
        File file = new File(nameFile);
        FileWriter fileWriter = null;
        try {
            file.createNewFile();
            status = "Файл создан " + " \n " + commentFile;
            System.out.println(file.getName());
            System.out.println(commentFile);
            fileWriter = new FileWriter(file.getName());
            fileWriter.write(commentFile);
            for (String s : text) {
                fileWriter.write(s);
            }
            return status;
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            try {

                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

}
