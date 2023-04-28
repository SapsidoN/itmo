package ru.itmo.lessons.dz28_04_2023;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//принимаемый аргумет берется из контекста
public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: Используя методы Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        Map<Student.Gender, ArrayList<Student>> map = students.stream().collect(Collectors.groupingBy(
                student -> student.getGender(),
                Collectors.toCollection(ArrayList::new)


        ));
//  2. Найти средний возраст учеников
        Double map3 = students.stream().collect(Collectors.averagingInt(value -> LocalDate.now().getYear() - value.getBirth().getYear()));
        System.out.println(map3);


        //  3. Найти самого младшего ученика
        Student student = students.stream()
                .min((s1,s2)-> s2.getBirth().compareTo(s1.getBirth()))
                .get();

        System.out.println(student.toString());
        //  4. Найти самого старшего ученика
        Student student2 = students.stream()
                .min(Comparator.comparing(Student::getBirth))
                .get();
        System.out.println(student2.toString());
        //  5. Собрать учеников в группы по году рождения
        Map<Integer, List<Student>> mapStud = students.stream().collect(Collectors.groupingBy(student1 -> student1.getBirth().getYear()));
        System.out.println(mapStud.toString());

        //  6. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (ArrayList)
        ArrayList<Student> arrayList = students.stream()
                .sorted(Comparator.comparing(Student::getGender))
                .sorted(Comparator.comparing(Student::getBirth))
                .sorted(Comparator.comparing(Student::getName).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList.toString());

        //  7. Вывести в консоль всех учеников в возрасте от N до M лет
        Scanner scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();
        students.stream().filter(student1 -> {
            if (LocalDate.now().getYear() - student1.getBirth().getYear() >= a &&
                    LocalDate.now().getYear() - student1.getBirth().getYear() <= b) return true;
            else return false;

        }).forEach(student1 -> System.out.println(student1.toString()));

        //  8. Собрать в список всех учеников с именем=someName
        scanner.nextLine();
        String name = scanner.nextLine();
        List<Student> studentArrayList = students.stream().filter(student1 -> student1.getName().equals("Женя")).toList();
        System.out.println(studentArrayList.toString());
        //  9. Собрать Map<Student.Gender, Integer>, где Student.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Student.Gender, Integer> genderIntegerMap = students.stream().collect(Collectors.toMap(student1 -> student1.getGender(),
                student1 -> LocalDate.now().getYear() - student1.getBirth().getYear(),
                (value1, value2) -> value1 + value2));

        System.out.println(genderIntegerMap.toString());

        //     см. метод Collectors.summingIn

    }
}
