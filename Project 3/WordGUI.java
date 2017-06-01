/**
 * CS212 - Project 3
 * This class creates the GUI and creates and processes the data received from a text file.
 * @author Amzad Chowdhury
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.*;

public class WordGUI extends JFrame{

	JFrame jframe;
	JList unsorted;
	JList sorted;
	JMenuBar menuBar;
	JMenu menu;
	DefaultListModel unsortedList;
	DefaultListModel sortedList;
	UnsortedWordList unsortedL = new UnsortedWordList();
	SortedWordList sortedL = new SortedWordList();

	/* 
	 * Constuctor for the WordGUI class. Create and adds visual elements into the GUI.
	 */
	public WordGUI() {

		// Frame
		jframe = new JFrame("Project 3 - Amzad Chowdhury");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(500, 300);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);

		// Layout
		GridLayout layout = new GridLayout();
		layout.setColumns(2);
		layout.setRows(1);
		jframe.setLayout(layout);
		
		// File Menu
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		
		// File Menu Handler
		FileMenuHandler fmh = new FileMenuHandler(this);
		
		
		// MenuBar - Create and Add Menu Items
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(fmh);
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(fmh);
		
		menu.add(openItem);
		menu.addSeparator();
		menu.add(quitItem);
		
		// Left Side - Unsorted Words
		unsortedList = new DefaultListModel();
		unsortedList.addElement("Unsorted");
		
		// Right Side - Sorted Words
		sortedList = new DefaultListModel();
		sortedList.addElement("Sorted");

		// Add models to List
		unsorted = new JList(unsortedList);
		sorted = new JList(sortedList);

		// Add all elements to frame
		menuBar.add(menu);
		jframe.setJMenuBar(menuBar);
		jframe.add(unsorted);
		jframe.add(sorted);
		
		
		// Show/Enable Frame
		jframe.setVisible(true);
	}
	
	/**
	 * Populates the DefaultListModel with data elements from LinkedList
	 * @param wordList
	 * @param list
	 */
	public void populateSortedModel(SortedWordList wordList, DefaultListModel list) {
		boolean flag = false;
		WordNode p = wordList.intNode;
		while (p.next != null) {
		    list.addElement(p.next.data);
		    p = p.next;
		}
	}

	/**
	 * Populates the DefaultListModel with data elements from LinkedList
	 * @param wordList
	 * @param list
	 */
	public void populateUnsortedModel(UnsortedWordList wordList, DefaultListModel list) {
		boolean flag = false;
		WordNode p = wordList.intNode;
		while (p.next != null) {
		    list.addElement(p.next.data);
		    p = p.next;
		}
	}
	/*
	 * Method to initiate displaying the linked lists data into a DefaultListModel
	 */
	public void populateLists() {
		populateSortedModel(sortedL, sortedList);
		populateUnsortedModel(unsortedL, unsortedList);
	}
}
