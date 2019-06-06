import java.math.BigInteger;
import java.util.Scanner;

public class NewStuff {
    public static void main(String[] args) {
        squareNum();
    }
    private static void squareNum(){
        Scanner input = new Scanner(System.in);
        BigInteger inputNum = BigInteger.valueOf(0) ;
        do{
            try {
            System.out.println("Please enter a non-zero integer:");
            inputNum = input.nextBigInteger();
            } catch (Exception e) {
                System.out.println("Try Again");
                input = new Scanner(System.in);
            }
        } while (inputNum.compareTo(BigInteger.valueOf(0)) == 0);

        System.out.println("The square of " + inputNum + " is " + inputNum.pow(2));
    }
}
