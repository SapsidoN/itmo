package ru.itmo.lessons.exams.coursework2;

import java.io.Serializable;
import java.time.LocalDateTime;

class User implements Serializable {
    private String name;

    private String saveText = " ";

    private LocalDateTime localDateTime;

    public User(String name) {
        this.name = name;
    }


    public void setLocalDateTime() {
        this.localDateTime = LocalDateTime.now();
    }

    public void setSaveText(String saveText) {
        this.saveText = saveText;
    }

    public String getSaveText() {
        return saveText;
    }

    public String SaveS() {
        setLocalDateTime();
        return name + " " + localDateTime + "\n" + "глава ;" + saveText + "//";
    }

    public String getName() {
        return name;
    }
}