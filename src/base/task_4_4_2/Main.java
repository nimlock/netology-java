package base.task_4_4_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Student> set = new HashSet<>();

        while (true) {
            System.out.println("Введите информацию о студенте: \"ФИО, номер группы, номер студенческого билета\",\n" +
                               "в качестве разделителя используйте запятую; для выхода введите \"end\"");
            String rawInput = scanner.nextLine();

            if (rawInput.equals("end")) {
                break;
            }

            String[] arrayInput = rawInput.split(",");
            if (arrayInput.length != 3) {
                System.out.println("Ошибка! Введенная строка не соответствует формату, повторите ввод.\n");
                continue;
            }

            String name = arrayInput[0].trim();
            String group = arrayInput[1].trim();
            String studentId = arrayInput[2].trim();

            Student student = new Student(name, group, studentId);

            if (!set.add(student)) {
                System.out.println("Ошибка! Нельзя добавить двух студентов с одинаковым номером студенческого.");
            }
        }

        System.out.println("Список студентов:");
        for (Student student : set) {
            System.out.printf("  - %s, %s, %s\n",
                    student.getName(),
                    student.getGroup(),
                    student.getStudentId());
        }
    }
}
