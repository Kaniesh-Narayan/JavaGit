abstract class Account {
    int accountId;
    int customerId;
    double balance;

    abstract double deposit(int id, double amount);
    abstract double withdraw(int id, double amount);
}

class SavingAccount extends Account {

    SavingAccount(int accId, int custId, double bal) {
        this.accountId = accId;
        this.customerId = custId;
        this.balance = bal;
    }

    double deposit(int id, double amount) {
        if (id == accountId) {
            balance += amount;
            return balance;
        }
        return -1;
    }

    double withdraw(int id, double amount) {
        if (id != accountId) return -1;
        if (amount <= balance) {
            balance -= amount;
            return balance;
        }
        return -1;
    }
}

public class TestAccount {
    public static void main(String[] args) {
        SavingAccount sa = new SavingAccount(101, 1001, 1000.0);

        double result;

        result = sa.deposit(101, 500);
        System.out.println(result == -1 ? "Deposit failed: Invalid account ID" : "Deposit successful. New balance: " + result);

        result = sa.withdraw(101, 300);
        System.out.println(result == -1 ? "Withdrawal failed: Invalid ID or insufficient balance" : "Withdrawal successful. New balance: " + result);

        result = sa.withdraw(101, 2000);
        System.out.println(result == -1 ? "Withdrawal failed: Invalid ID or insufficient balance" : "Withdrawal successful. New balance: " + result);

        result = sa.deposit(999, 100);
        System.out.println(result == -1 ? "Deposit failed: Invalid account ID" : "Deposit successful. New balance: " + result);
    }
}
