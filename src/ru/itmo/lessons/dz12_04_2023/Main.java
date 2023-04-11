package ru.itmo.lessons.dz12_04_2023;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Main {
    public static void main(String[] args) throws AccessDeniedException, JarException, FileNotFoundException {
        Status a = Status.JAR_ERROR;
        try {
            Exceptionn.throwException(a);
        } catch (FileNotFoundException | JarException ex) {
            ex.printStackTrace();
        } catch (AccessDeniedException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

    }
}
