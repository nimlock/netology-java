package base.task_3_3_2;

class SavingsAccount extends Account {
    protected SavingsAccount(int startBalance) {
        super();
        this.addMoney(startBalance);
    }

    @Override
    void pay(int amount) {
        System.out.println("Данная операция не доступна на этом типе счета.");
    }

    @Override
    void transfer(Account account, int amount) {
        if (amount <= 0) {
            System.out.println("Сумма перевода должна быть больше нуля!");
        } else  if (amount > balance) {
            System.out.println("Сумма перевода больше остатка на счёте, действие недопустимо!");
        } else {
            account.addMoney(amount);
            balance -= amount;
        }
    }

    @Override
    void addMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Сумма пополнения должна быть больше нуля!");
        } else {
            balance += amount;
        }
    }
}
