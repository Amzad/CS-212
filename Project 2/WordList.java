/** 
 * CS212 - Project 2
 * @author Amzad Chowdhury
 *
 */
public class WordList {
    WordNode intNode = new WordNode(null);
    private WordNode first = intNode;
    private WordNode last = intNode;
    private int length = 0;

    public WordList() {
        //first = null;
        //last = null;
        //length = 0;
    }
    
    /**
     * Appends a Word data element to this LinkedList
     * @param word Word object that is being appended
     */
    public void append(Word word) {
        WordNode temp = new WordNode(word);
        last.next = temp;  
        last = temp;
        length++;
        }
    
    /**
     * Inserts a Word data element in a sorted LinkedList
     * @param word Word object that is being inserted
     */
    public void insert(Word word) {
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
