package base.task_2_2_1;

import java.util.Scanner;

public class AskForParameters {
    public static Scanner myScanner = new Scanner(System.in);

    public static int getSize(String request) {
        System.out.println("Введите сколько " + request + " должно быть в матрице:");
        return myScanner.nextInt();
    }

    public static int getMaxValue() {
        System.out.println("Введите целое положительное число - верхнюю границу для генератора случайных чисел:");
        return myScanner.nextInt();
    }
}