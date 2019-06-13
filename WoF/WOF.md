# GameFunctions.Game Play
The following is just a short little description of Wheel of Fortune.

# GameFunctions.Game Basics

- The game supports as many players as you want, `(n)` Players
- The game is played in a sequence of rounds.
- A first player and a player rotation order is chosen, and the players rotate who begins on each successive  round.
- Each player maintains an temporary dollar amount for the current round, which is initially zero.
- Each player maintains an ongoing grand total dollar amount, which is initially zero.
- Every round, the players have a chance to increase their grand total dollar amount.
- The object of the game is to make as much money as possible. That is to say every player's goal is to maximize their grand total dollar amount.

# Puzzles

  - At the start of each game, a preexisting bank of puzzles is chosen.
  - Each puzzle has an associated category (or class). For example, phrase, classic tv, movie title, before and after, same name, etc.
  - The puzzle itself is one or more words that is simply an example (an instance) of the category.

# Wheels

  - At the start of the game, a preexisting wheel is chosen with which to play.
  - A wheel element can either be positive dollar amount elements, lose-a-turn elements, or bankrupt elements.
  - Wheels must contain at least one element.
  - There is no presumed "order" of wheel elements.
  - All wheel amount are whole dollar amounts.

# Rounds

  - Several successive rounds constitute one entire game.
  - A word puzzle is randomly chosen from the preexisting puzzle bank.
  - The puzzle category is displayed as a puzzle hint.
  - Initially, the puzzle is displayed such that all actual letters in the puzzle are hidden, but placemarkers for the letters are clearly visible, as are divisions between words.
  - Initially, all alphabetic consonants are displayed, as well as the vowels. The letter y counts as a consonant. As these letters are chosen they will be removed.
  - All wheel elements are shown to the players.
  - The players all receive a temporary dollar amount, which is initially zero, and displayed next to the players' names.

# Turns

  - Every player, when it is their turn, has the opportunity to reveal more letters of or outright solve the puzzle.
  - If a player, for any reason, fails to either to continue reveal the letters of or solve the puzzle, then that player's turn ends.
  - A player, on their turn, has four options
    quit the game solve the puzzle spin the wheel buy a vowel

# Trying To Solve A GameFunctions.Puzzle

  - If a player chooses to solve the puzzle, then they are given a chance to guess what the complete puzzle is.
  - If the player guesses incorrectly, the player's turn is over.
  - If the player guesses correctly, then that player's grand total dollar amount is increased by their temporary dollar amount, and the round is over.

# Buying A Vowel

  - Revealing all occurrences of one vowel in the puzzle costs money (called "buying a vowel").
  - The cost of buying a vowel is $50 and this amount must be subtracted from the player's temporary dollar amount.
  - When a player chooses to buy a vowel, they are immediately asked what vowel they would like to purchase.
  - If a player attempts to buy a vowel when their temporary dollar amount is less than the cost of buying a vowel, their turn ends without any change in that player's temporary dollar amount or the revealed puzzle.
  - If a player attempts to buy a vowel that does not exist, they pay for the vowel, but their turn ends.
  - If a player, upon being asked what vowel to buy, asks to buy a consonant (or any other non-vowel), their turn ends without any change in that player's temporary dollar amount or the revealed puzzle.
  - If a player buys a vowel that occurs at least once in the puzzle, and they have sufficient money to do so, then all occurrances of that vowel are revealed, that letter is removed from the vowels list, the player's temporary dollar amount is lessened the amount of a vowel purchase, and it is still that player's turn.

# Spinning

  - If a player chooses to spin the wheel, then a random element of the wheel is chosen for that player.
  - If the element chosen is a lose-a-turn element, then that player's turn ends.
  - If the element chosen is a bankrupt element, then that player's temporary dollar amount is reduced or reset to 0, and that player's turn ends.
  - If the element is a dollar amount, then the player is allowed to choose a consonant.
  - If the letter chosen does not occur in the puzzle, or if the letter chosen was not a consonant, or if the letter has already been chosen that round, then that player's turn ends.
  - If the chosen consonant has not yet been chosen and does occur in the puzzle, then the player's temporary dollar amount in increased by the product of the wheel dollar amount spun and the number of occurrences of that letter in the puzzle. Those letters are revealed and taken from the consonant list, and it is still that player's turn. 

# Program Requirements Specification

# Files and Their Formats

To begin the game, you will prompt for the names of 2 files: a wheel configuration file and a puzzle file. You should read in these files and the populate the wheel with the values in the file.

A specified file format has been provided for you. You can view Samples for each format. These are only samples! We will be using many files of the same format to test your programs. You will want to create your own specialized wheel and puzzle files to test different aspects of your game play.

GameFunctions.Puzzle List - The first line in this file indicates the number puzzles contained in the file.
Wheel configuration file - The first line in this file indicates the number of wheel values contained in the file.

# Files

The wheel configuration file will consist of positive numerical integers and special words to represent bankrupt and lose-a-turn elements. The bankrupt elements will be represented by the case-insensitive letters "bankrupt", and the lose-a-turn elements will be represented by the case-insensitive letters "lose_turn".

The puzzle file will consist of a new puzzle on every line, and the format is that the category will appear first (again, case-insensitive), follwed by a ':' character delimiter, followed by the (case-insensitive) words of the puzzle. Only the alphabetic letters and spaces are allowed. We will not require you to handle dashes, apostrophes, commas, or any other punctuation. Finally, to make reading in these files easier, the first line of each file will contain the number of following lines contained in that file.

If, for any reason, the files that your program attempt to read in are in an incorrect format, then simply report the error as such and gracefully exit the program. 

# Players

Every Wheel of Fortune game will have three players. Prompt for the names of these players, and then begin the game. 

# Menu Options

When it is a player's turn, that player should be prompted with a menu of their choices:

    0 to quit the game
    1 to solve the puzzle
    2 to spin the wheel
    3 to buy a vowel

If the player chooses 0, gracefully quit the game after showing the grand totals for that game.

If the player chooses 1, they will be given the chance to solve the puzzle. If they are correct, they win the round and their grand total is appropriately updated. All other players do not have their grand totals added to, despite whatever temporary amounts they have accrued during that round. If the guess is wrong, the player's turn ends.

If the player chooses 2, the game should randomly select a value from the wheel. If the value is something other than BANKRUPT or LOSE_TURN, the player is given a chance to choose a consonant. You should prompt the player for their choice. If the letter they choose has been chosen before or is not in the puzzle, they lose their turn. Otherwise, for each occurrence of the letter in the puzzle, the player receives the dollar amount of their spin. The player then continues their turn, starting again at the menu above.

If the player chooses 3, $50 should be deducted from their temporary dollar amounts and they should be prompted for a vowel. If that vowel is in the puzzle, the player continues their turn. Otherwise, they lose their turn.

If the player chooses an option that is not possible (for example, trying to spin the wheel when there are no consonants left in the puzzle, or trying to buy a vowel when there are none left, or trying to buy a vowel when the player does not have enough money ), they should lose their turn. 

# Ending a Round or the GameFunctions.Game

The round ends when any player selects quit or when the puzzle is guessed correctly. Update all numbers as appropriate, and prompt the user if they want to play again. If yes, start a new game with the same wheel and a new puzzle from the same puzzle bank. If no more puzzles exist in the puzzle bank, then the game should print out a message saying exactly that, and then act as if option 0 had been selected. Note that this means that puzzles should not repeat within any one game. 

# Output

Your output format must match the format show in the game play samples. (NOTE: It has been updated to show the Grand Totals 5/3/3)

Use UPPER CASE lettering for the hint, puzzle, consonant list, and vowels list, regardless of how the puzzles were stored in the puzzle file.

Leave a space between all letters of any word in a puzzle, and at least three spaces between words.

Hidden letters should be represented by the underscore '_' character. 

# Additional Program requirements

Your main class must be called WheelOfFortune and be in a source code file called WheelOfFortune.java (both are case-sensitive).
Remember to always print out the hint, the puzzle, the consonants and vowels lists, the wheel elements, the players and their money, and the current menu or prompt with a clear message.
Remember to follow the single-task object principle and write reusable objects.


Testing and Debugging
Throughout the coding process, you should test your code to make sure that each method you add works correctly. Even after your code is completed, you are still not done until you have thoroughly tested your program. Try to crash your program. It shouldn't let you. It should instead reprompt or gracefully exit if it is absolutely irrecoverable. (But your programs should never reach that point in the first place).

# Here are some things to test:

  - enter in letter when asked for numbers and number when asked for letters.
  - enter in a space before your input.
  don't enter in anything at prompts - just hit the return key.
  - provide incorrect filenames.
  - try to "buy consonants" and spin for vowels.
  edit the files to have different casing, for example, moVIe tItlE:ChICaGo
  - create a wheel configuration with only lose_turn or bankrupt elements.
  - create a puzzles file with only one puzzle on it. What happens after you solve it?
  create a puzzles file in an incorrect format. Does - it gracefully exit, or simply crash?
  - ask a friend to try to crash it.

## Here are some examples of things to test for if you get Exceptions:

  - NullPointerException -- Did you attempt to use an object before you defined it?
  - ArrayIndexOutOfBoundsException -- Check your loop exit conditions (are you off by one?)
  - NoSuchElementException -- Check your loop exit conditions (are you off by one?)
  - NumberFormatException -- Be sure you are properly tokenizing the input. Are you trying to turn a word (BANKRUPT) into a number?
  - FileNotFoundException -- Check your spelling and be sure you have set the Working directory correctly. If you are not sure how to do this, ask your TA.
  - IOException -- You may throw all IOExceptions except FileNotFoundException

#### This is only a short list of possible errors; you need to test for these and many others. 


# Useful Classes: What you will and won't need
Much of this program will rely upon good input/output to both the console and also various data files. Several standard JAVA classes work together in a fairly complex way to accomplish this. Use the following Java API classes to complete this program. Click on links below for Java API documentation.

Useful classes in the Java I/O package (import java.io.*):

    File
    FileReader
    BufferedReader
    PrintWriter

Useful classes in the Java util package: (import java.util.*):

    StringTokenizer

Useful objects (see the Java API documentation for System):

    System.out (PrintStream)
    System.in (InputStream)
