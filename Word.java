/**
 * 
 */
package q1;

/**
 * Represents a word class.
 * 
 * @author Justin Quan, Set B
 * @version 1.0
 *
 */
public class Word implements Comparable<Word> {
    /** Stores the current word as a String. */
    private final String oneWord;
    /** Stores the frequency the word appears. */
    private int frequency;

    
    /**
     * Constructs an object of the String word with an initial frequency of 1.
     * 
     * @param wantedWord
     *            word to be searched as a String
     */
    public Word(String wantedWord) {
        oneWord = wantedWord;
        frequency = 1;
    }
    
    /**
     * Returns the word as a String.
     * 
     * @return word as a String
     */
    public String getWord() {
        return oneWord;
    }
    
    /**
     * Returns the frequency the word appears as an integer.
     * 
     * @return frequency as an int
     */
    public int getFrequency() {
        return frequency;
    }
    
    /**
     * Increments the frequency of the object by one.
     */
    public void plusOne() {
        frequency += 1;
    }
    
    /**
     * Compares two word objects and returns positive if object calling the
     * method has higher frequency, zero if same frequency and negative if
     * lower frequency.
     * 
     * @param anotherWord
     *            compared to word object
     * @return a positive one, negative one or zero as an integer
     */
    @Override
    public int compareTo(Word anotherWord) {
        if (this.getFrequency() > anotherWord.getFrequency()) {
            return 1;
        } else if (this.getFrequency() < anotherWord.getFrequency()) {
            return -1;
        } else {
            return 0;
        }

    }

    /**
     * A one-line description of the word and its frequency as a String.
     * 
     * @return toString description that returns the word and its frequency
     */
    public String toString() {
        return (oneWord + ", " + frequency);
    }
}
