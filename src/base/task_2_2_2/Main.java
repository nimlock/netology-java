package base.task_2_2_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

enum cellValues {EMPTY, SHIP, KILLED, MISS}

public class Main {
    public static Scanner myScanner = new Scanner(System.in);
    public static int[] setField = AskForParameters.getSize();
    public static final int COLUMNS = setField[0];
    public static final int ROWS = setField[1];
    public static final String CHAR_TEMPLATE = "%4" + "c";
    public static final String DIGIT_TEMPLATE = "%4" + "d";
    public static int enemies = (int) (COLUMNS * ROWS * 0.1f);
    public static int rounds = enemies * 3;
    public static cellValues[][] warField = prepareField();

    public static void main(String[] args) {
        System.out.println("Осталось: " + "ходов - " +  rounds + "; противников - " + enemies);
        while (true) {
            int[] aim = enterAim();
            checkShot(aim);
            rounds--;
            System.out.println("Осталось: " + "ходов - " +  rounds + "; противников - " + enemies);
            if (enemies == 0) {
                System.out.println("\nПоздравляем с победой!");
                break;
            }
            if (rounds == 0) {
                System.out.println("\nОчень жаль, но ходов больше нет. Вы проиграли.");
                break;
            }
        }
    }

    private static cellValues[][] prepareField() {
        cellValues[][] newField = new cellValues[ROWS][COLUMNS];
        Random random = new Random();
        int comingEnemies = enemies;

        for (int i = 0; i< ROWS; i++) {
            for (int j = 0; j< COLUMNS; j++) {
                newField[i][j] = cellValues.EMPTY;
            }
        }
        while (comingEnemies > 0) {
            int randomI = random.nextInt(ROWS);
            int randomJ = random.nextInt(COLUMNS);
            if (newField[randomI][randomJ] == cellValues.SHIP) continue;
            newField[randomI][randomJ] = cellValues.SHIP;
            comingEnemies--;
        }
        printField(newField);
        return newField;
    }

    private static void printField(cellValues[][] warField) {
        // Очистка экрана
        System.out.println(getManyCR().toString());

        // Нумерация столбцов
        for (int j = 0; j <= COLUMNS; j++) {
            if (j == 0) {
                System.out.printf(CHAR_TEMPLATE, '\u2605');
            } else {
                System.out.printf(DIGIT_TEMPLATE, j);
            }
        }
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.printf(DIGIT_TEMPLATE, (i + 1)); // Нумерация строк
            for (int j = 0; j < COLUMNS; j++) {
                System.out.printf(CHAR_TEMPLATE, getChar(warField[i][j]));
            }
            System.out.println();
        }
    }

    private static int[] enterAim() {
        int[] result;
        while (true) {
            System.out.println("Введите строку и столбец цели через проблел (или f для отрисовки поля):");
            String userInput = myScanner.nextLine();
            if (userInput.equals("f")) {
                printField(warField);
                continue;
            } else if (!userInput.contains(" ")) {
                System.out.println("Ошибка! Введена строка без пробела, повторите ввод.");
                continue;
            }
            String[] input = userInput.split(" ");
            int row = Integer.parseInt(input[0]) - 1;
            int column = Integer.parseInt(input[1]) - 1;

            if (row > (ROWS - 1) || column > (COLUMNS - 1)) {
                System.out.println("Вы выбрали клетку вне поля. Повторите выбор.");
                continue;
            } else if (warField[row][column] == cellValues.KILLED
                    || warField[row][column] == cellValues.MISS) {
                System.out.println("Вы выбрали открытую ранее клетку. Повторите выбор.");
                continue;
            } else {
                result = new int[]{row, column};    // Если прошли до этого условия, значит клетка валидна для проверки
                break;
            }
        }
        return result;
    }

    private static void checkShot(int[] aim) {
        cellValues hitResult = warField[aim[0]][aim[1]];
        switch (hitResult) {
            case EMPTY:
                warField[aim[0]][aim[1]] = cellValues.MISS;
                printField(warField);
                System.out.println("Не попал");
                break;
            case SHIP:
                warField[aim[0]][aim[1]] = cellValues.KILLED;
                enemies--;
                printField(warField);
                System.out.println("Попал!");
                break;
            default:
                System.out.println("Что-то пошло не так. Сообщите об этом разработчику.");
        }
    }

    private static char getChar(cellValues cellValues) {
        char result;
        switch (cellValues) {
            case SHIP:
            case EMPTY:
                result = '\u223C';
                break;
            case MISS:
                result = '\u00B7';
                break;
            case KILLED:
                result = '\u271E';
                break;
            default:
                result = '?';
        }
        return result;
    }

    public static String getManyCR() {
        // Используется для очистка экрана перед выводом поля
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }
}