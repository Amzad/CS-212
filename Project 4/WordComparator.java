import java.util.Comparator;

/**
 * A class that compare two WordNodes.
 * 
 * Each object of this class does the exact same thing, but
 * you can't pass methods as parameters to other methods in Java.
 * You can, however, pass objects, and objects have their own methods... 
 * 
 */
public class WordComparator implements Comparator<Word> {

	public int compare(Word word1, Word word2) {
        return word1.compareToIgnoreCase(word2);
    }

}