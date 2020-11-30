package model.io;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import model.memoir.Memoir;
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
	public static LinkedList<String> readDataWords(String fileName) {
		Scanner fileReader = null;
		
		LinkedList<String> listOfWords = new LinkedList<String>();
		
		try { 
			fileReader = new Scanner(new File(fileName));
			
		} catch(FileNotFoundException e) {
			
			fileReader.close();
			throw new IllegalArgumentException("File " + fileName + " cannot be opened");
		}
		
		fileReader.useDelimiter("\\r?\\n?[-]");
		
		while (fileReader.hasNext()) {
			listOfWords.add(fileReader.next());
			
		}
		fileReader.close();
		return listOfWords;
	}
	
	/**
	 * Reads in Memoir objects from the file and returns a list of Memoirs in the file in a LinkedList. 
	 * 
	 * @param fileName the name of the file to read from 
	 * 
	 * @throws IllegalArgumentException if the file could not be read from. 
	 * @return a LinkedList of the Memoir objects read from the file
	 */
	public static LinkedList<Memoir> readDataMemoirs(String fileName) {
		Scanner fileReader = null;
		
		LinkedList<Memoir> listOfMemoirs = new LinkedList<Memoir>();
		
		try { 
			fileReader = new Scanner(new File(fileName));
			
		} catch(FileNotFoundException e) {
			fileReader.close();
			throw new IllegalArgumentException("File " + fileName + " cannot be opened");
		}
		
		fileReader.useDelimiter("\\r?\\n?[-]");
		
		
		while (fileReader.hasNext()) {
			
			listOfMemoirs.add(createMemoir(fileReader.next()));
		}
		
		fileReader.close();
		return listOfMemoirs;
	}
	
	/**
	 * Private helper method to read in and return a  Memoir from a String.  
	 * 
	 * @param lineFromFile the line containing the information for a Memoir
	 * @return a Memoir object
	 */
	private static Memoir createMemoir(String lineFromFile) {
		Scanner lineScan = new Scanner(lineFromFile);
		
		lineScan.useDelimiter(",");
		
		
		String title = lineScan.next();
		String story = lineScan.next();
		String word = lineScan.next();
		
		
		lineScan.close();
		return new Memoir(title, story, word);
	}
}
