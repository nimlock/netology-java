package base.task_3_3_2;

class CheckingAccount extends Account {
    protected CheckingAccount(int startBalance) {
        super();
        this.addMoney(startBalance);
    }

    @Override
    void pay(int amount) {
        if (amount <= 0) {
            System.out.println("Сумма платежа должна быть больше нуля!");
        } else  if (amount > balance) {
            System.out.println("Сумма списания превышает остаток на счёте, действие недопустимо!");
        } else {
            balance -= amount;
        }
    }

    @Override
    void transfer(Account account, int amount) {
        if (amount <= 0) {
            System.out.println("Сумма перевода должна быть больше нуля!");
        } else {
            this.pay(amount);
            account.addMoney(amount);
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
