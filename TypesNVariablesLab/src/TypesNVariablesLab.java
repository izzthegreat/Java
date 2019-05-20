public class TypesNVariablesLab {
    private static int firstInt = 6;
    private static int secondInt = 20;
    private static int thirdInt;
    private static float onlyFloat = 4.4f;
    private static boolean isCold = false;
    private static double onlyDouble = 1_000_000.99;

    public static void main (String [] args){
    step1();
    step2();
    step3();
    step4();
    anotherMethod();
    playWithStrings();
    }

    private static void step1 () {
        System.out.println(firstInt);
        System.out.println(secondInt);
//      System.out.println(thirdInt);
        System.out.println(onlyFloat);
        System.out.println(isCold);
        System.out.println(onlyDouble);
    }

    private static void step2 () {
        int sumFirstSecond = firstInt + secondInt;
        System.out.println(sumFirstSecond);
//        int sumFirstThird = firstInt + thirdInt;
//        thirdInt is undefined
        System.out.println(secondInt / firstInt);
        System.out.println(secondInt % firstInt);
        int newInt = (secondInt % firstInt) + firstInt;
        System.out.println(++newInt);
    }

    private static void step3 () {
        int x =100;
        boolean x100 = x == 100;
        int y = 106;
        System.out.println(x > y);
        System.out.println(y > x);
        System.out.println(x >= y-6);
        int z = 92;
        System.out.println(x < y && y < z);
        System.out.println(y < z && z > y+x || x-y < z);
        System.out.println(x < y != x > y);
    }

    private static void step4 () {
        int n = 64;
        System.out.println(n >> 1 == n/2);
        System.out.println(n << 1 == n*2);
        n = 40;
        System.out.println(n >> 1 == n/2);
        System.out.println(n << 1 == n*2);
        System.out.println(n >> 2 == n/4);
        System.out.println(n << 2 == n*4);
        n = 13;
        System.out.println(n >> 1 == n/2);
        System.out.println(n << 1 == n*2);
        System.out.println(n >> 2 == n/4);
        System.out.println(n << 2 == n*4);
    }

    public static void anotherMethod (){
//        step 5
        int aNum = 27; // Local int cannot be referenced in main
        int halfANum = aNum/2; //halfANum needs to be declared outside
//        if (aNum > 1000) {
//            System.out.println(aNum + " is a Big Value");
//            System.out.println(halfANum + " is half of a Big Value");
//        } else {
//            System.out.println(aNum + " is not a big value");
//            System.out.println(halfANum + " is definitely small.");
//        }

//        step 6
        Integer aThousand = Integer.valueOf("1000");
        if (aThousand.compareTo(aNum) == 0 ) {
            System.out.println(aNum + " is a Big Value");
            System.out.println(halfANum + " is half of a Big Value");
        } else {
            System.out.println(aNum + " is not a big value");
            System.out.println(halfANum + " is definitely small.");
        }
    }

    public static void playWithStrings () {
//        step 7
        String firstName = "Bryant";
        String lastName = new String ("Allen");
        System.out.println("Hello "
//                .concat(firstName).concat(" ").concat(lastName)
                + firstName + " " + lastName
        );

        String fullName = firstName + " " + lastName; // Bryant Allen
        int nameLength = fullName.length(); // 12
        int indexO = fullName.indexOf("o"); // -1
        char seventhChar = fullName.charAt(7); // A
        boolean hasSon = fullName.contains("son"); // false
        String last5 = fullName.substring(nameLength-5); // Allen
        boolean hasApostrophe = fullName.contains("'"); // false
        boolean hasHyphen = fullName.contains("-"); // false

        System.out.println("The total length of the String \"" + fullName + "\" is " + nameLength);
        System.out.println("The String \"" + fullName + "\" does not have an \"o\".");
        System.out.println("The seventh character of the String \"" + fullName + "\" is " + seventhChar +'.');
        System.out.println( "The String \"" + fullName + "\" does not contain the substring \"son\".");
        System.out.println("The last 5 characters of the String \"" + fullName + "\" are \"" + last5 + "\".");
        System.out.println("The String \"" + fullName + "\" does not have an \"'\" or a \"-\".");
    }
}
