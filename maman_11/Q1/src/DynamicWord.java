/*
Class DynamicWord - contain the word methods
 */

import java.util.Arrays;

public class DynamicWord {

    String word; //initialized in constructor  e.g. house
    char[] currentWord; // initialized with underscores ____.  hold the current word. e.g. ho_s_
    int wordLength;


    public DynamicWord(String input)
    {
        word = input;
        currentWord = new char[input.length()];
        Arrays.fill(currentWord, '_');
        wordLength = input.length();
    }

    // check word:
    //  if letter is in  word - update currentWord and return true.
    // else - return false
    public boolean setLetter(char letter)
    {
        boolean found = false;
        for (int i = 0; i < wordLength; i++)
        {
            if(word.charAt(i) == letter)
            {
                currentWord[i] = letter;
                found = true;
            }
        }
        return found;
    }

    public char[] GetCurrentWord()
    {
        return currentWord;
    }

    //
    public boolean IsWordCompleted()
    {
        return String.valueOf(currentWord).equals(word);
    }
}
