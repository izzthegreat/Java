import java.util.Scanner;

public class Roshambo {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");

        String pName1 = input.nextLine();
        String pName2 = "Computer";
        int pScore1 = 0;
        int pScore2 = 0;
        System.out.println("Let's play some Rock, Paper, Scissors.");
        while (pScore1 < 3 && pScore2 < 3) {
            String[] weapons = new String[]{"rock", "paper", "scissors"};
            int pWeapon1 = (int) Math.floor(Math.random() * weapons.length);
            int pWeapon2 = (int) Math.floor(Math.random() * weapons.length);
            String[][] plays = {{"Tie", pName2, pName1}, {pName1, "Tie", pName2}, {pName2, pName1, "Tie"}};
            String winner = plays[pWeapon1][pWeapon2];
            if (winner.equals(pName1)) {
                pScore1++;
            } else if (winner.equals(pName2)) pScore2++;
            System.out.println(pName1 + ": " + weapons[pWeapon1]);
            System.out.println(pName2 + ": " + weapons[pWeapon2]);
            System.out.println("Winner: " + winner);
            System.out.println("Score: " + pName1 + "-" + pScore1 + " to " + pName2 + "-" + pScore2);
        }
    }
}
