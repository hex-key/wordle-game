import java.util.*;
import java.io.*;

public class Wordle {
    public static void main (String[] args) {
        File file = new File("WordBase.txt");
        Scanner input = new Scanner(System.in);

        String pick = "";
        boolean guessed = false;

        //pick a word from the file
        try {
            pick = choose(file);
            } catch (FileNotFoundException e) {
            System.out.println("check file location");
        }

        char[] word = pick.toCharArray();
        String output = "_____";
        String guess;

        for (int tries = 0; tries < 6; tries++){ 
            System.out.println(output + "\n"); // print out the feedback 
            guess = input.nextLine().toUpperCase();

            while (guess.length() != 5) { // make sure its actually 5 letters
                System.out.print("Guess a 5 letter word b r u h ");
                guess = input.nextLine().toUpperCase();
            }

            char[] guessedWord = guess.toCharArray();
            output = "";

            // first check if they're equal
            if (guess.equals(pick)) {
                System.out.println("Congratulations! You got it in "+ (tries+1) + " tries!");
                guessed = true;
                break;
            }

            for (int i = 0; i < 5; i++) { //for each letter
                // check if they're the same and in the same place
                if (guessedWord[i] == word[i]) {
                    output += guessedWord[i];
                    output += "";
                } else {
                    boolean inWord = false;
                    for (char c : word) { //check if it's in the word at all
                        if (guessedWord[i] == c) {
                            output += "#";
                            inWord = true;
                            break;
                        }
                    }
                    // if it's not --
                    if (!inWord) output += "_";
                }
            } // end checking
        }
        if (!guessed) System.out.println("bad lmao the word was " + pick);
    }

    public static String choose(File f) throws FileNotFoundException {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for(Scanner sc = new Scanner(f); sc.hasNext(); ) {
            ++n;
            String line = sc.nextLine();
            if(rand.nextInt(n) == 0)
                result = line;
        }
        return result;
    }
}