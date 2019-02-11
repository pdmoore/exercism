public class BankAccount {
    public static final String ACCOUNT_CLOSED     = "Account closed";
    public static final String NEGATIVE_AMOUNT    = "Cannot deposit or withdraw negative amount";
    public static final String ACCOUNT_EMPTY      = "Cannot withdraw money from an empty account";
    public static final String INSUFFICIENT_FUNDS = "Cannot withdraw more money than is currently in the account";
    private int balance;
    private boolean isOpen;

    public synchronized void open() {
        isOpen = true;
    }

    public synchronized void close() {
        isOpen = false;
    }

    public synchronized int getBalance() throws BankAccountActionInvalidException {
        validateAccountOpen();

        return balance;
    }

    public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        validateAccountOpen();
        validateAmountIsPositive(amount);

        balance += amount;
    }

    public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        validateAccountOpen();
        validateSufficientFunds(amount);
        validateAmountIsPositive(amount);

        balance -= amount;
    }

    private void validateAccountOpen() throws BankAccountActionInvalidException {
        if (!isOpen) throw new BankAccountActionInvalidException(ACCOUNT_CLOSED);
    }

    private void validateAmountIsPositive(int amount) throws BankAccountActionInvalidException {
        if (amount < 0) throw new BankAccountActionInvalidException(NEGATIVE_AMOUNT);
    }

    private void validateSufficientFunds(int amount) throws BankAccountActionInvalidException {
        if (balance == 0) throw new BankAccountActionInvalidException(ACCOUNT_EMPTY);

        if (amount > balance) throw new BankAccountActionInvalidException(INSUFFICIENT_FUNDS);
    }
}
