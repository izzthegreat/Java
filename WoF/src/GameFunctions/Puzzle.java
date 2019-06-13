package GameFunctions;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.*;

import static javax.sound.sampled.AudioSystem.getClip;

public class Puzzle {
    private static Scanner input = new Scanner(System.in);
    private ArrayList<Character> hiddenPuzzle = new ArrayList<>(), unguessedLetters = new ArrayList<>(), vowels = new ArrayList<>(),consonants = new ArrayList<>();
    private char[] revealedPuzzle;
    private String category;
    private int letterValue;
    private Clip audio;

    Puzzle(String category, char[] revealedPuzzle){
        this.category = category;
        this.revealedPuzzle = revealedPuzzle;
        for (int i=65; i<=90; i++) unguessedLetters.add((char)i);
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');
        for (char ltr: unguessedLetters) if (!vowels.contains(ltr))consonants.add(ltr);
        for (char ltr: revealedPuzzle){ if (unguessedLetters.contains(ltr)) { hiddenPuzzle.add('\u25ae'); } else { hiddenPuzzle.add(ltr); } }
        try { audio = getClip(); } catch (Exception e) { e.printStackTrace(); }
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
                        letterDing();
                        count++;
                        this.hiddenPuzzle.set(i, this.revealedPuzzle[i]);
                    }
                }
                if (count == 0) {
                    letterBuzzer();
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

    void letterBuzzer() {
        try {
            audio.open(AudioSystem.getAudioInputStream(new File("audio/Buzzer.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        audio.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        audio.close();
    }

    private void letterDing(){
        try {
            audio.open(AudioSystem.getAudioInputStream(new File("audio/Ding.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        audio.start();
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        audio.close();
    }

    void solve(String solution){
        String solvedPuzzle = "";
        for(char ltr:this.revealedPuzzle) solvedPuzzle=solvedPuzzle+ltr;
        if (solvedPuzzle.equals(solution.toUpperCase())) {
            System.out.println(solvedPuzzle);
            System.out.println(Game.getCurrentPlayer().getName() + " Wins with $" + Game.getCurrentPlayer().getWallet() + "!");
            try {
                audio.open(AudioSystem.getAudioInputStream(new File("audio/PuzzleSolve.wav")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            audio.start();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            audio.close();
            Game.getCurrentPlayer().walletToBank();
            Game.finishRound();
        } else {
            System.out.println("Nice try, but no...");
            letterBuzzer();
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
        try {
            audio = getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < this.revealedPuzzle.length; i++) {
            if (this.revealedPuzzle[i] == guess){
                letterDing();
                count++;
                this.hiddenPuzzle.set(i, this.revealedPuzzle[i]);
                Game.getCurrentPlayer().gainMoney(letterValue);
            }
        }
        if (count == 0){
            letterBuzzer();
            System.out.println("There are no " + guess + "'s in the puzzle.");
        } else if(count == 1){
            System.out.println("There is " + count + " " + guess +" in the puzzle." );
        }else{
            System.out.println("There are " + count + " " + guess +"'s in the puzzle." );
        }
        return count;
    }

    void setLetterValue(int letterValue) { this.letterValue = letterValue; }

    boolean hasConsonants(){
        for(char ltr: consonants) {
            if (unguessedLetters.contains(ltr)) return true;
        }
        return false;
    }

    boolean hasVowels(){
        for (char ltr: vowels) {
            if (unguessedLetters.contains(ltr)) return true;
        }
        return false;
    }
}