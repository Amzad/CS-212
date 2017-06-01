/**
 * CS212 - Project 4
 * This class creates the GUI and creates and processes the data received from a text file.
 * @author Amzad Chowdhury
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;

public class WordGUI extends JFrame{

	JFrame jframe;
	JList unsorted;
	JList treemapList;
	JMenuBar menuBar;
	JMenu menu;
	DefaultListModel unsortedList;
	DefaultListModel treemapModel;
	UnsortedWordList unsortedL = new UnsortedWordList();
	TreeMap<Word, Word> treeMap = new TreeMap(new WordComparator());

	/** 
	 * Constuctor for the WordGUI class. Create and adds visual elements into the GUI.
	 */
	public WordGUI() {

		// Frame
		jframe = new JFrame("Project 4 - Amzad Chowdhury");
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
		treemapModel = new DefaultListModel();
		treemapModel.addElement("TreeMap Sorted");

		// Add models to List
		unsorted = new JList(unsortedList);
		treemapList = new JList(treemapModel);

		// Add all elements to frame
		menuBar.add(menu);
		jframe.setJMenuBar(menuBar);
		jframe.add(unsorted);
		jframe.add(treemapList);
		
		
		// Show/Enable Frame
		jframe.setVisible(true);
	}
	
	/**
	 * Populates the DefaultListModel with data elements from TreeMap
	 * @param wordList
	 * @param list
	 */
	public void populateTreeModel(DefaultListModel list) {
		Set set = treeMap.entrySet();
		Iterator i = set.iterator();
		Map.Entry<Word, Word> me;
		
		while (i.hasNext()) {
			me = (Map.Entry)i.next();  
			list.addElement(me.getValue());
			   
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
	/**
	 * Method to initiate displaying the linked lists data into a DefaultListModel
	 */
	public void populateLists() {
		populateTreeModel(treemapModel);
		populateUnsortedModel(unsortedL, unsortedList);
	}
	
	
}
