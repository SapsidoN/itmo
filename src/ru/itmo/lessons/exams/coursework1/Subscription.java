package ru.itmo.lessons.exams.coursework1;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Subscription {

    private Calendar registrationDate = Calendar.getInstance();

    private Calendar endDate = Calendar.getInstance();

    private int number;

    private Human human;

    private SubscriptionType subscriptionType;

    private Subscription(Human human, String end, String registrationDate, SubscriptionType subscriptionType) throws ParseException {
        if (human != null && subscriptionType != null) {
            this.human = human;
            setDate(end, registrationDate);
            setNumber();
            this.subscriptionType = subscriptionType;
        } else throw new RuntimeException("ошибка данных");
    }


    enum SubscriptionType {
        One_time("Разовый"),
        Day("Дневной"),
        Full("Полный");

        private String type;
        Time date;

        private SubscriptionType(String type) {
            this.type = type;

        }

    }


    public static Subscription createSub(Human human, String end, String registrationDate, SubscriptionType subscriptionType) throws ParseException {
        if (subscriptionType.equals(SubscriptionType.One_time)) {
            return new Subscription(human, registrationDate, registrationDate, subscriptionType);
        } else return new Subscription(human, end, registrationDate, subscriptionType);
    }

    private void setDate(String dateEnd, String dateR) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        registrationDate.setTime(sdf.parse(dateR));
        endDate.setTime(sdf.parse(dateEnd));
    }

    private void setNumber() {
        number = (int) Math.pow(10, 6) + (int) Math.random() * (int) Math.pow(10, 7);
    }

    public int getNumber() {
        return number;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Human getHuman() {
        return human;
    }


}

