package ru.itmo.lessons.exams.coursework2;

public class Start implements Command {

    @Override
    public void on(User user) {
        System.out.println("Начало игры");// не понимаю зачем нужен отдельный класс при таких условиях
    }
}
