import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static int idCounter = 1000;
    private Map<Integer, Account> accounts = new HashMap<>();

    public int createAccount(String name) {
        Account acc = new Account(++idCounter, name);
        accounts.put(acc.getAccountNumber(), acc);
        return acc.getAccountNumber();
    }

    public boolean deposit(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            return acc.withdraw(amount);
        }
        return false;
    }

    public Double getBalance(int accNo) {
        Account acc = accounts.get(accNo);
        return acc != null ? acc.getBalance() : null;
    }

    public Account getAccount(int accNo) {
        return accounts.get(accNo);
    }
}
