import java.util.Scanner;
public class Stuff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.print("Enter integer number: ");
        number = sc.nextInt();
        System.out.println("The square of "+ number + " is: "+ (int)Math.pow(number, 2));
    }
}