package ru.itmo.lessons.dz12_04_2023;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Exceptionn extends Exception {
    static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException {
        if (Status.FILE_NOT_FOUND == status) {
            throw new FileNotFoundException();
        } else if (Status.ACCESS_DENIED == status) {
            throw new AccessDeniedException("аккаунт удален");
        } else if (Status.JAR_ERROR == status) {
            throw new JarException();
        }
    }

}
