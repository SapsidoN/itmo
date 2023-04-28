package ru.itmo.lessons.exams.coursework1;


import java.util.*;

public class Fitness {

    private Calendar dateTime = new GregorianCalendar(2023, Calendar.APRIL, 29, 9, 2);
    private ArrayList<Subscription> arrGym;

    private ArrayList<Subscription> arrBasin;

    private ArrayList<Subscription> arrGroop;

    private HashMap<Integer, Subscription> arrMap;


    enum Zone {
        gym,
        basin,
        group;

        public boolean proverkaZone(Subscription subscription) {
            if (this != null) {
                if (subscription.getSubscriptionType() == Subscription.SubscriptionType.One_time) {
                    return this == Zone.group ? false : true;
                } else if (subscription.getSubscriptionType() == Subscription.SubscriptionType.Day) {
                    return this == Zone.basin ? false : true;
                } else return true;
            }
            throw new IllegalArgumentException("зана нулл");
        }
    }

    public Fitness() {
        arrGym = new ArrayList<>(20);
        arrBasin = new ArrayList<>(20);
        arrGroop = new ArrayList<>(20);
        arrMap = new HashMap<>();
    }

    public void arrMapAdd(Subscription subscription) {
        if (subscription != null) {
            if (!arrMap.containsKey(subscription.getNumber())) arrMap.put(subscription.getNumber(), subscription);
            else System.out.println("Такой абонимент уже есть");
        } else System.out.println("Ошибка данных!!!");

    }


    private boolean proverka(Subscription subscription) {
        if (subscription != null) {
            if (subscription.getEndDate().before(dateTime)) throw new IllegalArgumentException("просрочен абонемент");
            if (subscription.getSubscriptionType() == Subscription.SubscriptionType.Day) {
                if (dateTime.get(Calendar.HOUR_OF_DAY) >= 8 && dateTime.get(Calendar.HOUR_OF_DAY) <= 16) {
                    return true;
                }
            } else if (dateTime.get(Calendar.HOUR_OF_DAY) >= 8 && (dateTime.get(Calendar.HOUR_OF_DAY) <= 22)) {
                return true;
            } else throw new IllegalArgumentException("закрыт финтес");
        } else throw new IllegalArgumentException("абонемент нулл");
        return false;
    }

    public void registrZone(Subscription sub, Zone zone) {
        if (zone.proverkaZone(sub)) {
            if (proverka(sub)) {
                switch (zone) {
                    case gym:
                        if (arrGym.size() <= 20) {
                            arrGym.add(sub);
                            break;
                        }
                        throw new IllegalArgumentException("мест нет");
                    case basin:
                        if (arrBasin.size() <= 20) {
                            arrBasin.add(sub);
                            break;
                        }
                        throw new IllegalArgumentException("мест нет");
                    case group:
                        if (arrGroop.size() <= 20) {
                            arrGroop.add(sub);
                            break;
                        }
                        throw new IllegalArgumentException("мест нет");

                }
                System.out.println("В зону " + zone.toString() + " зарегистрировался " + sub.getHuman());
            }
        }
        System.out.println(sub.getHuman().toString() + " запрещен доступ к " + zone.toString());

    }

    public void printInfo() {
        System.out.println("Посетители тенажерного зала:");
        for (var print : arrGym) {
            System.out.println(print.getHuman().toString());
        }
        System.out.println("Посетители бассейна:");
        for (var print : arrGym) {
            System.out.println(print.getHuman().toString());
        }
        System.out.println("Посетители групповых занятий:");
        for (var print : arrGym) {
            System.out.println(print.getHuman().toString());
        }
    }

}
