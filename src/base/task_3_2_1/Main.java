package base.task_3_2_1;

import java.util.Scanner;

public class Main {
    protected static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Player player = new Player();
        // Как настоящие программисты мы имеем в виду, что исчисление начинается с 0
        System.out.format("У игрока %d слотов с оружием,"
                        + " введите номер, чтобы выстрелить,"
                        + " -1 чтобы выйти%n",
                player.getSlotsCount()
        );
        int slot;

        // главный цикл игры:
        // запрашивать номер с клавиатуры
        // с помощью scanner.nextInt(),
        // пока не будет введено -1
        while (true) {
            System.out.println("Выберите номер оружия из слотов для выстрела");
            int rawInput = myScanner.nextInt();
            if (rawInput == -1) {
                break;
            }
            player.shotWithWeapon(rawInput);
        }

        System.out.println("Game over!");
    }
}
