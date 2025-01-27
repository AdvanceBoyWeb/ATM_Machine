package My_ATM;

import java.util.Scanner;

class ATM{
    float Balance;
    int pin = 1234;

    public void checkPin(){
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();
        if (enteredpin == pin){
            menu();
        }
        else {
            System.out.println("Enter a valid pin");
            checkPin();
        }
    }

    public void menu() {
        System.out.println("Enter your choice: ");
        System.out.println("1. Check account balance: ");
        System.out.println("2. Withdraw money: ");
        System.out.println("3. Deposit money: ");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1){
            checkBalance();
        }
        else if (opt == 2) {
            withdrawMoney();
        } 
        else if (opt == 3) {
            depositMoney();
        }
        else if (opt == 4) {
            return;
        }
        else {
            System.out.println("Enter a valid choice: ");
            menu();
        }
    }

    public void checkBalance() {
        System.out.println("Balance: "+ Balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter Amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount>Balance) {
            System.out.println("Insufficient balance.");
        }
        else {
            Balance = Balance - amount;
            System.out.println("Money withdraw successful.");
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter Amount");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("Money Deposit successful.");
        menu();
    }
}
public class atmMachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPin();
    }
}
