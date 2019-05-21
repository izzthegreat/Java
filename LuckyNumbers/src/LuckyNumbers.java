import java.util.Scanner;

public class LuckyNumbers {
    public static void main (String [] args){
        // print the valid characters for input
        AsciiChars.printNumbers();
        AsciiChars.printUpperCase();
        AsciiChars.printLowerCase();
        input();
    }
    public static class AsciiChars {
        static void printNumbers() {
            // TODO: print valid numeric input
//            048-057
            for (int asciiNum=48; asciiNum<=57; asciiNum++){
                System.out.println((char)asciiNum);
            }
        }

        static void printUpperCase() {
            // TODO: print valid uppercase alphabetic input
//            065-090
            for (int asciiUp=65; asciiUp<=90; asciiUp++){
                System.out.println((char)asciiUp);
            }
        }

        static void printLowerCase() {
            // TODO: print valid lowercase alphabetic input
//            097-122
            for (int asciiLow=97; asciiLow<=122; asciiLow++){
                System.out.println((char)asciiLow);
            }
        }
    }

    static void input(){
        Scanner input = new Scanner(System.in);

        // Name input
        System.out.print("Please enter your name:");
        String name = input.next();

        // Form consent input
        System.out.println(String.format("Oh, hello %s!", name));
        System.out.println(String.format("Hey, %s, do you mind answering a few questions?",name));
        char consent = input.next().toUpperCase().charAt(0);

        //Begin form
        if (consent = 'Y') {

        }

    } // End input method





}
