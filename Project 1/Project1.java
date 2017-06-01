import java.util.StringTokenizer;

public class Project1 {
    public static void main(String[] args) {
        Word w = new Word("cat");

        Word[] wordArray = new Word[50]; //Create string array
        Word[] sortedArray = new Word[50]; // create sorted array
        
        //String myFile = "C:\\Users\\Amzad\\workspace\\Project1\\bin\\words.txt";
        String myFile = args[0];

        int myArrayLength = readFile(myFile, wordArray); //get length and process file
                                                         
        copyArray(sortedArray, wordArray); // copy array over for selectionsort

        selectionSort(sortedArray, myArrayLength); //sort the sortedArray
        
        WordGUI GUI = new WordGUI(wordArray, sortedArray); // call and pass arrays to the GUI
    }
    
    
    // Method for copying data from one Word array to another
    public static void copyArray(Word[] sortedArray, Word[] wordArray) {
        for (int i = 0; i < wordArray.length; i++) {
            sortedArray[i] = wordArray[i];
        }
    }

    
    //Read and process input file
    public static int readFile(String filename, Word[] words) {
        TextFileInput in = new TextFileInput(filename); //open the txt file
        String line = in.readLine();
        int arrayLength = 0; //value to keep track of how much of the array is filled

        while (arrayLength < words.length && line != null) {
            StringTokenizer token = new StringTokenizer(line, ","); //split up all lines of the txt

            while (token.hasMoreTokens()) { //if more tokens exist, continue loop and file in array

                //words[arrayLength++] = token.nextToken(); //set array[i] = token[i]
                //convert string to word

                String tempString = token.nextToken();
                if (tempString.length() == Word.WORD_SIZE) { //Filter out != word_size
                    Word tempWord = new Word(tempString); //Convert string to Word object
                    words[arrayLength++] = tempWord;

                } else {
                    System.out.println(tempString); //Print words with more than 3 characters.
                }

            }

            line = in.readLine(); //queue next line for while loop

        }

        in.close();
        return arrayLength; //length number of valid elements
    }

    //Selection Sort method
    public static void selectionSort(Word[] sortedArray, int length) {
        for (int i = 0; i < length - 1; i++) {
            int indexLowest = i;
            for (int j = i + 1; j < length; j++)
                if (sortedArray[j].word.compareToIgnoreCase(sortedArray[indexLowest].word) < 0 )
                        indexLowest = j;
                    
            if (sortedArray[indexLowest] != sortedArray[i]) {
                Word temp = sortedArray[indexLowest];
                sortedArray[indexLowest] = sortedArray[i];
                sortedArray[i] = temp;
            }
        }
    }
}
