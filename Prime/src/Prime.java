public class Prime {
    public static void main(String[] args) {
        printPrimeUpTo(100);
        printPrimeClassBetween(1900, 2100);
    }

    private static void printPrimeUpTo(int limit){
        for (int i = 1; i <= limit; i++){
            if (isPrime(i)) System.out.println(i + " is Prime");
        }
    }

    private static void printPrimeClassBetween(int start, int end){
        for(int i = start; i<= end; i++){
            if (isPrimeClass(i)) System.out.println("Class of " + (i+4) + " is a Prime Class");
        }
    }

    private static boolean isPrime(int input){
        if (input <= 3) { return input > 1; }
        else if (input % 2 == 0 || input % 3 == 0) { return false; }
        int i = 5;
        while (i * i <= input) {
            if (input % i == 0 || input % (i + 2) == 0) { return false; }
            i = i + 6;
        }
        return true;
    }

    private static boolean isPrimeClass(int input) {
        return isPrime(input) && isPrime(input+4);
    }
}
