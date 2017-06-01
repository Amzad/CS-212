/**
 * This class handles the reading and processing of a file from storage.
 */

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
	WordGUI newwordGUI;
	/** Instantiates a GUI
	 * @param wordGUI
	 */
	public FileMenuHandler(WordGUI wordGUI) {
		newwordGUI = wordGUI;
	}
	 /** Handles the action when either Open or Quit is clicked in the GUI.
	  * 
	  */
	public void actionPerformed(ActionEvent event) {
		String menuName;
		menuName = event.getActionCommand();
		if (menuName.equals("Open")) {
			openFile();
			
		} else if (menuName.equals("Quit"))
			System.exit(0);
		// actionPerformed
	}
	
	/** Open files from storage
	 * 
	 */
	private void openFile() {
		JFileChooser chooser;
		int status;
		chooser = new JFileChooser();
		status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION)

			readSource(chooser.getSelectedFile());
		else
			JOptionPane.showMessageDialog(null, "Open File dialog canceled");
	} // openFile

	/** Reads and processes text file from storage and adds them into linked lists.
	 * @param choosenFile
	 */
	private void readSource(File chosenFile) {
		TextFileInput in = new TextFileInput(chosenFile.toString());
		String line = in.readLine();
		
		while (line != null) {
			// Split up sentences into individual words.
			StringTokenizer token = new StringTokenizer(line, ",");

			while (token.hasMoreTokens()) { // if more tokens exist, continue

				String tempString = token.nextToken();
				// Filter out words != to WORD_SIZE

				try {
					// Convert String to Word Objects
					Word tempWord = new Word(tempString);
					// Add Words to LinkedLists
					newwordGUI.unsortedL.add(tempWord);
					newwordGUI.treeMap.put(tempWord, tempWord);
				} catch (IllegalWord212Exception message) {
					System.out.println(message + tempString);
				}

			}
			// Queue next line for while loop
			line = in.readLine();
		}
		populateLists();
		
	}
	/** Method to populate DefaultTableModels with data from text file.
	 * 
	 */
	private void populateLists() {
		newwordGUI.populateLists();
	}
}