/*
 * This class creates the WordNodes to be used with the linked lists.
 */
public class WordNode {
    protected Word data;
    protected WordNode next;
   
    /*
     * Instantiates the WordNode object for use.
     * @Param word
     */
    public WordNode (Word word) {
        data = word;
        next = null;
        
    }
}
