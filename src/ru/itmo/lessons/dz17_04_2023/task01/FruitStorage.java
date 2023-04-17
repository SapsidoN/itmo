package ru.itmo.lessons.dz17_04_2023.task01;

import ru.itmo.lessons.dz17_04_2023.task01.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitStorage {
    private int countAllFruct = 0;
    private ArrayList<Fruit> fruits; // коллекция для хранения фруктов (коллекцию выбрать самостоятельно)


    public FruitStorage() {
        fruits = new ArrayList<>(); // коллекция для хранения фруктов (коллекцию выбрать самостоятельно)
    }

    public void addFruit(Fruit newFruit) { // добавление фрукта newFruit в коллекцию fruits
        if (newFruit == null) return;
        for (Fruit fruit : fruits) {
            if (fruit == newFruit) return;
            if (fruit.equals(newFruit)) {
                fruit.setCount(fruit.getCount() + newFruit.getCount());
                countAllFruct += newFruit.getCount();
                return;
            }
        }
        fruits.add(newFruit);
        countAllFruct += newFruit.getCount();
    }

    public int getNumberOfFruitsByType(Fruit.FruitType fruitType) {
        if (fruits.size() == 0) return 0;
        int count = 0;
        for (var a : fruits) {
            if (a.getType() == fruitType) {
                count += a.getCount();
            }
        }

        // возвращает количество фруктов типа fruitType
        return count;
    }

    public int getNumberOfFruits() {
        // возвращает количество всех фруктов
        return countAllFruct;
    }

    public void increasePrice(int value) {
        if (value >= 10 && value <= 30 && this.fruits.size() != 0) {
            for (var frut : fruits) {
                frut.setPrice(frut.getPrice() + value);
            }
        }
        System.out.println("значение value не валидное или фруктов нет");
        // value может быть в диапазоне [10; 30)
        // увеличить цену фруктов на value процентов

    }

    public double getFruitsPrice() {
        double count = 0;
        for (var frut : fruits) {
            count += frut.getPrice();
        }
        // возвращает общую стоимость фруктов на складе
        return count;
    }

    public List<Fruit> getFruitsByTypeAndPrice(Fruit.FruitType fruitType, int maxPrice) {
        if (maxPrice > 0) {
            ArrayList<Fruit> arr = new ArrayList<>();
            for (var frut : fruits) {
                if (frut.getType() == fruitType && frut.getPrice() <= maxPrice) {
                    arr.add(frut);
                }
            }
            return arr;
        }
        // maxPrice должна быть положительной
        // возвращает список, в который войдут фрукты из коллекции fruits с типом fruitType и ценой не выше maxPrice
        return null;
    }
}
