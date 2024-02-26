package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private static double STANDARD_FEE = 1;

    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccountWithAtm(AccountHolder account) {
        this.balance = 0;
        this.holder = account;
    }

    public SimpleBankAccountWithAtm(double balance, AccountHolder account) {
        this.balance = balance;
        this.holder = account;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (this.checkUser((userID))) {
            this.balance += amount;
            this.addFee(STANDARD_FEE);
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
            this.addFee(STANDARD_FEE);
        }
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    private void addFee(double fee) {
        this.balance -= fee;
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount;
    }
}
