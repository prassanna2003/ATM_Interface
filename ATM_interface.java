import java.util.Scanner;

class BankAccount{
    private double balance;

    BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $ " + amount + " successful. current balance: $" + balance);
            
        } else {
            System.out.println( "Invalid deposit amount.");
        }
    }

    public void withdraw( double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("withdrawal of $" + amount + " successful. current balance; $" + balance);
        } else {
            System.out.println("Invalid withdrwal amount or insufficient.current balance: $" + balance);
        }
    }
}

 class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public static void diplayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("current balance : $ " + bankAccount.getBalance());
                break;
            case 2: 
                System.out.println("Enter deposit amount: $");
                double depositAmount = scanner .nextDouble();
                bankAccount.deposit(depositAmount);
                break;
             case 3:
                System.out.println("Enter withdrawal amount : $ ");
                double withdrwalAmount = scanner .nextDouble();
                bankAccount .withdraw(withdrwalAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                scanner.close();
                System.exit(0);

                default:
                System.out.println("Invalid choice. Please select a valid option.");
              
        }
    }
}

public class ATM_interface {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            System.out.println("Enter innitial account balance: $");
            double intilialBalance = scanner .nextDouble();
            BankAccount bankAccount = new BankAccount(intilialBalance);

             ATM atm = new ATM(bankAccount);

            while (true) {
                ATM.diplayMenu();
                System.out.print("select an option: ");
                int choice = scanner.nextInt();

                atm.performTransaction(choice, scanner);
                
            }
        }
      }