package ru.itmo.lessons.dz14_04_2023;

public class PairContainer<K, V> {
    private K key;
    private V value;

    public PairContainer(K KEY, V VALUE) {
        if (KEY != null && VALUE != null) {
            this.key = KEY;
            this.value = VALUE;
        } else throw new IllegalArgumentException("нулл");
    }

}
