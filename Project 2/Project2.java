/**
 * CS212 - Project 2
 * @author Amzad Chowdhury
 */
import java.util.StringTokenizer;

public class Project2 {

	public static void main(String[] args) {
		WordList unsortedList = new WordList();
		WordList sortedList = new WordList();

		//String myFile = "C:\\Users\\Amzad\\workspace\\Project2\\src\\words.txt";
		String myFile = args[0];
		TextFileInput in = new TextFileInput(myFile); // open the txt file
		String line = in.readLine();

		while (line != null) {
			// Split up sentences into individual words.
			StringTokenizer token = new StringTokenizer(line, ","); 
																	
			while (token.hasMoreTokens()) { // if more tokens exist, continue
											
				String tempString = token.nextToken();
				// Filter out words != to WORD_SIZE
				if (tempString.length() == Word.WORD_SIZE) { 
					// Convert String to Word Objects
					Word tempWord = new Word(tempString); 
					// Add Words to LinkedLists
					unsortedList.append(tempWord); 
					sortedList.insert(tempWord); 

				} else {
					// Print Words with more or less than 3 characters.
					System.out.println(tempString); 
				}

			}
			// Queue next line for while loop
			line = in.readLine(); 
		}
		// Close file
		in.close(); 
		// Pass parameters to GUI
		WordGUI gui = new WordGUI(unsortedList, sortedList); 
	}
}
