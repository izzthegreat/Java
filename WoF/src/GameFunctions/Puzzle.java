package GameFunctions;

import java.util.ArrayList;
import java.util.Scanner;

public class Puzzle {
    private static Scanner input = new Scanner(System.in);
    private ArrayList<Character> hiddenPuzzle = new ArrayList<>(), unguessedLetters = new ArrayList<>(), vowels = new ArrayList<>(),consonants = new ArrayList<>();
    private char[] revealedPuzzle;
    private String category;
    private int letterValue;

    Puzzle(String category, char[] revealedPuzzle){
        this.category = category;
        this.revealedPuzzle = revealedPuzzle;
        for(char ltr: revealedPuzzle){ if (ltr == ' ') hiddenPuzzle.add(ltr); else hiddenPuzzle.add('-'); }
        for (int i=65; i<=90; i++) unguessedLetters.add((char)i);
        vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');
        for (char ltr:unguessedLetters) if (!vowels.contains(ltr))consonants.add(ltr);
    }

    void printStatus(){
        for (Player player:Game.getPlayerList())player.printStatus();
        System.out.println(this.category);
        for(char ltr: this.hiddenPuzzle) System.out.print(ltr);
        System.out.print("\n");
        System.out.println("Available letters: " + this.unguessedLetters);
    }

    int guessLetter(){
        char guess;
        int count=0;
        do {
            guess = input.next().toUpperCase().charAt(0);
            if (this.unguessedLetters.contains(guess) && this.consonants.contains(guess)) {
                this.unguessedLetters.remove(this.unguessedLetters.indexOf(guess));
                count = findLetters(guess, count);
            } else {
                System.out.println("Please choose an unused consonant");
                guess=' ';
            }
        }while (guess==' ');
        return count;
    }

    int buyAVowel(){
        char guess;
        int count=0;

        if (Game.getCurrentPlayer().getWallet()>=250) {
            do{
                guess=input.next().toUpperCase().charAt(0);
            if (this.unguessedLetters.contains(guess) && this.vowels.contains(guess)) {
                this.unguessedLetters.remove(this.unguessedLetters.indexOf(guess));
                Game.getCurrentPlayer().spendMoney(250);
                for (int i = 0; i < this.revealedPuzzle.length; i++) {
                    if (this.revealedPuzzle[i] == guess) {
                        count++;
                        this.hiddenPuzzle.set(i, this.revealedPuzzle[i]);
                    }
                }
                if (count == 0) {
                    System.out.println("There is no '" + guess + "' in the puzzle.");
                } else if (count == 1) {
                    System.out.println("There is " + count + " " + guess + " in the puzzle.");
                } else {
                    System.out.println("There are " + count + " " + guess + "'s in the puzzle.");
                }
            } else {
                System.out.println("Please choose an unused vowel");
                guess = ' ';
            }
        } while (guess == ' ');

        } else {
            System.out.println("Not enough money");
            count = -1;
        }
        return count;
    }

    void solve(String solution){
        String solvedPuzzle = "";
        for(char ltr:this.revealedPuzzle) solvedPuzzle=solvedPuzzle+ltr;
        if (solvedPuzzle.equals(solution.toUpperCase())) {
            System.out.println(solvedPuzzle);
            System.out.println(Game.getCurrentPlayer().getName() + " Wins with $" + Game.getCurrentPlayer().getWallet() + "!");
            Game.getCurrentPlayer().walletToBank();
            Game.finishRound();
        } else {
            System.out.println("Nice try, but no...");
            Game.finishTurn();
        }
    }

    void freePlay(){
        int count=0;
        char guess;
        do {
            guess = input.next().toUpperCase().charAt(0);

            if (this.unguessedLetters.contains(guess)) {
                this.unguessedLetters.remove(this.unguessedLetters.indexOf(guess));
                if (this.vowels.contains(guess)) {
                    letterValue = 0;
                }
                count = findLetters(guess, count);
            } else {
                System.out.println("Please choose an unused letter");
                guess = ' ';
            }
        } while (guess == ' ');
    }

    private int findLetters(char guess, int count) {
        for (int i = 0; i < this.revealedPuzzle.length; i++) {
            if (this.revealedPuzzle[i] == guess){
                count++;
                this.hiddenPuzzle.set(i, this.revealedPuzzle[i]);
                Game.getCurrentPlayer().gainMoney(letterValue);
            }
        }
        if (count == 0){
            System.out.println("There are no " + guess + "'s in the puzzle.");
        } else if(count == 1){
            System.out.println("There is " + count + " " + guess +" in the puzzle." );
        }else{
            System.out.println("There are " + count + " " + guess +"'s in the puzzle." );
        }
        return count;
    }

    ArrayList<Character> getHiddenPuzzle() {
        return hiddenPuzzle;
    }

    void setLetterValue(int letterValue) {
        this.letterValue = letterValue;
    }
}