package ru.itmo.lessons.yrok27_03_2027.dz29_03_2023.Task2;

public class Product {
    private String name;
    private double Squirrels;
    private double Fats;
    private double Carbohydrates;
    private double Calories;

    public Product(String name, double Squirrels) {
        if (name != null && Squirrels >= 0) {
            this.name = name;
            this.Squirrels = Squirrels;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public Product(String name, double Squirrels, double Fats) {
        if (name != null && Squirrels >= 0 && Fats >= 0) {
            this.name = name;
            this.Squirrels = Squirrels;
            this.Fats = Fats;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public Product(String name, double Squirrels, double Fast, double Carbohydrates) {
        if (name != null && Squirrels >= 0 && Fast >= 0 && Carbohydrates >= Carbohydrates) {
            this.name = name;
            this.Squirrels = Squirrels;
            this.Fats = Fast;
            this.Carbohydrates = Carbohydrates;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public Product(String name, double Squirrels, double Fats, double Carbohydrates, double Calories) {
        if (name != null && Squirrels >= 0 && Fats >= 0 && Carbohydrates >= 0 && Calories >= 0) {
            this.name = name;
            this.Squirrels = Squirrels;
            this.Fats = Fats;
            this.Carbohydrates = Carbohydrates;
            this.Calories = Calories;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public double getSquirrels() {
        return Squirrels;
    }

    public double getFats() {
        return Fats;
    }

    public double getCarbohydrates() {
        return Carbohydrates;
    }

    public double getCalories() {
        return Calories;
    }

    public void print() {
        System.out.println(name + " " + Squirrels + " " + Fats + " " + Carbohydrates + " " + Calories);
    }

}
