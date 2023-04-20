package ru.itmo.lessons.dz21_04_2023.bounded;

public class Car extends Vehicle implements Repaintable{
    private Color color;
    public Car(Color color, String number) {
        super(number);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

@Override
 public String toString(){
    return color + " " + number;
}
    @Override
    public void changeColor(Color newColor) {
        color = newColor;
        System.out.println("Машина №" + number + " перекрашена в " + newColor.getName());
    }
}