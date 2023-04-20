package ru.itmo.lessons.dz21_04_2023;


import ru.itmo.lessons.dz21_04_2023.bounded.Car;
import ru.itmo.lessons.dz21_04_2023.bounded.Repaintable;
import ru.itmo.lessons.dz21_04_2023.bounded.Vehicle;

import java.awt.*;
import java.util.*;
import java.util.List;

public class WildCardsTask {
    public static void main(String[] args) {


        // Ответить на вопросы:
        // 1. generic в java инвариантны. как достичь их ко- и контрвариантности?
        // все просто воспользоваться инструментом wildcards
        // 2. Чем метод sendRequest(List<? extends Resources> list) от метода sendRequest(List<Resources> list)
        // в том что мы не ограничены в передаче определенного листа((List<Resources> list), а можем передать и наследников Resources

        // Написать следующие static методы (для типов из пакета bounded):
        // 1 метод:
        // написать метод, в который можно передать список объектов любого типа, реализующего Repaintable интерфейс
        // (например, список машин или список велосипедов)
        // в методе всем объектам из списка должен устанавливаться Repaintable.Color.BLACK цвет

        // 2 метод:
        // написать метод, в который можно передать два аргумента:
        // 1 аргумент - map, где ключи - Repaintable.Color,
        // а значения - списки (List, ArrayList или LinkedList) объектов любого типа,
        // реализующего Repaintable интерфейс (например, список машин или список велосипедов)
        // 2 аргумент - цвет (Repaintable.Color color)
        // метод возвращает список объектов любого типа, реализующего Repaintable интерфейс
        // (например, список машин или список велосипедов) цвета color

        // 3 метод:
        // написать метод, принимающий на вход 3 аргумента:
        // 2 мапы, где ключи - номера транспортных средств, значения - транспортные средства (например машины или автобусы)
        // и уровень износа (wearLevel)
        // в методе переместить транспортные средства из первой map во вторую, если уровень износа транспортного средства больше wearLevel
    }
}
