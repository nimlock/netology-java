package base.task_4_4_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private final static PhoneContacts phoneContacts = new PhoneContacts();

    public static void main(String[] args) {
        startMenu();
    }

    private static void startMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String fixScanner;

            System.out.println("Меню:\n" +
                               "1. Добавить группу контактов.\n" +
                               "2. Создать контакт.\n" +
                               "3. Печать групп в справочнике.\n" +
                               "4. Печать всего справочника.\n" +
                               "0. Выход.");

            boolean exitMenu = false;
            int mainInput;

            try {
                mainInput = scanner.nextInt();
                fixScanner = scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Требуется ввести число, повторите попытку.");
                continue;
            }

            switch (mainInput) {
                case 1:
                    System.out.println("Введите имя новой группы:");
                    String group = scanner.nextLine();
                    phoneContacts.addGroup(group);
                    break;

                case 2:
                    System.out.println("Введите имя контакта:");
                    String name = scanner.nextLine();
                    System.out.println("Введите номер телефона:");
                    String phone = scanner.nextLine();
                    Contact contact = new Contact(name, phone);
                    while (true) {
                        Scanner contactScanner = new Scanner(System.in);

                        System.out.println("В какую группу добавить контакт (0 - для завершения):");
                        phoneContacts.printGroupsNames();
                        int index;

                        try {
                            index = contactScanner.nextInt();
                            fixScanner = contactScanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Требуется ввести число, повторите попытку.");
                            continue;
                        }

                        if (index == 0) {
                            break;
                        }
                        phoneContacts.addContactToGroup(contact, index);
                    }
                    break;

                case 3:
                    phoneContacts.printGroupsNames();
                    break;

                case 4:
                    phoneContacts.printGroupsContent();
                    break;

                case 0:
                    exitMenu = true;
                    break;

                default:
                    System.out.println("Выбран несуществующий пункт меню. Повторите попытку.");

                    break;
            }

            System.out.println();

            if (exitMenu) {
                break;
            }
        }
    }
}
