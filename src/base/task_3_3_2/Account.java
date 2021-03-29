package base.task_3_3_2;

abstract class Account {
    protected int balance;

    public int getBalance() {
        return balance;
    }

    abstract void pay(int amount);
    abstract void transfer(Account account, int amount);
    abstract void addMoney(int amount);

    void getSummary() {
        System.out.println("Summary for account:");
        System.out.printf("  type of account: %s\n  balance is %d\n",
                this.getClass().getSimpleName(),
                this.getBalance());
    }
}
