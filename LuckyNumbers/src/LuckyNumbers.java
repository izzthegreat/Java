import java.util.Arrays;
import java.util.Scanner;

public class LuckyNumbers {
    public static void main (String [] args) throws InterruptedException {

//        HelloWorld.print(); //Requisite "Hello World"

        // print the valid characters for input
//        AsciiChars.printNumbers();
//        AsciiChars.printUpperCase();
//        AsciiChars.printLowerCase();
//
//        input(); // Questions
        System.out.println(BMath.randomNum(50));
        System.out.println(BMath.randomNum(85));
        System.out.println(BMath.randomNum(72));
        System.out.println(BMath.randomNum(19));
        int[] randomArr = BMath.newNumArr(5);
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = BMath.randomNum(50);
        }
        System.out.println(Arrays.toString(randomArr));


   LearnArrayList.learnArrayList(); // ArrayList & Parameters lesson
    }

    private static void input() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        // Name input
        System.out.print("\nPlease enter your name: ");
        String name = input.next();

        // Form consent input
        System.out.println(String.format("Oh, hello %s!", name));
        System.out.println(String.format("Hey %s, do you want to answer a few questions? ", name));
        char consent = input.next().toUpperCase().charAt(0);

        //Begin form
        int[] luckyNumbers = new int[5];
        while (consent == 'Y') {
            System.out.print("What is your pet's name? ");
            int petName = (int)input.next().charAt(0);
            //System.out.println(petName);
            System.out.print("What is your favorite movie? (No spaces)");
            int movieFav = (int)input.next().charAt(4);
            //System.out.println(movieFav);
            System.out.print("In what city were you born? (No spaces) ");
            int birthPlace = (int)input.next().charAt(2);
            //System.out.println(birthPlace);
            System.out.print("What is your favorite color? ");
            int colorFav = (int)input.next().charAt(2);
            //System.out.println(colorFav);
            System.out.print("What color are your eyes? ");
            int eyeColor = (int)input.next().charAt(3);
            //System.out.println(eyeColor);
//            System.out.println("...");
            for (int i=0; i<15; i++){
                System.out.flush();
                System.out.print('.');
                Thread.sleep(100);
                System.out.print('.');
                Thread.sleep(100);
                System.out.print('.');
            }
            luckyNumbers[0]= petName;
            luckyNumbers[1]= movieFav;
            luckyNumbers[2]= birthPlace;
            luckyNumbers[3]= colorFav;
            luckyNumbers[4]= eyeColor;
            System.out.println(Arrays.toString(luckyNumbers));
            System.out.println("Do you want to answer those questions again?");
            consent = input.next().toUpperCase().charAt(0);
        } // End while loop
        System.out.println("Thank you, have a nice day. :)");
    } // End input method
}
