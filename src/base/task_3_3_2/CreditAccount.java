package base.task_3_3_2;

class CreditAccount extends Account {
    protected CreditAccount(int startBalance) {
        super();
        this.pay(-startBalance);
    }

    @Override
    void pay(int amount) {
        if (amount <= 0) {
            System.out.println("Сумма платежа должна быть больше нуля!");
        } else {
            balance -= amount;
        }
    }

    @Override
    void transfer(Account account, int amount) {
        System.out.println("Данная операция не доступна на этом типе счета.");
    }

    @Override
    void addMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Сумма пополнения должна быть больше нуля!");
        } else  if (amount > -balance) {
            System.out.println("Сумма пополнения больше кредита на счёте, действие недопустимо!");
        } else {
            balance += amount;
        }
    }
}
