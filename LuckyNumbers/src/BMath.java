public class BMath {

    // Creates Random Number Between "1" and "max"
    static int randomNum (int max) {
        return (int) Math.ceil(Math.random() * max);
    }
    //Creates Empty Array of "length" Length
    static int[] newNumArr (int length) {
        return new int[length];
    }
}
