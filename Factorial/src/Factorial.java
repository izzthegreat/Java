public class Factorial {
    public static void main(String[] args) {

    }

    private static int factor(int input) {
        if (input == 0) {
            return 1;
        } else {
        return input*factor(input-1);
        }
    }
}