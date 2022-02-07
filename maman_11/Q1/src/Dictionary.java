/*
Class Dictionary used mostly for static usage and contain the word storage
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
        static String[] wordsArray = {"hello","ready","java","dog","cat","kamikazi"};
        int randWord;

        public static String getRandomWord()
        {
            Random rand = new Random();
            int index = rand.nextInt(wordsArray.length);
            return wordsArray[index];
        }

}
