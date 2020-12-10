/**
 * 
 */
package model.manager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import model.memoir.Memoir;

/**
 * Test class to test the SixWordsManager class and its methods. 
 * 
 * @author Zach Haymore
 */
public class SixWordsManagerTest {
	
	/** A Memoir object to be used for testing*/
	public static final Memoir TEST_MEMOIR = new Memoir("Third Memoir", "This is a test memoir.", "test");
	
	
	/**
	 * Tests the construction of the SixWordsManager system.  
	 */
	@Test
	public void testSixWordsManagerConstructor() {
		SixWordsManager.getInstance().resetSystem();
		assertEquals(0, SixWordsManager.getInstance().getMemoirList().length);
	}
	
	/**
	 * Tests the load memoirs method
	 */
	@Test
	public void testLoadMemoirs() {
		SixWordsManager.getInstance().loadMemoirsFromFile("test-files/expected_memoir.txt");
		
		//Checks to make sure that the array holds the correct number of Memoirs
		assertEquals(2, SixWordsManager.getInstance().getMemoirList().length);
		assertEquals("First Memoir", SixWordsManager.getInstance().getMemoirList()[0].getTitle());
		assertEquals("Second Memoir", SixWordsManager.getInstance().getMemoirList()[1].getTitle());
	}
	
	/**
	 * Tests the addMemoir() method
	 */
	@Test
	public void testAddMemoir() {
		SixWordsManager.getInstance().resetSystem();
		
		
		SixWordsManager.getInstance().addMemoir(TEST_MEMOIR.getTitle(), TEST_MEMOIR.getStory(), TEST_MEMOIR.getMandatoryWord());
		
		//Checks to make sure that the Memoir was added and the information remains unchanged
		assertEquals(1, SixWordsManager.getInstance().getMemoirList().length);
		assertEquals(TEST_MEMOIR.getTitle(), SixWordsManager.getInstance().getMemoirByTitle(TEST_MEMOIR.getTitle()).getTitle());
		assertEquals(TEST_MEMOIR.getStory(), SixWordsManager.getInstance().getMemoirByTitle(TEST_MEMOIR.getTitle()).getStory());
		assertEquals(TEST_MEMOIR.getMandatoryWord(), SixWordsManager.getInstance().getMemoirByTitle(TEST_MEMOIR.getTitle()).getMandatoryWord());
	}
	
	/**
	 * Tests that a passed Memoir is removed from the system
	 */
	@Test
	public void testRemoveMemoir() {
		SixWordsManager.getInstance().resetSystem();
		
		
		SixWordsManager.getInstance().addMemoir(TEST_MEMOIR.getTitle(), TEST_MEMOIR.getStory(), TEST_MEMOIR.getMandatoryWord());
		
		//Checks to make sure that the Memoir was added and the information remains unchanged
		assertEquals(1, SixWordsManager.getInstance().getMemoirList().length);
		assertEquals(TEST_MEMOIR.getTitle(), SixWordsManager.getInstance().getMemoirByTitle(TEST_MEMOIR.getTitle()).getTitle());
		assertEquals(TEST_MEMOIR.getStory(), SixWordsManager.getInstance().getMemoirByTitle(TEST_MEMOIR.getTitle()).getStory());
		assertEquals(TEST_MEMOIR.getMandatoryWord(), SixWordsManager.getInstance().getMemoirByTitle(TEST_MEMOIR.getTitle()).getMandatoryWord());
		
		//Removes the memoir from the system and checks the length of the new array for adjusted size
		Memoir memoirToRemove = SixWordsManager.getInstance().getMemoirList()[0];
		SixWordsManager.getInstance().removeMemoir(memoirToRemove);
		assertEquals(0, SixWordsManager.getInstance().getMemoirList().length);
		
	}
	
	/**
	 * Tests the loadWordsFromFile() and the generateWord()
	 */
	@Test
	public void testLoadWordsFromFile() {
		SixWordsManager.getInstance().resetSystem();
		assertNull(SixWordsManager.getInstance().generateWord());
		
		SixWordsManager.getInstance().loadWordsFromFile("test-files/nouns.txt");
		assertNotNull(SixWordsManager.getInstance().generateWord());
	}
	
	/**
	 * Resets the SixWordManager to ensure that nothing from these tests carry over into other tests. 
	 */
	@After 
	public void reset() {
		SixWordsManager.getInstance().resetSystem();
	}
	
}
