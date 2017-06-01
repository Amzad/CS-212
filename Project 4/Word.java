/**
 * This class creates a Word object from a String object. It also outputs the data of the stored String in the Word object as well as compares them to other Word objects.
 */
import java.util.regex.*;

public class Word {
    static int WORD_SIZE = 3;
    String word;
    
    /** Constructor for the Word class. Checks if the input String is valid and throw an exception if otherwise.
     * @param word The input String.
     * @exception throws IllegalWordException if input is invalid.
     */
    public Word(String word) {
    	if (!isLegal(word)) {
    		throw new IllegalWord212Exception("Invalid word: ");
    	}
        this.word = word;
    }
    /** Returns true or false based on if the String matches the given Word_Pattern
     * @param w Input String
	 *
     */
    public boolean isLegal(String w) {
    	Pattern p;
    	Matcher m;
    	String Word_Pattern = "\\b[a-zA-Z]{3}\\b";
    	p = Pattern.compile(Word_Pattern);
    	m = p.matcher(w);
    	return m.matches();
    }

    /** Returns the string object stored in Word class.
     * @return String String object stored in Word class.
     * 
     */
    public String toString() {
        return word;
    }

    // returns negative number if first is < second
    // returns positive number if first > second
    // and zero if the same
    /** Compares two Word objects and returns the Word object which has a higher lexicographical value
     * @param other Word object that is being compared to.
     */
    public int compareToIgnoreCase(Word other) {
        int value = word.compareToIgnoreCase(other.word);
        return value;
    }

}
