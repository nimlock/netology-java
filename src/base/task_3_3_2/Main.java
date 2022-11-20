package base.task_3_3_2;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляров классов с присвоением начального баланса
        Account account1 = new CheckingAccount(8);
        Account account2 = new CreditAccount(-15);
        Account account3 = new SavingsAccount(165);

        // Отчёт о состоянии счетов
        account1.getSummary();
        account2.getSummary();
        account3.getSummary();

        // Блок проверки работы методов
        System.out.println();
        account1.transfer(account2, 5);
        account3.transfer(account1, 20);
        account2.transfer(account3, 1);
        account3.pay(2);
        System.out.println();

        // Отчёт о состоянии счетов
        account1.getSummary();
        account2.getSummary();
        account3.getSummary();
    }
}
