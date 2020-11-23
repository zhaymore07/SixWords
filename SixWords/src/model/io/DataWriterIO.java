package model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import model.memoir.Memoir;
import model.util.LinkedList;

/**
 * Writes data from a LinkedList to a file to be saved for the system to reuse again. 
 * 
 * @author Zach Haymore
 *
 */
public class DataWriterIO {

	/**
	 * Writes the Memoir objects from the passed LinkedList to a file. Throws an IllegalArgumentException if 
	 * the file could not be found or created. 
	 * 
	 * 
	 * @param fileName the name of the file to print the data to
	 * @param data the LinkedList of Memoirs to store in a file. 
	 */
	public static void writeData(String fileName, LinkedList<Memoir> data)  {
		
		PrintStream output = null;
		
		try{
			output = new PrintStream(new File(fileName)); 
			
		} catch (FileNotFoundException e) {
			
			throw new IllegalArgumentException(fileName + " unable to be written");
		}
			
		for (int i = 0; i < data.size(); i++) {
			output.print(data.get(i) + "\n");
		}
	}
}
