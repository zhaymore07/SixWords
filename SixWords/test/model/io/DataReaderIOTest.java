/**
 * 
 */
package model.io;

import static org.junit.Assert.*;

import org.junit.Test;

import model.memoir.Memoir;
import model.util.LinkedList;

/**
 * Test class to test the DataReaderIO class
 * 
 * @author Zach Haymore
 */
public class DataReaderIOTest {
	
	/**
	 * Tests the ReadData() with a valid file and verifies results. 
	 */
	@Test
	public void testReadDataWords() {
		LinkedList<String> list = DataReaderIO.readDataWords("test-files/short-nouns.txt");
		
		assertEquals(5, list.size());
		assertEquals("Australia", list.get(0));
		assertEquals("Balloon", list.get(1));
		assertEquals("Banana", list.get(2));
		assertEquals("Battery", list.get(3));
		assertEquals("Beach", list.get(4));
		
	}
	
	@Test
	public void testReadDataMemoirs() {
		LinkedList<Memoir> list = DataReaderIO.readDataMemoirs("test-files/expected_memoir.txt");
		
		assertEquals(2, list.size());
		assertEquals("First Memoir", list.get(0).getTitle());
		assertEquals("Thoughts spun round like a wheel.", list.get(0).getStory());
		assertEquals("Second Memoir", list.get(1).getTitle());
		assertEquals("In the hills Kara escaped freedom", list.get(1).getStory());
	}

}
