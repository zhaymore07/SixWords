package model.manager;

import model.memoir.Memoir;
import model.memoir.rng.WordGenerator;
import model.util.LinkedList;

/**
 * SixWordsManager acts as the container and manager class of the entire SixWords system. The SixWordsManager
 * knows its LinkedList of words, its LinkedList of memoirs, its WordGenerator object, and its single instance.
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
	
	
	
	
	
}
