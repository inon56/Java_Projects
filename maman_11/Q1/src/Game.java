/*
The Game class is created from the Main class, this is where most of the action happen
including start a new game and connecting with the class DynamicWord
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    ArrayList<Character> leftLetters;
    int numOfGuesses = 0;
    boolean finished = false;
    Scanner scanner = new Scanner(System.in);
    char ch;
    String answer = "no";
    String input;
    DynamicWord word;
    boolean rematch = true;

    public Game()
    {
        leftLetters = new ArrayList<Character>(Arrays.asList(
                'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w','x' ,'y','z'));
        word = new DynamicWord(Dictionary.getRandomWord());
    }
    public void play()
    {
        startNewGame();
        while (rematch)
        {
            System.out.println("Do you want to play again? please enter yes/no: ");
            answer = scanner.nextLine();
            if(answer.equals("yes")) {
                new Game();
                startNewGame();
            }
            else {
                System.out.println("Thank you for playing, see you next time!");
                break;
            }
        }
    }

    public void startNewGame()
    {
        while(true)
        {
            System.out.println("Please enter a char from the offered chars: ");
            System.out.println(leftLetters);
            //ch = scanner.next().charAt(0);
            input= scanner.nextLine();
            if(input.length() != 1) {
                System.out.println("To many letters");//maybe i should put this check in the method below
                continue;
            }
            ch = input.charAt(0);
            if (!VerifyInputLetter(ch))
            {
                System.out.println("the input letter already been entered, or is not valid.");
                System.out.println();
                System.out.println(word.GetCurrentWord());
                continue;
            }
            leftLetters.remove((Object)ch);
            word.setLetter(ch);
            System.out.println(word.GetCurrentWord());
            numOfGuesses++;
            if(word.IsWordCompleted())
            {
                break;
            }
        }
        System.out.println("you guessed all letters!, num of guesses: " + numOfGuesses);
    }

    private boolean VerifyInputLetter(char input)
    {

        return leftLetters.contains(input);
    }
}
