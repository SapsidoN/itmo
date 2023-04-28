package ru.itmo.lessons.exams.coursework1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class Human {
    private String name;
    private String surname;

    private Date birthday;

    public Human(String name, String surname, String birthday) throws ParseException {
        setName(name);
        setSurname(surname);
        setDate(birthday);
    }

    private void setName(String name) {
        if (name != null) {
            this.name = name;
        }
        else throw new IllegalArgumentException("нулл имя");
    }

    private void setSurname(String surname) {
        if (surname != null) {
            this.surname = surname;
        }
         else throw new IllegalArgumentException("нулл имя");
    }

    private void setDate(String date) throws ParseException {
        if (date != null) {
            Locale rus = new Locale("ru", "RU");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", rus);
            birthday = formatter.parse(date);
        }
         else  throw new IllegalArgumentException("нулл имя");
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }

}
