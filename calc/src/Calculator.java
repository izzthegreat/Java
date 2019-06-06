import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        userInterface();
    }

    private static void userInterface(){
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            do {
                try {
                    System.out.println("What would you like to do?");
                    System.out.println("1. Add");
                    System.out.println("2. Subtract");
                    System.out.println("3. Multiply");
                    System.out.println("4. Divide");
                    System.out.println("5. Exit Calculator");
                    System.out.print("Enter(1-5):");
                    option = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Please enter a valid menu option.");
                    input = new Scanner(System.in);
                }
            } while (option < 1 || option > 6);
            if (option == 5) break;
            int num1 = 0, num2 = 0;
            do {
                try {
                    System.out.println("Please enter your first integer.");
                    num1 = input.nextInt();
                    System.out.println("Please enter a second integer.");
                    num2 = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Try again");
                    input = new Scanner(System.in);
                }
            } while (num1 == 0 && num2 == 0);

            switch (option) {
                case 1:
                    int sum = Functions.add(num1, num2);
                    System.out.println(String.format("%d + %d = %d", num1, num2, sum));
                    break;
                case 2:
                    int difference = Functions.subtract(num1, num2);
                    System.out.println(String.format("%d - %d = %d", num1, num2, difference));
                    break;
                case 3:
                    int product = Functions.multiply(num1, num2);
                    System.out.println(String.format("%d * %d = %d", num1, num2, product));
                    break;
                case 4:
                    double quotient = Functions.divide((double) num1, (double) num2);
                    System.out.println(String.format("%d / %d = %f", num1, num2, quotient));
                    break;
                default:
                    break;
            }
        } while(option != 5);
        System.out.println("Thank's for playing!");
        System.out.println("\uD83D\uDE0A Have a great day! \uD83D\uDE0A");
    }

}


