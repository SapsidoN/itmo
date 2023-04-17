package ru.itmo.lessons.dz17_04_2023.task02;

import java.util.*;

public class Task02 {
    public static void countEachPriority(List<Message> messageList) {
        int countLow = 0, countMedium = 0, countHigh = 0, coutnUrgen = 0;
        if (messageList != null) {
            for (var mess : messageList) {
                if (mess.getPriority().equals(Message.MessagePriority.HIGH)) countHigh++;
                else if (mess.getPriority().equals(Message.MessagePriority.URGENT)) coutnUrgen++;
                else if (mess.getPriority().equals(Message.MessagePriority.MEDIUM)) countMedium++;
                else if (mess.getPriority().equals(Message.MessagePriority.LOW)) countLow++;
            }
            System.out.println("LOW: " + countLow + " MWDIUM: " + countMedium + " HIDE: " + countHigh + " URHENT: " + coutnUrgen);
        } else System.out.println("Вы передали нулл");
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
    }

    public static void countEachCode(List<Message> messageList) {
        if (messageList != null && messageList.size() != 0) {
            ArrayList<Integer> arr1 = new ArrayList<>();
            int coutn = 0;
            int size = -1;
            for (int i = 0; i < messageList.size(); i++) {
                coutn = 0;
                if (arr1.contains(messageList.get(i).getCode())) continue;
                arr1.add(messageList.get(i).getCode());
                size++;
                for (int j = 0; j < messageList.size(); j++) {
                    if (arr1.get(size) == messageList.get(j).getCode()) {
                        coutn++;
                    }
                }
                System.out.println("количество сообщений код: " + arr1.get(size) + " встречаеться: " + coutn);
            }
        } else  System.out.println("вы передали нулл или ноль сообщений");
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        Stack<Message> arr = new Stack<>();
        for (int j = 0; j < messageList.size(); j++) {
            arr.push(messageList.get(j));
            for (int i = 1; i < messageList.size(); i++) {
                if (arr.peek().equals(messageList.get(i)) && i != j) {
                    arr.pop();
                    break;
                }
            }
        }
        System.out.println("колличество уникальных сообщений: " + arr.size());

        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        HashSet<Message> arr= new HashSet<>(messageList);
           List<Message> arr1=new ArrayList<>(arr);




        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        return arr1;
    }

    public static void removeEach(List<Message> messageList, Message.MessagePriority priority) {
        System.out.println(messageList.toString());
        Iterator<Message> a= messageList.listIterator();
        while (a.hasNext()){
            Message mes=a.next();
            if(mes.getPriority()==priority){
                a.remove();
            }
        }
        System.out.println(messageList.toString());
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
    }

    public static void removeOther(List<Message> messageList, Message.MessagePriority priority) {
        System.out.println(messageList.toString());
        Iterator<Message> a= messageList.listIterator();
        while (a.hasNext()){
            Message mes=a.next();
            if(mes.getPriority()==priority){
                continue;
            } else a.remove();
        }
        System.out.println(messageList.toString());
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
    }

    public static void main(String[] args) {
        List<Message> messages = Message.generate(34);
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        removeEach(messages, Message.MessagePriority.HIGH);
        removeOther(messages, Message.MessagePriority.LOW);
    }
}
