package base.task_2_2_2;

import java.util.Scanner;

public class AskForParameters {
    public static Scanner myScanner = new Scanner(System.in);

    public static int[] getSize() {
        int[] result = {10, 10};
        String[] choices = {"обычное (10 x 10)",
                "крупное (15 x 15)",
                "гигантское (20 x 20)"
        };
        System.out.println(Main.getManyCR().toString());
        System.out.println("Добро пожаловать в игру \'Морской тир\'!");
        while (true) {
            boolean success = true;
            System.out.println("\nВведите желаемый размер поля:");
            for (int i = 1; i <= choices.length; i++) {
                System.out.println(i + ". " + choices[i - 1]);
            }
            int userInput = myScanner.nextInt();
            switch (userInput) {
                case (1):
                    result = new int[] {10, 10};
                    break;
                case (2):
                    result = new int[] {15, 15};
                    break;
                case (3):
                    result = new int[] {20, 20};
                    break;
                default:
                    System.out.println("Такого варианта нет. Повторите выбор.");
                    success = false;
            }
            if (success) break;
        }
        return result;
    }
}