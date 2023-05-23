package ru.itmo.lessons.exams.coursework2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Users implements Serializable {

    ArrayList<User> arrayList;

    public Users() {
        arrayList = loudingUsers();
        if (arrayList == null) arrayList = new ArrayList<>();
    }

    public void creatUsers(User user) {
        boolean flag = arrayList.stream().anyMatch(a -> a.getName().equals(user.getName()));
        if (flag == true) {
            System.out.println("Такой юзер уже есть повторите попытку");
        } else arrayList.add(user);
        saveUserFile();
    }

    private void saveUserFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("USERS");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(arrayList);
        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    public ArrayList<User> loudingUsers() {
        File file = new File("USERS");
        try {
            file.createNewFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        ArrayList<User> arr = null;
        try (FileInputStream fileInputStream = new FileInputStream("USERS");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            arr = (ArrayList<User>) objectInputStream.readObject();
            return arr;

        } catch (IOException | ClassNotFoundException FI) {
            System.out.println("Что то с  файлом или нет типа класса");
            FI.printStackTrace();
        }
        return null;
    }

    public User enterUsers() {
        if (arrayList.size() == 0) {
            String name;
            System.out.println("Пользователей нет,Введите имя для создания");
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            User user = new User(name);
            creatUsers(user);
            return user;
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i + 1 + " " + arrayList.get(i).getName());
        }
        System.out.println("Выберите пользователя(цифра)");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        return arrayList.get(a - 1);
    }


}


