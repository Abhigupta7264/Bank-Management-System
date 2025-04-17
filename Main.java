import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    sc.nextLine(); // consume newline
                    String name = sc.nextLine();
                    int accNo = bank.createAccount(name);
                    System.out.println("Account created. Account Number: " + accNo);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int accNoDeposit = sc.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    if (bank.deposit(accNoDeposit, deposit)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int accNoWithdraw = sc.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    if (bank.withdraw(accNoWithdraw, withdraw)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance or account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int accNoBalance = sc.nextInt();
                    Double balance = bank.getBalance(accNoBalance);
                    if (balance != null) {
                        System.out.println("Current Balance: $" + balance);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    int accNoDetails = sc.nextInt();
                    Account acc = bank.getAccount(accNoDetails);
                    if (acc != null) {
                        acc.display();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using our services!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
