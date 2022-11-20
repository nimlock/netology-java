package base.task_2_2_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner myScanner = new Scanner(System.in);
    public static final int ROWS = AskForParameters.getSize("строк");
    public static final int COLUMNS = AskForParameters.getSize("столбцов");
    public static final int RANDOM_BOUND = AskForParameters.getMaxValue();

    public static final int CELL_WIDTH = (RANDOM_BOUND + "").length() + 2;
    public static final String FORMAT_TEMPLATE = "%" + CELL_WIDTH + "d";

    public static void main(String[] args) {
        int[][] matrix = new int[ROWS][COLUMNS];
        int numberOfTurns = 0;
        boolean isSidesInverted = false;

        Random random = new Random();
        for (int i = 0; i< ROWS; i++) {
            for (int j = 0; j< COLUMNS; j++) {
                // для случайных значений воспользуемся готовым решением из библиотеки java.util.Random
                matrix[i][j] = random.nextInt(RANDOM_BOUND);
            }
        }

        System.out.println("\nИсходная матрица:");
        printMatrix(matrix, isSidesInverted);

        numberOfTurns = dialog();
        isSidesInverted = numberOfTurns % 2 != 0;

        int[][] rotatedMatrix = turnMatrix(matrix, numberOfTurns);
        System.out.println("\nПовёрнутая матрица:");
        printMatrix(rotatedMatrix, isSidesInverted);
    }

    private static int dialog() {
        int result = 0;
        boolean isLeftDirection = false;
        String[] directions = {"вправо", "влево"};
        String[] choices = {"90 градусов",
                "180 градусов",
                "270 градусов"
        };
        while (true) {
            boolean success = true;
            System.out.println("\nВыберите направление вращения матрицы:");
            for (int i = 1; i <= directions.length; i++) {
                System.out.println(i + ". " + directions[i - 1]);
            }
            int userInput = myScanner.nextInt();
            switch (userInput) {
                case (1):
                    isLeftDirection = false;
                    break;
                case (2):
                    isLeftDirection = true;
                    break;
                default:
                    System.out.println("Такого варианта нет. Повторите выбор.");
                    success = false;
            }
            if (success) break;
        }

        while (true) {
            boolean success = true;
            String direction = isLeftDirection ? directions[1] : directions[0];
            System.out.println("\nВыберите на сколько градусов требуется повернуть матрицу " + direction + ":");
            for (int i = 1; i <= choices.length; i++) {
                System.out.println(i + ". " + choices[i - 1]);
            }
            int userInput = myScanner.nextInt();
            switch (userInput) {
                case (1):
                    result = 1;
                    break;
                case (2):
                    result = 2;
                    break;
                case (3):
                    result = 3;
                    break;
                default:
                    System.out.println("Такого варианта нет. Повторите выбор.");
                    success = false;
            }
            if (success) break;
        }
        if (isLeftDirection) {
            result = result * -1;
        }
        return result;
    }

    static void printMatrix(int[][] matrix, boolean isSidesInverted) {
        int currentRows = isSidesInverted ? COLUMNS : ROWS;
        int currentColumns = isSidesInverted ? ROWS : COLUMNS;

        for (int i = 0; i< currentRows; i++) {
            for (int j = 0; j< currentColumns; j++) {
                // %4d означает, что мы под каждый номер резервируем 4 знака
                // (незанятые будут заполнены пробелами)
                // таким образом, у нас получится ровная таблица
                System.out.format(FORMAT_TEMPLATE, matrix[i][j]);
            }
            // Переход на следующую строку
            System.out.println();
        }
    }

    static int[][] turnMatrix(int[][] originalMatrix, int numberOfTurns) {
        int rowsAfterRotation = (numberOfTurns % 2 == 0) ? ROWS : COLUMNS;
        int columnsAfterRotation = (numberOfTurns % 2 == 0) ? COLUMNS : ROWS;
        int[][] turnedMatrix = new int[rowsAfterRotation][columnsAfterRotation];

        for (int i = 0; i< ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                int iNew = -1;
                int jNew = -1;

                if (numberOfTurns == 1 || numberOfTurns == -3) {
                    iNew = j;
                    jNew = ROWS - 1 - i;
                } else if (numberOfTurns == 2 || numberOfTurns == -2) {
                    iNew = ROWS - 1 - i;
                    jNew = COLUMNS - 1 - j;
                } else if (numberOfTurns == 3 || numberOfTurns == -1) {
                    iNew = COLUMNS - 1 - j;
                    jNew = i;
                }
                turnedMatrix[iNew][jNew] = originalMatrix[i][j];
            }
        }
        return turnedMatrix;
    }
}