import org.jetbrains.annotations.NotNull;
import java.util.*;
public class LuckyNumbers {
    private static Scanner input = new Scanner(System.in).useDelimiter("\n");
    private static char consent;
    private static String userName, petName, starName;
    private static int[] lotteryNums = new int[5];
    private static int petAge, luckyNum, jerseyNum, modelYear, randNum, magicNum;

    // Just a pre-formatted Randomizer
    static class BMath {
        // Creates Random Number Between "1" and "max"
        static int randomNum (int max) { return (int) Math.ceil(Math.random() * max); }
    } //end BMath class

    public static void main (String [] args) throws InterruptedException {
        getConsent();
        while (consent == 'Y') {
            askQuestions();
            doMagic();
            pick5();
            output();
        }
        System.out.println("Thank you for your time. :)");
    } // end main method

    // Gets Player Name and Gets Initial Consent
    private static void getConsent() {
        System.out.print("Please enter your name: ");
        userName = input.next();
        System.out.println(String.format("Hi %s!",userName));
        do {
            System.out.println("Would you like to take a short survey?");
            System.out.print("(Yes, No) ");
            consent = input.next().toUpperCase().charAt(0);
        } while (consent != 'Y' && consent != 'N');
    } // end getConsent method

    // Collects Data from User Input
    private static void askQuestions() {
        System.out.println("Ok, great!");
        System.out.println("Before we begin, just an FYI: If at any time you enter an invalid input,\nI will repeat the question until I receive a valid answer.");
        System.out.println("-- Begin Survey --");
        do {
            System.out.println("1. What is the name of your favorite pet? (min 3 chars.)");
            petName = input.next();
        } while( petName.length() <= 2);

        do {
            System.out.println("2. How old is your favorite pet? (in Years) (min. 1) ");
            try{petAge = input.nextInt();}
            catch (Exception e){ // Catches Exception (so the program doesn't crash)
                System.out.println("Incorrect Input Type");
                System.out.println("Please enter an integer.");
                input = new Scanner(System.in).useDelimiter("\n");
            }
        } while (petAge <= 0);

        do {
            System.out.println("3. What is your lucky number? (non-Zero, please!)");
            try{ luckyNum = input.nextInt(); }
            catch (Exception e){
                System.out.println("Incorrect Input Type");
                System.out.println("Please enter an integer.");
                input = new Scanner(System.in).useDelimiter("\n");
            }
        } while (luckyNum == 0);

        do {
            System.out.println("4. What is the jersey number of your favorite athlete? ");
            try { jerseyNum = input.nextInt(); }
            catch (Exception e){
                System.out.println("Incorrect Input Type");
                System.out.println("Please enter an integer.");
                input = new Scanner(System.in).useDelimiter("\n");
            }
        } while (jerseyNum == 0);

        do {
            System.out.println("5. What was the model year of your first car? (1900 etc.)");
            try { modelYear = input.nextInt(); }
            catch (Exception e){
                System.out.println("Incorrect Input Type");
                System.out.println("Please enter an integer.");
                input = new Scanner(System.in).useDelimiter("\n");
            }
        } while (modelYear < 1900 || modelYear > 2019);
        modelYear = modelYear%100;

            System.out.println("6. What is the first name of your favorite actor/actress? ");
            starName = input.next();

        do {
            System.out.println("Finally, enter a random number between 1 and 50. ");
            try { randNum = input.nextInt(); }
            catch (Exception e){
                System.out.println("Incorrect Input Type");
                System.out.println("Please enter an integer.");
                input = new Scanner(System.in).useDelimiter("\n");
            }
        } while (randNum <= 0 || randNum > 50);
        System.out.println("-- End Survey --");
    } // end askQuestions method

    // Choose Magic Number
    private static void doMagic(){
        magicNum = luckyNum*BMath.randomNum(50);
        while (magicNum > 75) magicNum -= 75;
    } // end doMagic method

    // Choose 5 LuckyNumbers Numbers
    private static void pick5() {
        // Create an ArrayList of Values Generated Using the User Input.
        ArrayList<Integer> eightNums = new ArrayList<>();
        // Find the 3rd letter of their favorite pet. Convert that character value to an integer value.
        eightNums.add(0, (int)petName.charAt(2));
        // Use the two digit model year of their car and add their lucky number to it.
        eightNums.add(1, modelYear%100 + luckyNum);
        // Use the random number between 1 and 50, subtracting one of the generated random numbers.
        eightNums.add(2, randNum-BMath.randomNum(50));
        // Convert the first letter of their favorite actor/actress to an integer and use that value.
        eightNums.add(3, (int)starName.charAt(0));
        // Convert the last letter of their favorite actor/actress to an integer and use that value.
        eightNums.add(4, (int)starName.charAt(starName.length()-1));
        // Use the value 42.
        eightNums.add(5, 42);
        // Use the age of their favorite pet + their car model year.
        eightNums.add(6, petAge + modelYear);
        // Favorite quarterback number + age of pet + lucky number.
        eightNums.add(7, jerseyNum + petAge + luckyNum);

        // Verify all values are within the 1-65 range
        for (int i = 0; i < eightNums.size(); i++) {
            if (eightNums.get(i) < 0) eightNums.set(i, eightNums.get(i)*(-1));
            while (eightNums.get(i) > 65) eightNums.set(i, eightNums.get(i)-65);
            if (eightNums.get(i) == 0) eightNums.set(i, BMath.randomNum(65));
        }

        // Randomly Assign Five LuckyNumbers Numbers from the Previous ArrayList
        for (int i = 0; i < lotteryNums.length;i++) {
            int randomIndex =(int) Math.floor(Math.random() * eightNums.size());
            lotteryNums[i]=eightNums.get(randomIndex);
            eightNums.remove(randomIndex);
        }

        removeArrayDupes(lotteryNums);
    } // end pick5 method

    // Sort an Array and Replace Duplicate Numbers
    private static void removeArrayDupes (@NotNull int[] input) {
        int dupes;
        int [] newArr = new int[input.length];
        do {
            Arrays.sort(input);
            dupes = 0;
            int newNum = input[0];
            newArr[0] = newNum;
            for (int i = 1; i < input.length; i++) {
                int oldNum = input[i];
                if (newNum != oldNum) {
                    newArr[i] = oldNum;
                } else {
                    dupes++;
                    int newRandom;
                    do { newRandom = BMath.randomNum(65); } while (newRandom == oldNum);
                    newArr[i] = newRandom;
                }
                newNum = oldNum;
            }
            input = newArr;
        } while (dupes > 0);
    } // end removeArrayDupes method

    // Display Lucky Numbers and Ask for Consent to Repeat
    private static void output() throws InterruptedException {
        loadingBar();
        System.out.println(
                String.format("LuckyNumbers numbers: %d, %d, %d, %d, %d Magic Ball: %d",
                lotteryNums[0], lotteryNums[1], lotteryNums[2], lotteryNums[3], lotteryNums[4], magicNum
                )
        );
        do{
            System.out.println(String.format("Would you like to answer again, %s?", userName));
            consent = input.next().toUpperCase().charAt(0);
        } while (consent != 'Y' && consent != 'N');
    } //end output method

    // Bryant Being Extra (As Usual)
    private static void loadingBar() throws InterruptedException {
        System.out.println("Computing...");
        for (int i = 0; i < 99; i++){
            Thread.sleep(50);
            System.out.print("|");
        }
        Thread.sleep(50);
        System.out.println("|");
    } //end loadingBar method

} // end LuckyNumbers Class
