package ru.itmo.lessons.dz05_04_2023;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class AppFileWriter extends AppLogger {


    @Override
    public void log(String str) {
        try {
            Files.write(Paths.get("file-name.txt"), str.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

}