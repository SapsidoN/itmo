package ru.itmo.lessons.exams.coursework1;

import java.time.*;
import java.util.*;

public class Fitness {

    private Calendar dateTime = Calendar.getInstance();
    private ArrayList<Subscription> arrGym;

    private ArrayList<Subscription> arrBasin;

    private ArrayList<Subscription> arrGroop;

    private HashMap<Integer, Subscription> arrMap;


    enum Zone {
        gym,
        basin,
        group;
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
        if (zone != null) {
            if (proverka(sub)) {
                switch (zone) {
                    case gym:
                        if (arrGym.size() != 20) {
                            arrGym.add(sub);
                            break;
                        }
                    case basin:
                        if (arrBasin.size() != 20) {
                            arrBasin.add(sub);
                            break;
                        }
                    case group:
                        if (arrGroop.size() != 20) {
                            arrGroop.add(sub);
                            break;
                        }

                    default:
                        throw new IllegalArgumentException("мест нет");

                }
            }
        }

    }
    public  Calendar getCalendar(){
        return dateTime;
    }

}
