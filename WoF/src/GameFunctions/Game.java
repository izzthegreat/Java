package GameFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<String> wheel = new ArrayList<>();
    private static ArrayList<Puzzle> puzzleList = new ArrayList<>();
    private static ArrayList<Integer> puzzleOrder = new ArrayList<>();
    private static ArrayList<Player> playerList = new ArrayList<>();
    private static Puzzle currentPuzzle;
    private static Player currentPlayer;
    private static int wheelIndex, puzzleIndex, playerIndex;

    private static void loadPuzzle() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Puzzles.txt"));
        int lines = Integer.valueOf(reader.readLine());
        for(int i = 0; i < lines; i++) {
            String tmp = reader.readLine().toUpperCase();
            String category = tmp.substring(0, tmp.indexOf(':'));
            String puzzleString = tmp.substring(tmp.indexOf(':') + 1);
            char[] revealedPuzzle = puzzleString.toCharArray();
            Puzzle newPuzz = new Puzzle(category,revealedPuzzle);
            puzzleList.add(newPuzz);
        }
    }

    private static void loadWheel() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Wheel.txt"));
        for(int i = 0; i < 24; i++) {
            wheel.add(reader.readLine());
        }
    }

    public static void newGame(){
        try {
            loadWheel();
        } catch (IOException e) {
            System.out.println("Error: Couldn't read wheel file.");
            exitGame();
        }
        try {
            loadPuzzle();
        } catch (IOException e) {
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
        char morePlayers;
        do{
            System.out.println("Please enter player name");
            String name = input.next();
            Player newPlayer = new Player(name);
            playerList.add(newPlayer);
            System.out.println("Would you like to add another player?");
            morePlayers = input.next().toUpperCase().charAt(0);
        } while(morePlayers=='Y');
        playerIndex = (int)Math.floor(Math.random()*playerList.size());
        currentPlayer = playerList.get(playerIndex);
        playTurn();
    }

    private static void playTurn(){
        System.out.println("It's " + currentPlayer.getName() + "'s turn!");
        currentPuzzle.printStatus();
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
            }
        } while (menuChoice < 1 || menuChoice > 4);
        switch (menuChoice){
            case 1:
                spinTheWheel();
                break;
            case 2:
                System.out.println("Enter a vowel.");
                int count = currentPuzzle.buyAVowel();
                if (count == 0){
                    Game.finishTurn();
                } else {
                    playTurn();
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
        int strength = (int)Math.ceil((Math.random() * 24) + 48);
        for(int i = 0; i < strength; i++) {
            if (wheelIndex<wheel.size() - 1)wheelIndex += 1;else wheelIndex = 0;
            currentSpace = wheel.get(wheelIndex);
            System.out.print("\r" + currentSpace);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
        int count = 0;
        switch (currentSpace){
            case "BANKRUPT":
                currentPlayer.setWallet(0);
            case "LOSE A TURN":
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
            playTurn();
        }
    }

    static void finishTurn() {
        if(playerIndex == playerList.size()-1) playerIndex = 0; else playerIndex++;
        currentPlayer = playerList.get(playerIndex);
        playTurn();
    }

    static void finishRound(){
        System.out.println("End of Round");
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
            currentPuzzle = puzzleList.get(puzzleIndex);
            if (playerIndex == playerList.size() - 1) {playerIndex = 0;} else {playerIndex++;}
            playTurn();
        } else finishGame();
    }

    private static void finishGame(){
        System.out.println("Final Scores");
        System.out.println("------------");
        Player winningPlayer = playerList.get(0);
        for (Player player: playerList) {
            System.out.println(player.getName() + "-" + player.getBank());
            if (player.getBank() > winningPlayer.getBank()) winningPlayer = player;
        }
        System.out.println(winningPlayer.getName() + " wins!!!");
        exitGame();
    }

    private static void exitGame(){ System.exit(0); }

    static ArrayList<Player> getPlayerList() { return playerList; }

    static Player getCurrentPlayer() { return currentPlayer; }
}