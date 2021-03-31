package base.task_4_2_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        fillList(scanner, taskList);
        printTasks(taskList);
        strictList(scanner, taskList);
        printTasks(taskList);
    }

    private static void fillList(Scanner scanner, ArrayList<Task> taskList) {
        while (true) {
            System.out.println("Введите название задачи\n(для вывода задач - print, для выхода - end)");
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            } else if (input.equals("print")) {
                printTasks(taskList);
                continue;
            }

            Task task = new Task(input);
            taskList.add(task);
        }
    }

    private static void strictList(Scanner scanner, ArrayList<Task> taskList) {
        while (true) {
            System.out.println("Введите индекс задачи для удаления\n(для вывода задач - print, для выхода - end)");
            String rawInput = scanner.nextLine();

            if (rawInput.equals("end")) {
                break;
            } else if (rawInput.equals("print")) {
                printTasks(taskList);
                continue;
            }

            int intInput;

            try {
                intInput = Integer.parseInt(rawInput);
            } catch (NumberFormatException e) {
                System.out.println("Требуется ввести число или команду, повторите попытку.");
                continue;
            }
            if (intInput < 0 || intInput >= taskList.size()) {
                System.out.println("Введённое число выходит за индекс, повторите попытку.");
                continue;
            }

            taskList.remove(intInput);
        }
    }

    private static void printTasks(ArrayList<Task> taskList) {
        int i = 0;
        for (Task task : taskList ) {
            System.out.printf("%d. %s\n", i, task.getName());
            i++;
        }
    }
}
