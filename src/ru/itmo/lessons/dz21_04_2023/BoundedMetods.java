package ru.itmo.lessons.dz21_04_2023;

import ru.itmo.lessons.dz21_04_2023.bounded.Car;
import ru.itmo.lessons.dz21_04_2023.bounded.Repaintable;
import ru.itmo.lessons.dz21_04_2023.bounded.Vehicle;

import java.util.List;
import java.util.Map;

public interface BoundedMetods {

    public static void allBlack(List<? extends Repaintable> arr) {
        for (Repaintable a : arr) {
            a.changeColor(Repaintable.Color.BLACK);
        }
    }

    public static List<? extends Repaintable> arrColor(Map<Repaintable.Color, List<? extends Repaintable>> map, Repaintable.Color color) {
        if (map.containsKey(color)) {
            List<? extends Repaintable> arr = map.get(color);
            return arr;
        } else return null;
    }

    public static Map<String, ? super Vehicle> wear(Map<String, ? extends Vehicle> map1, Map<String, ? super Vehicle> map2, int wearLevel) {
        for (Map.Entry<String, ? extends Vehicle> mapArr : map1.entrySet()) {
            if (mapArr.getValue().getWearLevel() > wearLevel) {
                map2.put(mapArr.getKey(), mapArr.getValue());
            }
        }
        return map2;

    }

}
