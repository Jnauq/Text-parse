package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Parses through a text file storing unique words and their frequencies
 * into an Arraylist of type Word.  Prints the top N most frequent words
 * and their frequency.
 * 
 * @author Justin Quan, Set B
 * @version 1.0
 */
public class WordCounter {
    /** The top 10 elements in the ArrayList. */
    private static final int TEN = 10;
    /** An ArrayList of type Word. */
    private ArrayList<Word> list;
    /** An ArrayList of type String. */
    private ArrayList<String> stringList;

    /** 
     * Parses through a text file to store and keep track of the words and
     * their frequency.  The words and their frequency as objects within an 
     * ArrayList sorted by descending frequency.  Returns the total number 
     * of unique words stored in the list.
     * 
     * @param file
     *            the location of the external file as a String 
     * @throws FileNotFoundException 
     * @return number of unique words as an int
     */
    public int parseBook(String file) throws FileNotFoundException {
        int uniqueWord = 0;
        
        list = new ArrayList<Word>();
        stringList = new ArrayList<String>();
        Scanner sc = new Scanner(new File(file));
        
        while (sc.hasNext()) {
            String temp = sc.next().toLowerCase();
            String tempReplaced = 
                    temp.replaceAll("[^a-z]", "");
            
            if (stringList.contains(tempReplaced)) {
                int index = stringList.indexOf(tempReplaced);
                list.get(index).plusOne();
                            
            } else {
                if (!tempReplaced.isEmpty()) {
                    stringList.add(tempReplaced);
                    Word currentWord = new Word(tempReplaced);
                    list.add(currentWord);
                    uniqueWord++;
                }
            }
        }

        sc.close();
        Collections.sort(list);
        Collections.reverse(list);
        return uniqueWord; 
    }

    /**
     * Prints the top n words ranked by frequency.
     * 
     * @param n 
     *            the top n words from the list to be printed as int
     * 
     */
    public void printTopWord(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i));
        }
    }
    
    /**
     * Drives the program.
     *
     * @throws FileNotFoundException 
     * @param args command line arguments.
     */
    public static void main(String[] args) throws FileNotFoundException {
        WordCounter myWC = new WordCounter();
        
        int uniqueWords = myWC.parseBook("bible.txt");
        System.out.println("Total unique words: " + uniqueWords);
        
        myWC.printTopWord(TEN);
        
        System.out.println("Question one was called and ran sucessfully.");
    }

}
