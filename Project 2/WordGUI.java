/**
 * CS212 - Project 2
 * @author Amzad Chowdhury
 */
import java.awt.GridLayout;
import javax.swing.*;

public class WordGUI {

	JFrame jframe;
	JList unsorted;
	JList sorted;
	DefaultListModel unsortedList;
	DefaultListModel sortedList;

	public WordGUI(WordList unsortedL, WordList sortedL) {
		// Frame
		jframe = new JFrame("Project 2 - Amzad Chowdhury");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(500, 300);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);

		// Layout
		GridLayout layout = new GridLayout();
		layout.setColumns(2);
		layout.setRows(1);
		jframe.setLayout(layout);

		// Left Side - Unsorted Words
		unsortedList = new DefaultListModel();
		unsortedList.addElement("Unsorted");
		populateList(unsortedL, unsortedList);
		
		// Right Side - Sorted Words
		sortedList = new DefaultListModel();
		sortedList.addElement("Sorted");
		populateList(sortedL, sortedList);

		// Add models to List
		unsorted = new JList(unsortedList);
		sorted = new JList(sortedList);

		// Add all elements to frame
		jframe.add(unsorted);
		jframe.add(sorted);
		
		// Show/Enable Frame
		jframe.setVisible(true);
	}
	
	// Populate listmodel with word array
	/**
	 * Populates the DefaultListModel with data elements from LinkedList
	 * @param wordList
	 * @param list
	 */
	public void populateList(WordList wordList, DefaultListModel list) {
		boolean flag = false;
		WordNode p = wordList.intNode;
		while (p.next != null) {
		    list.addElement(p.next.data);
		    p = p.next;
		}


	}
}
