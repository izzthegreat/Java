import java.util.Scanner;

public class JavaControlFlow {
    static int [] myArray = new int[30];
    public static void main (String [] args) {
        branchOne(22);
        System.out.println(branchTwo(22));
        Scanner scanner = new Scanner(System.in);
        char again;
        do {
            System.out.print("Enter your name: ");
            String username = scanner.next();

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            System.out.println("What is your  employment status?");
            System.out.println("'E' - Employed, 'U' - Unemployed, or 'S' - Student:");
            char hasJob = scanner.next().toUpperCase().charAt(0);

            System.out.println("Do you have a car, truck, SUV, or do you not own a vehicle?");
            System.out.println("'C'- Car, 'T' - Truck, 'S' - SUV, or 'N' - none:");
            char hasCar = scanner.next().toUpperCase().charAt(0);

            System.out.println(String.format("Hello %s, your age is %d", username, age));

    //        Step 1
            if (age >= 16) {
                System.out.println("You are old enough to drive.");
            } else {
                System.out.println("You are not old enough to drive");
            }

            if (age >= 18) {
                System.out.println("You are old enough to vote");
            } else {
                System.out.println("You are not old enough to vote");
            }

            if (age >= 21) {
                System.out.println("You are old enough to drink");
            } else {
                System.out.println("You are not old enough to drink");
            }

            if (age >= 35) {
                System.out.println("You are old enough to be President");
            } else {
                System.out.println("You are not old enough to be President");
            }

            if (age >= 55) {
                System.out.println("You can join AARP");
            } else {
                System.out.println("You cannot yet join AARP");
            }

            if (age >= 67) {
                System.out.println("You can start drawing Social Security");
            } else {
                System.out.println("You cannot start drawing Social Security");
            }

    //        Step 2
            switch (hasJob) {
                case 'E':
                    System.out.println("You are employed");
                    break;
                case 'U':
                    System.out.println("You are unemployed");
                    break;
                case 'S':
                    System.out.println("You are a student");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + hasJob);
            }

            switch (hasCar) {
                case 'C':
                    System.out.println("You drive a car");
                    break;
                case 'T':
                    System.out.println("You drive a truck");
                    break;
                case 'S':
                    System.out.println("You drive an SUV");
                    break;
                case 'N':
                    System.out.println("You ride the bus");
                default:
                    throw new IllegalStateException("Unexpected value: " + hasCar);
            }

            System.out.println("Do you want to answer the questions again?");
            again = scanner.next().toUpperCase().charAt(0);
        } while ( again == 'Y');
        //Step 3


        int [] myArray = new int[30];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
        }

        for (int item: myArray) {
            System.out.println(item);
        }

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (i+1)*2;
        }

        for (int item: myArray) {
            System.out.println(item);
        }

        for (int i = myArray.length-1; i >= 0 ; i--) {
            System.out.println(myArray[i]);
        }

//        Step 4
        int i;

        i = 0;
        while (i < myArray.length) {
            System.out.println(myArray[i]);
            i++;
        }

        i = myArray.length-1;
        while (i >= 0){
            System.out.println(myArray[i]);
            i--;
        }
    }

    static void branchOne (int b) {
        int [] myArray = new int[30];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
        }
        for (int item: myArray){
            if (item == b) break;
            if (item % 2 != 0) {
                continue;
            } else if (item % 2 == 0) {
                System.out.println(item);
            }
        }
    }
    static int branchTwo (int b) {
         int [] myArray = new int[30];
            int evenTotal = 0;
            for (int i = 0; i < myArray.length; i++) {
                myArray[i] = i;
            }
            for (int item: myArray){
                if (item % 2 == 0) {
                   evenTotal += item;
                } else if (item % 2 != 0) {
                    System.out.println(item);
                }
                if (item == b) break;
            }
        return evenTotal;
    }
}

//const array = [1,2,3,4,5]
//
//array.forEach((x)=>{
//    do stuff to each x
//        })
//
//        do stuff to 1
//        do stuff to 2
//        etc...
//
//        int[] array = {1,2,3,4,5}
//for(int x: array) {
//    do stuff to each x
//        }