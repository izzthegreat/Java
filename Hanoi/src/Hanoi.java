import java.util.Arrays;
import java.util.Stack;

public class Hanoi {
    private static Stack<String> tower1 = new Stack<>();
    private static Stack<String> tower2 = new Stack<>();
    private static Stack<String> tower3 = new Stack<>();
    private static Stack[] towers = {tower1,tower2,tower3};

    public static void main (String [] args){
            towers[0].push("Big Ring");
            towers[0].push("Medium Ring");
            towers[0].push("Small Ring");
            towerPeek();
            towers[2].push(towers[0].pop());
            towerPeek();
            towers[1].push(towers[0].pop());
            towerPeek();
            towers[1].push(towers[2].pop());
            towerPeek();
            towers[2].push(towers[0].pop());
            towerPeek();
            towers[0].push(towers[1].pop());
            towerPeek();
            towers[2].push(towers[1].pop());
            towerPeek();
            towers[2].push(towers[0].pop());
            towerPeek();
    }

    private static void towerPeek(){
        System.out.println(Arrays.toString(towers));
    }
}
