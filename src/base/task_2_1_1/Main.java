package base.task_2_1_1;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] products = {"Молоко",
                "Хлеб",
                "Гречневая крупа",
                "Геркулес",
                "Картошка фасованная",
                "Макароны"};
        int[] prices = {80, 45, 63, 38, 187, 91};
        int[] cart = new int[products.length];

        welcomeMsg(products, prices);
        makeShopping(cart);
        finalMsg(products, prices, cart);
    }

    private static void welcomeMsg(String[] products, int[] prices) {
        System.out.println("\nСписок возможных товаров для покупки");
        for (int i=1; i <= products.length; i++) {
            System.out.println(i + ". " + products[i-1]);
        }
        System.out.println("\n");
    }

    private static void makeShopping(int[] cart) {
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String rawInput = myScanner.nextLine();
            if (rawInput.equals("end")) {
                break;
            } else if (!rawInput.contains(" ")) {
                System.out.println("Ошибка! Введена строка без пробела, повторите ввод.");
                continue;
            }
            String[] input = rawInput.split(" ");
            int position = Integer.parseInt(input[0]) - 1;
            int howMuch = Integer.parseInt(input[1]);
            cart[position] = cart[position] + howMuch;
        }
    }

    private static void finalMsg(String[] products, int[] prices, int[] cart) {
        int total = 0;

        System.out.println("\n Ваша корзина:");
        String[] header = {"Наименование товара",
                "Количество",
                "Цена/за.ед",
                "Общая стоимость"
        };

        System.out.printf("| %-20s| %-11s| %-11s| %-16s|%n",
                header[0],
                header[1],
                header[2],
                header[3]
        );
        for (int i=0; i < products.length; i++) {
            if (cart[i] != 0) {
                total = total + (cart[i] * prices[i]);
                System.out.format("| %-20s| %-11d| %-11d| %-16d|%n",
                        products[i],
                        cart[i],
                        prices[i],
                        (cart[i] * prices[i])
                );
            }
        }
        System.out.printf("%-35s| %-11s| %-16d|%n",
                " ",
                "Итого",
                total
        );
    }
}