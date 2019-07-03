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

    // Load each puzzle into a Puzzle Object and add to an ArrayList of puzzles
    private static void loadPuzzle() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("PlatinumPuzzles.txt"));
        int lines = Integer.valueOf(reader.readLine());
        for(int i = 0; i < lines; i++) {
            String tmp = reader.readLine().toUpperCase();
            String category = tmp.substring(0, tmp.indexOf(':'));
            String puzzleString = tmp.substring(tmp.indexOf(':') + 1);
            char[] revealedPuzzle = puzzleString.toCharArray();
            puzzleList.add(new Puzzle(category,revealedPuzzle));
        }
    }

    // load the wheel file into an ArrayList
    private static void loadWheel() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Wheel.txt"));
        for(int i = 0; i < 24; i++) {
            wheel.add(reader.readLine());
        }
    }

    // Game set-up method
    public static void newGame() {
        //Intro fanfare
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
        // Main menu music
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

        // Load the puzzle and wheel files
        try { loadWheel(); } catch (IOException e) {
            System.out.println("Error: Couldn't read wheel file.");
            exitGame();
        }
        try { loadPuzzle(); } catch (IOException e) {
            System.out.println("Error: Couldn't read puzzle file.");
            exitGame();
        }

        // Select 3 random puzzles for this game
        while (puzzleOrder.size() < 3){
            int index = (int)Math.floor(Math.random()*puzzleList.size());
            if (!puzzleOrder.contains(index)) puzzleOrder.add(index); // This line prevents duplicate puzzles
        }
        wheelIndex = 0; // Sets the wheel to start at the beginning
        puzzleIndex = 0; // Chooses the first puzzle...
        // ...and move it to the currentPuzzle so it can be used for the current (in this case, first) round
        currentPuzzle = puzzleList.get(puzzleOrder.get(puzzleIndex));
        int numOfPlayers = 0;

        // Check for number of players
        // (Currently no max)
        do {
            try{
                System.out.println("How many are playing?");
                numOfPlayers = input.nextInt();
            }catch(Exception e){
                System.out.println("Please enter a positive integer.");
                input = new Scanner(System.in);
            }
        } while (numOfPlayers <= 0);

        // Get player names until you reach the number provided.
        for(int i=0;i<numOfPlayers;i++){
            System.out.println("Please enter player name");
            String name = input.next();
            playerList.add(new Player(name));
        }

        // Choose a random starting player for the first round
        playerStartIndex = (int)Math.floor(Math.random()*playerList.size());
        playerIndex = playerStartIndex;
        currentPlayer = playerList.get(playerIndex);

        // Print out the current scores and puzzle
        currentPuzzle.printStatus();
        revealPuzzleSound();

        // Begin the first turn
        System.out.println("It's " + currentPlayer.getName() + "'s turn!");
        playTurn();
    } // End newGame method

    // Turn menu method
    private static void playTurn() {
        // Provide menu options
        int menuChoice = 0;
        do {
            try {
                System.out.println("1. Spin the Wheel");
                System.out.println("2. Buy a Vowel");
                System.out.println("3. Solve the Puzzle");
                System.out.println("4. Quit the Program");
                System.out.println("What do you want to do? (1-4):");
                menuChoice = input.nextInt(); //Check for menu input

                if (menuChoice < 1 || menuChoice > 4) System.out.println("Please enter a valid menu option.");
            } catch (Exception e) { // Validate that input IS a number
                System.out.println("Please enter a number. (1-4)");
                input = new Scanner(System.in); // Clear the input scanner
                currentPuzzle.printStatus();
            }
            // Validate that number entered is between 1 & 4
            // If not return to the menu
        } while (menuChoice < 1 || menuChoice > 4);
        switch (menuChoice){
            case 1: // Spin
                // Only allow option 1 if consonants remain in the letter bank
                if (currentPuzzle.hasConsonants()) spinTheWheel();
                else {
                    currentPuzzle.letterBuzzer();
                    System.out.println("There are no remaining consonants. Please select another option.");
                    continueTurn(); // If there are no consonants, return to main menu.
                }
                break;

            case 2: // Vowel
                // Only allow option 2 if vowels remain in the letter bank
                if (currentPuzzle.hasVowels()) {
                    System.out.println("Enter a vowel.");
                    int count = currentPuzzle.buyAVowel();
                    if (count == 0) { // If there were none of the letter guessed, turn ends
                        Game.finishTurn();
                    } else {
                        continueTurn(); // If you guessed correctly, return to the menu
                    }
                } else {
                    currentPuzzle.letterBuzzer();
                    System.out.println("There are no remaining vowels. Please select another option.");
                    continueTurn(); //If there are no vowels, return to the menu
                }
                break;

            case 3: // Solve
                System.out.println("Enter your guess. (Spelling matters...)");
                input.useDelimiter("\n");
                currentPuzzle.solve(input.next());
                input.reset();
                break;

            case 4: // Exit
                System.out.println("Thanks for playing");
                exitGame();
                break;
        }
    } // End playTurn method

    // Wheel mechanism method
    private static void spinTheWheel() {
        String currentSpace = "";

        // Spin distance is randomized w/ minimum of 3 full rotations
        int strength = 72 + (int)Math.ceil(Math.random() * 24);
        try {
            audio.open(AudioSystem.getAudioInputStream(new File("audio/WheelSpin.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        audio.start();
        // Iterate through the wheel based on spin strength
        for(int i = 0; i < strength; i++) {
            // When it reaches the end of the arrayList, loop around to index 0
            if (wheelIndex<wheel.size() - 1)wheelIndex += 1;else wheelIndex = 0;
            currentSpace = wheel.get(wheelIndex);
            // "\r" returns the cursor to the beginning of the current line allowing for reprint in the same space
            System.out.print("\r" + '\u25b6' + currentSpace);
            try { // Slow it down to make the iteration visible
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        audio.close();

        // Start a new line after the wheel spin
        System.out.println("\n");

        int count = 0;
        switch (currentSpace){
            case "BANKRUPT":
                try { // Play Bankrupt sound
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

                currentPlayer.bankrupt(); // Current player looses all of heir money
                finishTurn(); // Move to the next player
                break;

            case "LOSE A TURN":
                currentPuzzle.letterBuzzer(); // Buzzer sound
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finishTurn(); // Move to the next player
                break;

            case "FREE PLAY": // Special Space:
                // On a Free Play all consonants are worth $500, vowels are free,
                // and you get another spin/guess even if you're wrong
                currentPuzzle.setLetterValue(500);
                System.out.print("Enter a letter:");
                currentPuzzle.freePlay();
                count = -1;
                break;

            default: //THis is for all numeric spin values
                currentPuzzle.setLetterValue(Integer.valueOf(currentSpace.substring(1)));
                System.out.print("Enter a letter:");
                count = currentPuzzle.guessLetter();
        }
        if (count == 0){ // Check to see how many letters were revealed
            finishTurn(); // If none, move to next player
        } else {
            continueTurn(); // If at least one letter is revealed go back to the menu
        }
    } // End spinTheWheel method

    // Return to the main menu without switching players
    private static void continueTurn() {
        currentPuzzle.printStatus();
        playTurn();
    }

    // Advance to the next player
    static void finishTurn() {
        if(playerIndex == playerList.size()-1) playerIndex = 0; else playerIndex++;
        currentPlayer = playerList.get(playerIndex);
        currentPuzzle.printStatus();
        System.out.println("It's " + currentPlayer.getName() + "'s turn!");
        playTurn();
    }

    // Advance to the next puzzle
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
        for (Player each: playerList) each.bankrupt(); // Set each players wallet to 0
        if (puzzleIndex < 2) { // If its not the end of round 3
            puzzleIndex++; // Advance to the next Puzzle
            currentPuzzle = puzzleList.get(puzzleOrder.get(puzzleIndex));

            // Advance the starting player
            if (playerStartIndex == playerList.size() - 1) {playerStartIndex = 0;} else {playerStartIndex++;}
            playerIndex = playerStartIndex;

            // Make the new starting player the current player
            currentPlayer = playerList.get(playerIndex);

            // Reveal the new puzzle
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

    // Exits the program
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