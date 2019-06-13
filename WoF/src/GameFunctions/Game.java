package GameFunctions;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.sound.sampled.AudioSystem.getClip;

public class Game {

    private static Scanner input = new Scanner(System.in);
    private static Clip audio,intro;
    private static ArrayList<String> wheel = new ArrayList<>();
    private static ArrayList<Puzzle> puzzleList = new ArrayList<>();
    private static ArrayList<Integer> puzzleOrder = new ArrayList<>();
    private static ArrayList<Player> playerList = new ArrayList<>();
    private static Puzzle currentPuzzle;
    private static Player currentPlayer;
    private static int wheelIndex, puzzleIndex, playerIndex, playerStartIndex;

    private static void loadPuzzle() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("PlatinumPuzzles.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("AllTs.txt"));
        int lines = Integer.valueOf(reader.readLine());
        for(int i = 0; i < lines; i++) {
            String tmp = reader.readLine().toUpperCase();
            String category = tmp.substring(0, tmp.indexOf(':'));
            String puzzleString = tmp.substring(tmp.indexOf(':') + 1);
            char[] revealedPuzzle = puzzleString.toCharArray();
            puzzleList.add(new Puzzle(category,revealedPuzzle));
        }
    }

    private static void loadWheel() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Wheel.txt"));
        for(int i = 0; i < 24; i++) {
            wheel.add(reader.readLine());
        }
    }

    public static void newGame() {
        try { audio = getClip(); } catch (Exception e) { e.printStackTrace(); }
        try { intro = getClip(); } catch (Exception e) { e.printStackTrace(); }
        try {
            audio.open(AudioSystem.getAudioInputStream(new File("audio/ChantIntro.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            intro.open(AudioSystem.getAudioInputStream(new File("audio/WheelTheme.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        audio.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("WHEEL");
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(" OF ");
        try {
            Thread.sleep(1050);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FORTUNE");
        try {
            Thread.sleep(1700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        intro.loop(Clip.LOOP_CONTINUOUSLY);
        audio.close();
        System.out.println("--------------------");
        System.out.println("Press ENTER to start");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        intro.close();
        try { loadWheel(); } catch (IOException e) {
            System.out.println("Error: Couldn't read wheel file.");
            exitGame();
        }
        try { loadPuzzle(); } catch (IOException e) {
            System.out.println("Error: Couldn't read puzzle file.");
            exitGame();
        }
        while (puzzleOrder.size() < 3){
            int index = (int)Math.floor(Math.random()*puzzleList.size());
            if (!puzzleOrder.contains(index)) puzzleOrder.add(index);
        }
        wheelIndex = 0;
        puzzleIndex = 0;
        currentPuzzle = puzzleList.get(puzzleOrder.get(puzzleIndex));
        int numOfPlayers = 0;
        do {
            try{
                System.out.println("How many are playing?");
                numOfPlayers = input.nextInt();
            }catch(Exception e){
                System.out.println("Please enter a positive integer.");
                input = new Scanner(System.in);
            }
        } while (numOfPlayers <= 0);
        for(int i=0;i<numOfPlayers;i++){
            System.out.println("Please enter player name");
            String name = input.next();
            playerList.add(new Player(name));
        }
        playerStartIndex = (int)Math.floor(Math.random()*playerList.size());
        playerIndex = playerStartIndex;
        currentPlayer = playerList.get(playerIndex);
        currentPuzzle.printStatus();
        revealPuzzleSound();
        System.out.println("It's " + currentPlayer.getName() + "'s turn!");
        playTurn();
    }

    private static void playTurn() {
        int menuChoice = 0;
        do {
            try {
                System.out.println("1. Spin the Wheel");
                System.out.println("2. Buy a Vowel");
                System.out.println("3. Solve the Puzzle");
                System.out.println("4. Quit the Program");
                System.out.println("What do you want to do? (1-4):");
                menuChoice = input.nextInt();
                if (menuChoice < 1 || menuChoice > 4) System.out.println("Please enter a valid menu option.");
            } catch (Exception e) {
                System.out.println("Please enter a number. (1-4)");
                input = new Scanner(System.in);
                currentPuzzle.printStatus();
            }
        } while (menuChoice < 1 || menuChoice > 4);
        switch (menuChoice){
            case 1:
                if (currentPuzzle.hasConsonants()) spinTheWheel();
                else {
                    currentPuzzle.letterBuzzer();
                    System.out.println("There are no remaining consonants. Please select another option.");
                    continueTurn();
                }
                break;
            case 2:
                if (currentPuzzle.hasVowels()) {
                    System.out.println("Enter a vowel.");
                    int count = currentPuzzle.buyAVowel();
                    if (count == 0) {
                        Game.finishTurn();
                    } else {
                        continueTurn();
                    }
                } else {
                    currentPuzzle.letterBuzzer();
                    System.out.println("There are no remaining vowels. Please select another option.");
                    continueTurn();
                }
                break;
            case 3:
                System.out.println("Enter your guess. (Spelling matters...)");
                input.useDelimiter("\n");
                currentPuzzle.solve(input.next());
                input.reset();
                break;
            case 4:
                System.out.println("Thanks for playing");
                exitGame();
                break;
        }
    }

    private static void spinTheWheel() {
        String currentSpace = "";
        int strength = (int)Math.ceil((Math.random() * 24) + 72);
        try {
            audio.open(AudioSystem.getAudioInputStream(new File("audio/WheelSpin.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        audio.start();
        for(int i = 0; i < strength; i++) {
            if (wheelIndex<wheel.size() - 1)wheelIndex += 1;else wheelIndex = 0;
            currentSpace = wheel.get(wheelIndex);
            System.out.print("\r" + '\u25b6' + currentSpace);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        audio.close();
        System.out.println("\n");
        int count = 0;
        switch (currentSpace){
            case "BANKRUPT":
                try {
                    audio.open(AudioSystem.getAudioInputStream(new File("audio/Bankrupt.wav")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                audio.start();
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                audio.close();
                currentPlayer.setWallet(0);
                finishTurn();
                break;
            case "LOSE A TURN":
                currentPuzzle.letterBuzzer();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finishTurn();
                break;
            case "FREE PLAY":
                currentPuzzle.setLetterValue(500);
                System.out.print("Enter a letter:");
                currentPuzzle.freePlay();
                count = -1;
                break;
            default:
                currentPuzzle.setLetterValue(Integer.valueOf(currentSpace.substring(1)));
                System.out.print("Enter a letter:");
                count = currentPuzzle.guessLetter();
        }
        if (count == 0){
            finishTurn();
        } else {
            continueTurn();
        }
    }

    private static void continueTurn() {
        currentPuzzle.printStatus();
        playTurn();
    }

    static void finishTurn() {
        if(playerIndex == playerList.size()-1) playerIndex = 0; else playerIndex++;
        currentPlayer = playerList.get(playerIndex);
        currentPuzzle.printStatus();
        System.out.println("It's " + currentPlayer.getName() + "'s turn!");
        playTurn();
    }

    static void finishRound(){
        int roundNo = puzzleIndex+1;
        System.out.println("End of Round " + roundNo);
        System.out.println("------------");
        for (Player player:playerList){ System.out.println(player.getName() + " - $" + player.getBank()); }
        System.out.println("------------");
        input.nextLine();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Player each: playerList) each.setWallet(0);
        if (puzzleIndex < 2) {
            puzzleIndex++;
            currentPuzzle = puzzleList.get(puzzleOrder.get(puzzleIndex));
            if (playerStartIndex == playerList.size() - 1) {playerStartIndex = 0;} else {playerStartIndex++;}
            playerIndex = playerStartIndex;
            currentPlayer = playerList.get(playerIndex);
            currentPuzzle.printStatus();
            revealPuzzleSound();
            System.out.println("It's " + currentPlayer.getName() + "'s turn!");
            playTurn();
        } else finishGame();
    }

    private static void finishGame() {
        try {
            audio.open(AudioSystem.getAudioInputStream(new File("audio/WheelTheme.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        audio.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println("Final Scores");
        System.out.println("------------");
        Player winningPlayer = playerList.get(0);
        for (Player player: playerList) {
            System.out.println(player.getName() + "-" + player.getBank());
            if (player.getBank() > winningPlayer.getBank()) winningPlayer = player;
        }
        System.out.println(winningPlayer.getName() + " wins!!!");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        audio.close();
        exitGame();
    }

    private static void exitGame(){ System.exit(0); }

    private static void revealPuzzleSound(){
        try {
            audio.open(AudioSystem.getAudioInputStream(new File("audio/PuzzleReveal.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        audio.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        audio.close();
    }

    static ArrayList<Player> getPlayerList() { return playerList; }

    static Player getCurrentPlayer() { return currentPlayer; }
}