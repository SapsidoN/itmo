package ru.itmo.lessons.exams.courserwork3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileTxt implements Serializable {
    private String nameFile;

    private String commentFile;

    private ArrayList<String> text;

    public FileTxt(){
        text= new ArrayList<>();
    }

    public void addFile(String put, String comment)  {
        Path path = Path.of(put);
        this.commentFile = "#" + comment + "#" ;
        this.nameFile=path.getFileName().toString();
        int ind=path.toString().indexOf(".");
        String n= path.toString().substring(ind,path.toString().length());
        BufferedReader bufferedReader = null;
        if(n.equals(".txt")){
            try {
                 bufferedReader = new BufferedReader(new FileReader(path.toFile()));

                String line = bufferedReader.readLine();
                while (line != null) {
                    text.add(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
            }catch (FileNotFoundException f){
                System.out.println("файл не найден");
            }catch (IOException io){
                System.out.println("Ошибка во время чтения файла");
            }finally {
                try {
                    bufferedReader.close();
                }catch (IOException e){
            }

            }
        }
        else {
            System.out.println("файл не подходит. Допускается только txt");
        }

    } public void loadingFile(){;
        File file = new File(nameFile);
        FileWriter fileWriter = null;
        try {
            boolean newFile = file.createNewFile();
            if(newFile) System.out.println("создан");
            else System.out.println("не создан");
            System.out.println(file.getName());
            System.out.println(commentFile);
            fileWriter = new FileWriter(file.getName());
            fileWriter.write(commentFile);
          //  for (int i = 0; i < text.size(); i++) {
            //    fileWriter.write(text.get(i));
            //}
        }catch (IOException i){
            i.printStackTrace();
        }finally {
            try {

                if(fileWriter != null)
                fileWriter.close();
            }catch (IOException e){
                e.printStackTrace();
        }
        }
    }

}
