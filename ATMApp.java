import java.util.Scanner;

public class ATMApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AtmUser user = new AtmUser("1234", "5678");
        ATM atm = new ATM(user);

        System.out.println("Welcome to the ATM!");
        System.out.print("Please enter your user id: ");
        String id = scanner.nextLine();
        System.out.print("Please enter your pin: ");
        String pin = scanner.nextLine();

        if (!atm.authenticate(id, pin)) {
            System.out.println("Invalid credentials.");
            return;
        }

        System.out.println("Welcome " + atm.getUser().getId() + "!");
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Transactions History:");
                    atm.printTransactions();
                    break;
                case 2:
                    System.out.print("Amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Target ATM user id: ");
                    String targetId = scanner.nextLine();
                    System.out.print("Amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();
                    ATM targetATM = new ATM(new AtmUser(targetId, ""));
                    atm.transfer(targetATM, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
