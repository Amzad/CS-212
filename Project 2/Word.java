
public class Word {
    static int WORD_SIZE = 3;
    String word;

    public Word(String word) {
        this.word = word;
    }

    // method for converting a string into a word
    public String toString() {
        return word;
    }

    // returns negative number if first is < second
    // returns positive number if first > second
    // and zero if the same
    public int compareTo(Word other) {
        int value = word.compareToIgnoreCase(other.word);
        return value;
    }

}
