package ru.itmo.lessons.dz14_04_2023;

import ru.itmo.lessons.yrok12_04_2023.properties.User;

public class Main {
    public static void main(String[] args) {
        PairContainer<Number, String> pain = new PairContainer<>(10, "f");
        PairContainer<String, User<Number>> pain2 = new PairContainer<>("S", new User<>());
        PairContainer<String, PairContainer<Number, User<String>>> pain3 = new PairContainer<>("d", new PairContainer<>(3, new User<>()));
    }
}



