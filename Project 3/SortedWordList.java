/*
 * This class adds WordNode objects to a linked list.
 */

public class SortedWordList extends WordList {
	/**
     * Inserts a Word data element in a sorted LinkedList
     * @param word Word object that is being inserted
     */
    public void add(Word word) {
        WordNode temp = new WordNode(word);
        //Check if there is a first node
        if (first.next == null) { 
            last.next = temp;
            last = temp;
            length++;
            return;
        }
        
        // If existing nodes exist then continue
        WordNode node = first;
        
        // Find the new node.
        while (node.next != null && node.next.data.compareTo(word) < 0) {
            node = node.next;
        }
        
        // If node is last, insert.
        if (node.next == null) {
            last.next = temp;
            last = temp;
            length++;
        }
        // Move Existing Node and set new node
        else {
            temp.next = node.next;
            node.next = temp;
            length++;
        }
      
    }

}
