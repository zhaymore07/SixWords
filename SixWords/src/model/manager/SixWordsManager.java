package model.manager;

import model.memoir.Memoir;
import model.memoir.rng.WordGenerator;
import model.util.LinkedList;

/**
 * SixWordsManager acts as the container and manager class of the entire SixWords system. The SixWordsManager
 * knows its LinkedList of words, its LinkedList of memoirs, its WordGenerator object, and its singleton instance.
 * The SixWordsManager follows the Singleton design pattern by containing, controlling, and returning its singular instance
 * through its getInstance() method. 
 *  
 * @author Zach Haymore
 */
public class SixWordsManager {
	
	/**The LinkedList of words to be generated for the memoirs*/
	private LinkedList<String> words; 
	
	/**The LinkedList of memoirs in the system*/
	private LinkedList<Memoir> memoirs;
	
	/**The Singleton instance of the manager*/
	private static SixWordsManager instance;
	
	/**The WordGenerator object used to generate a randomly selected word from its LinkedList*/
	private WordGenerator wordGenerator;
	
	/**
	 * The private constructor of the object that initializes the state of the system through the 
	 * resetSystem() method. 
	 */
	private SixWordsManager() {
		resetSystem();
	}
	
	/**
	 * Gets and returns the singleton instance of SixWordsManager. If the instance is null, then a 
	 * new SixWordsManager is created. 
	 * 
	 * @return the singleton instance of the object
	 */
	public static SixWordsManager getInstance() {
		if (instance == null) {
			instance = new SixWordsManager();
		}
		
		return instance;
	}
	
	/**
	 * Resets the SixWordsManager system by initializing the state of the system. Resets the 
	 * words LinkedList, the memoirs LinkedList, and the WordGenerator. 
	 */
	public void resetSystem() {
		this.words = new LinkedList<String>();
		
		this.memoirs = new LinkedList<Memoir>();
		
		this.wordGenerator = new WordGenerator();
	}
	
	/**
	 * Utilizes the word generator object to randomly select a word from the passed LinkedList of string objects.
	 * 
	 * @return the mandatory word to put in the story
	 */
	public String generateWord() {
		return wordGenerator.generateWord(words);
	}
	
	/**
	 * Creates and adds the memoir object to the LinkedList of memoirs in the system from the passed title, story, and mandatory word. 
	 * An exception may be thrown from the Memoir class if the values are invalid. 
	 * 
	 * @param title the title of the Memoir
	 * @param story the story portion of the memoir
	 * @param mandatoryWord the mandatory word that should be included in the memoir. 
	 */
	public void addMemoir(String title, String story, String mandatoryWord) {
		memoirs.add(new Memoir(title, story, mandatoryWord));
	}
	
	/**
	 * Removes a passed Memoir object from the system.
	 * 
	 * @param memoirToRemove the memoir to remove from the SixWords system. 
	 */
	public void removeMemoir(Memoir memoirToRemove) {
		memoirs.remove(memoirs.indexOf(memoirToRemove));
	}
	
	
}
