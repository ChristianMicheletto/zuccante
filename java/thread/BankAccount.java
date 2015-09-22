public class BankAccount {
    
    private long number;
    // account number
    private long balance;
    // current balance (in cents)
    public BankAccount(long initialDeposit) {
        balance = initialDeposit;
    }
    public synchronized long getBalance() {
        return balance;
    }
    public synchronized void deposit(long amount) {
        balance += amount;
        }
// ... rest of methods ...
}
