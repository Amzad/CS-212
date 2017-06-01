/**
 * This class creates the base WordList class to be further used within a class hierarchy.
 */


public abstract class WordList {
	WordNode intNode = new WordNode(null);
    protected WordNode first = intNode;
    protected WordNode last = intNode;
    protected int length = 0;

    public WordList() {
    }
    
    
    /**
     * Returns the String data stored in the Node
     * @return
     */
    public String returnString() {
        WordNode p = first.next;
        String word = p.data.word;
        return word;
    

    }

}
