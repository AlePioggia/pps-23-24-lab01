package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private static final double STANDARD_FEE = 1;

    private double balance;
    private AccountHolder holder;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        this.holder = holder;
        this.balance = balance;
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
            this.completeAtmOperation(() -> this.balance += amount);
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.completeAtmOperation(() -> this.balance -= amount);
        }
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount;
    }

    private void completeAtmOperation(final Runnable runnable) {
        runnable.run();
        this.computeFee(STANDARD_FEE);
    }

    private void computeFee(double fee) {
        this.balance -= fee;
    }
}
