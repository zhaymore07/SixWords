/**
 * 
 */
package model.io;

import static org.junit.Assert.*;

import org.junit.Test;

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
	public void testReadData() {
		LinkedList<String> list = DataReaderIO.readData("test-files/short-nouns.txt");
		
		assertEquals(5, list.size());
		assertEquals("Australia", list.get(0));
		assertEquals("Balloon", list.get(1));
		assertEquals("Banana", list.get(2));
		assertEquals("Battery", list.get(3));
		assertEquals("Beach", list.get(4));
		
	}

}
