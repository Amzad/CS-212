/*
 * This class creates a Word object from a String object. It also outputs the data of the stored String in the Word object as well as compares them to other Word objects.
 */

public class Word {
    static int WORD_SIZE = 3;
    String word;
    
    /* Constructor for the Word class. Checks if the input String is valid and throw an exception if otherwise.
     * @param word The input String.
     * @exception throws IllegalWordException if input is invalid.
     */
    public Word(String word) {
    	if (word.length() != WORD_SIZE) {
    		throw new IllegalWordException("Invalid Word: ");
    	}
    	for (int i = 0; i < WORD_SIZE; i++) {
			char x = word.charAt(i);
			if (!Character.isLetter(x)) throw new IllegalWordException("Invalid letter: ");
		}
        this.word = word;
    }

    /* Returns the string object stored in Word class.
     * @return String String object stored in Word class.
     * 
     */
    public String toString() {
        return word;
    }

    // returns negative number if first is < second
    // returns positive number if first > second
    // and zero if the same
    /* Compares two Word objects and returns the Word object which has a higher lexicographical value
     * @param other Word object that is being compared to.
     */
    public int compareTo(Word other) {
        int value = word.compareToIgnoreCase(other.word);
        return value;
    }

}
