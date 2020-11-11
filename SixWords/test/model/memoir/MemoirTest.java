/**
 * 
 */
package model.memoir;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the construction and creation of Memoir objects with valid and invalid values
 * 
 * @author Zach Haymore
 */
public class MemoirTest {
	
	/**
	 * Tests the construction of a Memoir object with valid and invalid values
	 */
	@Test
	public void testMemoir() {
		String validStory = "Thoughts spun round like a wheel.";
		String validMandatoryWord = "Wheel";
		String title = "First Memoir";
		String invalidStory = "We ran from that haunting room.";
		
		//Tests a valid Memoir object
		Memoir validMemoir = new Memoir(title, validStory, validMandatoryWord);
		assertEquals(validStory, validMemoir.getStory());
		assertEquals(title, validMemoir.getTitle());
		assertEquals(validMandatoryWord, validMemoir.getMandatoryWord());
		
		//Tests that the correct exception is thrown when the story does not contain the generated word
		try {
			Memoir invalidMemoir = new Memoir(title, invalidStory, validMandatoryWord);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("The generated word must be included in the story",e.getMessage());
		}
		
	}

}
