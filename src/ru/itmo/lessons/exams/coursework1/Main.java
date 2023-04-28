package ru.itmo.lessons.exams.coursework1;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            Human h1 = new Human("oleg", "кудрин", "13-05-1999");
            Subscription a1 = Subscription.createSub(h1, "28-06-2023", "27-03-2023", Subscription.SubscriptionType.One_time);

            Fitness fitness = new Fitness();
            fitness.registrZone(a1, Fitness.Zone.basin);
            fitness.printInfo();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
