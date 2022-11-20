package base.task_3_4_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        //Проверить логин и пароль
        User loggedUser = getUserByLoginAndPassword(login, password);
        //Вызвать методы валидации пользователя
        validateUser(loggedUser);

        System.out.println("\nДоступ представлен");
    }

    private static User[] getUsers() {
        User user1 = new User("jhon", "jhon@gmail.com", "pass", 24);
        User user2 = new User("mike", "mike@yandex.ru", "pass", 17);
        return new User[]{user1, user2};
    }

    private static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (login.equals(user.login) && password.equals(user.password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    private static void validateUser(User user) throws AccessDeniedException {
        int minAge = 18;
        if (user.age < minAge) {
            throw new AccessDeniedException("User is too young.");
        }
    }
}
