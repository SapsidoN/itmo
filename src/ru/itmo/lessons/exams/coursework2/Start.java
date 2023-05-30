package ru.itmo.lessons.exams.coursework2;

public class Start implements Command {

    public  void starGame(TextQuest textQuest, User user){
        on(user);
        textQuest.logigGame(user.getSaveText(),user);
    }

    @Override
    public void on(User user) {
        System.out.println("Начало игры");// не понимаю зачем нужен отдельный класс при таких условиях
    }
}
