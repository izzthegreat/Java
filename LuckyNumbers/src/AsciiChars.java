public class AsciiChars {
    static void printNumbers() {
        // TODO: print valid numeric input
//            048-057
        for (int asciiNum=48; asciiNum<=57; asciiNum++) System.out.print((char) asciiNum + " ");
    } // end printNumbers method

    static void printUpperCase() {
        // TODO: print valid uppercase alphabetic input
//            065-090
        for (int asciiUp=65; asciiUp<=90; asciiUp++) System.out.print((char) asciiUp + " ");
    } // end printUpperCase

    static void printLowerCase() {
        // TODO: print valid lowercase alphabetic input
//            097-122
        for (int asciiLow = 97; asciiLow <= 122; asciiLow++) System.out.print((char) asciiLow + " ");
    } // end printLowerCase
}
