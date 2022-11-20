package base.task_4_3_1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        int maxLevel = 25;

        // Заполняем очередь вводимыми номерами этажей 1-25. Завершение - 0.
        liftTravel(queue, maxLevel);

        // Вывод отчёта о движении лифта: перечисление этажей + суммарно затраченное время
        liftReport(queue);
    }

    private static void liftTravel(Deque<Integer> queue, int maxLevel) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int input;

            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Требуется ввести число, повторите попытку.");
                continue;
            }

            if (input > maxLevel || input < 0) {
                System.out.println("Такого этажа нет в доме");
            } else if (input == 0) {
                break;
            } else {
                queue.offerFirst(input);
            }
        }
    }

    private static void liftReport(Deque<Integer> queue) {
        int waitMoveInSeconds = 5;
        int waitDoorsInSeconds = 10;
        int totalSeconds = 0;
        int currentLevel;
        int nextLevel;

        switch (queue.size()) {
            case (0):
                System.out.println("Лифт не получал команд");
                break;
            case (1):
                System.out.println("Лифт не двигался");
            default:
                while (!queue.isEmpty()) {
                    currentLevel = queue.peekLast();
                    System.out.printf("этаж %d", queue.pollLast());
                    totalSeconds += waitDoorsInSeconds;
                    if (!queue.isEmpty()) {
                        System.out.print(" -> ");
                        nextLevel = queue.peekLast();
                        totalSeconds += Math.abs(nextLevel - currentLevel) * waitMoveInSeconds;
                    } else System.out.println();
                }
                break;
        }

        System.out.printf("Общее время работы лифта: %d секунд\n", totalSeconds);
    }
}
