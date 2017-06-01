/**
 * This class adds WordNode objects to a linked list.
 */

public class UnsortedWordList extends WordList {
	
	/**
     * Appends a WordNode data element to this LinkedList
     * @param word Word object that is being appended into a WordNode.
     */
    public void add(Word word) {
        WordNode temp = new WordNode(word);
        last.next = temp;  
        last = temp;
        length++;
        }
    

}
