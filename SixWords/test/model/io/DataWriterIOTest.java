package model.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import model.memoir.Memoir;
import model.util.LinkedList;

/**
 * Test class to test the DataWriterIO class
 * 
 * @author Zach Haymore
 *
 */
public class DataWriterIOTest {
	
	/**
	 * Tests the writeData() to make sure the data is correct. 
	 */
	@Test
	public void testWriteData() {
		LinkedList<Memoir> data = new LinkedList<Memoir>();
		
		//Creates Memoir objects to put in LinkedList
		String validStory = "Thoughts spun round like a wheel.";
		String validMandatoryWord = "Wheel";
		String title = "First Memoir";
		Memoir validMemoir = new Memoir(title, validStory, validMandatoryWord);
		assertEquals(validStory, validMemoir.getStory());
		assertEquals(title, validMemoir.getTitle());
		assertEquals(validMandatoryWord, validMemoir.getMandatoryWord());
		
		
		data.add(validMemoir);
		
		//Creates Memoir objects to put in LinkedList
		String validStory2 = "In the hills Kara escaped freedom";
		String validMandatoryWord2 = "Hills";
		String title2 = "Second Memoir";
		Memoir validMemoir2 = new Memoir(title2, validStory2, validMandatoryWord2);
		assertEquals(validStory2, validMemoir2.getStory());
		assertEquals(title2, validMemoir2.getTitle());
		assertEquals(validMandatoryWord2, validMemoir2.getMandatoryWord());	
		
		data.add(validMemoir2);
		
		DataWriterIO.writeData("test-files/memoir1.txt", data);
		
		try (Scanner expectedScanner = new Scanner(new File("test-files/expected_memoir.txt"));
				Scanner actualScanner = new Scanner(new File("test-files/memoir1.txt"));) {
						
				while (expectedScanner.hasNextLine()) {
					assertEquals(expectedScanner.nextLine(), actualScanner.nextLine());
				}
						
				expectedScanner.close();
				actualScanner.close();
			} catch (IOException e) {
				fail("Error reading files.");
			}
		
	}

}
