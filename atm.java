import java.util.Scanner;

public class Atm {
    private double accBalance = 50;

    public void start() {

        Scanner auth = new Scanner(System.in);

        int userMike = 5112002;
        int pinMike = 2472024;

        System.out.println("Welcome to ATM!");

        System.out.print("Enter Account Number: ");
        int user = auth.nextInt();

        System.out.print("Enter PIN: ");
        int pin = auth.nextInt();

        if (user == userMike && pin == pinMike) {
            options();
        }else {
            System.out.println("Login Failed!");
            start();
        }
        auth.close();
    }

    public void options() {

            System.out.println("Select Account Operation");
            System.out.println("1. Withdraw Amount");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            operations();
    }

    public void operations() {

        Scanner select = new Scanner(System.in);
        System.out.print("Choice: ");
        int num = select.nextInt();
        double amount;

        if (num == 1) {
            System.out.print("How much do you want to withdraw: ");
            amount = select.nextDouble();

            if (amount <= accBalance) {
                accBalance -= amount;
                System.out.println("Your current Account balance is: " + accBalance);
            } else {
                System.out.println("Amount can't be withdrawn");
            }
            options();

        } else if (num == 2) {
            System.out.print("How much do you want to deposit: ");
            amount = select.nextDouble();
            accBalance += amount;
            System.out.println("Your current Account balance is: " + accBalance);
            options();
        } else if (num == 3) {
            System.out.println("Your current Account balance is: " + accBalance);
            options();
        } else if (num == 4) {
            System.out.println("Thank you for using the ATM. Goodbye!");
            start();
        } else {
            System.out.println("Enter a valid number(1-4)");
            options();
        }
        select.close();
    }
}
