
//CS 212 Java
//Amzad Chowdhury
import javax.swing.JOptionPane;

public class Project0 {

    public static void main(String[] args) {
        String sentence; // sentence

        boolean stop = false;

        while (stop == false) {
            sentence = JOptionPane.showInputDialog("Please enter a sentence"); // to
                                                                               // string

            if (sentence.equalsIgnoreCase("Stop")) { // exit loop if stop is
                                                     // entered
                stop = true;
            } else {
                readSentence(sentence);
            }
        }
    }

    public static void readSentence(String x) {
        int length = x.length(); // Length of the string
        char upperE = 'E';
        char lowerE = 'e';
        int upperCount = 0;
        int lowerCount = 0;

        for (int i = 0; i < length; i++) { // loop to go through all the char
                                           // indexes in sentence
            if (x.charAt(i) == upperE) {
                upperCount++; // if upperE, add 1
            } else if (x.charAt(i) == lowerE) {
                lowerCount++; // if lowere add 1
            }
        }

        displayCount(upperCount, lowerCount); // display message with the e
                                              // counts.

    }

    public static void displayCount(int x, int y) {
        JOptionPane.showMessageDialog(null, "Number of lower case e's: " + y + "\n" + "Number of upper case e's: " + x);
    }
}
