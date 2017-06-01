import java.awt.GridLayout;

import javax.swing.*;

public class WordGUI {

	JFrame jframe;
	JList unsorted;
	JList sorted;
	DefaultListModel unsortedList;
	DefaultListModel sortedList;

	public WordGUI(Word[] unsortedArray, Word[] sortedArray) {
		// Frame
		jframe = new JFrame("Project 1 - Amzad Chowdhury");
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
		populateList(unsortedArray, unsortedList);
		
		// Right Side - Sorted Words
		sortedList = new DefaultListModel();
		sortedList.addElement("Sorted");
		populateList(sortedArray, sortedList);

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
	public void populateList(Word[] wordArray, DefaultListModel list) {
		boolean flag = false;
		for (int i = 0; flag == false; i++) {
			if (wordArray[i] == null) {
				flag = true;
			} else {
				list.addElement(wordArray[i].word);
			}

		}

	}
}
