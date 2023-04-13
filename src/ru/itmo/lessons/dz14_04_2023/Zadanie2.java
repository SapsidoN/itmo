package ru.itmo.lessons.dz14_04_2023;

import java.io.Serializable;

public class Zadanie2 {
}

interface Eatable extends Serializable {
}

interface Runnable {
}

class Animal implements Runnable {
}

class Cat extends Animal implements Eatable {
}

class Kitten extends Cat {
}

class Dog extends Animal implements Serializable {
}


class Task {
    public static <T extends Cat & Eatable> void void01(T object) {
        // ВОПРОС: методы каких типов можно вызвать у object ???
        // Object, Animal, Cat


    }

    public static <T extends Animal & Serializable> void void02(T object) {
        // ВОПРОС: методы каких типов можно вызвать у object ???
        // Object, Animal

    }

    public static <T extends Serializable & Runnable> void void03(T object) {
        // ВОПРОС: методы каких типов можно вызвать у object ???
        // Object, ну и если будут дефолтные методы интерфейса

    }

    public static void main(String[] args) {
        Task.</* Cat и детей  */>void01(/*Cat и детей */);
        Task.</* Dog  */>void02(/* Dog   */);
        Task.<Dog>void03(/* Dog и если были дети  */);
    }