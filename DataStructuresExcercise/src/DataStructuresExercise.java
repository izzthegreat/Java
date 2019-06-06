import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class DataStructuresExercise {
    public static void main (String [] args) {
//        arrayListForEach();
//        hashEach();
        moreForEach();
//        carDealer();
    }

    private static void arrayListForEach(){
        ArrayList<String> zoo = new ArrayList<>();
        zoo.add("Lions");
        zoo.add("Tigers");
        zoo.add("Bears");
        String favorite = "Bears";

        // with ArrayList.forEach
        Consumer<String> zooTrip = x -> {
            System.out.println(x);
            if (x.equals(favorite)) {
                System.out.println(String.format("I love %s!", x));
            } else {
                System.out.println("No, I don't care for those.");
            }
        };
        zoo.forEach(zooTrip);

        // with forEach/enhanced for loop
        for (String animal: zoo) {
            System.out.println(animal);
            if (animal.equals(favorite)) {
                System.out.println(String.format("I love %s!",animal));
            } else {
                System.out.println("No, I don't care for those.");
            }
        }
    }

    private static void hashEach() {
        Scanner input = new Scanner(System.in);
        HashMap<String, String> person = new HashMap<>();
        System.out.println("What is your name?");
        person.put("Name",input.next());
        System.out.println("How old are you?");
        person.put("Age", input.next());
        System.out.println("Where are you from?");
        person.put("Hometown", input.next());
        System.out.println("What is your favorite food?");
        person.put("Favorite Food", input.next());
        System.out.println(
                String.format(
                        "This is %s.\nThey are %s-years-old,\nfrom %s\nand their favorite food is %s.",
                        person.get("Name"),
                        person.get("Age"),
                        person.get("Hometown"),
                        person.get("Favorite Food")
                )
        );


    }

    private static void moreForEach() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 5 numbers");
        // read UserInput of 5 numbers as a String
        String numString = input.nextLine();
        // separate string into array
        String[] numArr = numString.split(" ");
        //Initialize ArrayList
        ArrayList <Integer> nums = new ArrayList<>();
        //convert sting array into Integer Arraylist
        for (String num : numArr) nums.add(Integer.parseInt(num));
        System.out.println("Here are your numbers:");
        System.out.println(nums);
//        AtomicInteger sum = new AtomicInteger();
//        nums.forEach(sum::addAndGet);
        int sum = 0;
        for (Integer x : nums) { sum += x; }
        System.out.println("The sum of your numbers is " + sum);
//        AtomicInteger product = new AtomicInteger(1);
//        nums.forEach(x -> product.updateAndGet(v -> v * x));
        int product = 1;
        for (Integer x : nums) { product*= x; }
        System.out.println("The product of your numbers is " + product);
        int min = Collections.max(nums);
        System.out.println("Your lowest number is " + min);
        int max = Collections.min(nums);
        System.out.println("Your highest number is " + max);
    }

    private static void carDealer() {
        Scanner input = new Scanner(System.in);
        HashMap<String, String> carLot = new HashMap<>();
        carLot.put("Civic", "Honda");
        carLot.put("Focus", "Ford");
        carLot.put("Altima", "Nissan");
        carLot.put("Cherokee", "Jeep");
        carLot.put("Elantra", "Hyundai");
        carLot.put("Breeze", "Plymouth");

        System.out.println("What model of car would you like?");
        String request = input.next();
        if (carLot.containsKey(request)) {
            System.out.println(String.format("Oh, you're looking for a %s? Our %s selection is right this way.",
                    request,
                    carLot.get(request)
            ));
        } else {
            System.out.println(String.format("I'm sorry we don't seem to have a %s at this location.", request));
            System.out.println("Let me see if I can find you one at another of our locations.");
        }
    }
}