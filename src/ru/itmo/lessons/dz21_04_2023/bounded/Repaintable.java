package ru.itmo.lessons.dz21_04_2023.bounded;

public interface Repaintable {
    void changeColor(Color newColor);

    enum Color{
        RED("красный"), ORANGE("оранжевый"), BLACK("чёрный"), BLUE("синий");
        private final String name;

        Color(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
