package model.io;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import model.util.LinkedList;

/**
 * Reads in data from a text file and returns the data in a LinkedList, using the readData() and passing a file name.
 *  
 * @author Zach Haymore
 *
 */
public class DataReaderIO {
	
	/**
	 * Reads in the data from the file and returns the words in the file in a LinkedList. 
	 * 
	 * @param fileName the name of the file to read from 
	 * 
	 * @throws IllegalArgumentException if the file could not be read from. 
	 * @return a LinkedList of the Strings read from the file
	 */
	public static LinkedList<String> readData(String fileName) {
		Scanner fileReader = null;
		
		LinkedList<String> listOfWords = new LinkedList<String>();
		
		try { 
			fileReader = new Scanner(new File(fileName));
			
		} catch(FileNotFoundException e) {
			throw new IllegalArgumentException("File " + fileName + " cannot be opened");
		}
		
		fileReader.useDelimiter("\\r?\\n?[-]");
		
		while (fileReader.hasNext()) {
			listOfWords.add(fileReader.next());
		}
		
		return listOfWords;
	}
}
