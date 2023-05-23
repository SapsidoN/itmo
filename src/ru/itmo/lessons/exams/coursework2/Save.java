package ru.itmo.lessons.exams.coursework2;

import java.io.*;

public class Save implements Command {

    @Override
    public void on(User user) {
        try (FileWriter fileWriter = new FileWriter("SaveS.txt", true);) {
            fileWriter.write(user.SaveS());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
