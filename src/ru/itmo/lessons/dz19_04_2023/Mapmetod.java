package ru.itmo.lessons.dz19_04_2023;

import java.util.*;

public interface Mapmetod extends Comparator<Task02> {

    public static List<String> login(HashMap<String, String> hashMap, String city) {
        if (hashMap != null && city != null) {
            ArrayList<String> arr = new ArrayList<>();
            for (Map.Entry<String, String> map : hashMap.entrySet()) {
                if (city.equals(map.getValue())) {
                    arr.add(map.getKey());
                }
            }
            return arr;
        }
        return null;
    }

    public static Map<String, Integer> coutnWord(List<String> word) {
        if (word != null) {
            HashMap<String, Integer> arrMap = new HashMap<>();
            for (var wor : word) {
                arrMap.put(wor, arrMap.getOrDefault(wor, 0) + 1);

            }
            return arrMap;
        }
        return null;
    }

    public static Map<String, Integer> countTextWord(String tex, String word) {
        if (tex != null) {
            HashMap<String, Integer> arrMap = new HashMap<>();
            String[] wordArr = tex.split(" ");
            for (var str : wordArr) {
                if (str.equals(word))
                    arrMap.put(word, arrMap.getOrDefault(word, 0) + 1);
            }
            return arrMap;
        }
        return null;
    }

    public static Map<Integer, List<String>> coutWordText(String text) {
        if (text != null) {
            HashMap<Integer, List<String>> arrMap = new HashMap<>();
            String[] wordArr = text.split(" ");
            for (var word : wordArr) {
                if (arrMap.containsKey(word.length())) {
                    arrMap.get(word.length()).add(word);
                } else {
                    ArrayList<String> strArr = new ArrayList<>();
                    strArr.add(word);
                    arrMap.put(word.length(), strArr);

                }
            }
            return arrMap;
        }
        return null;
    }

    public static Map<Integer, String> topWord(String text) {
        if (text != null) {

            HashMap<Integer, String> arrMap = new HashMap<>();
            String[] arrText = text.split(" ");
            for (int i = 0; i < 10; i++) {
                String max = arrText[0];
                for (var word : arrText) {
                    if (max.length() < word.length() && !arrMap.values().contains(word)) {
                        max = word;
                    }

                }
                arrMap.put(i + 1, max);

            }
            return arrMap;
        }
        return null;
    }

}
