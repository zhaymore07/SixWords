package model.manager;

import model.io.DataReaderIO;
import model.io.DataWriterIO;
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
	
	/**
	 * Saves the currently loaded/ stored memoirs in the system to a file specified through its file name, 
	 * utilizing the DataWriterIO class. 
	 * 
	 * @param fileName the name of the file to store the information
	 */
	public void saveMemoirsToFile(String fileName) {
		DataWriterIO.writeData(fileName, memoirs);
	}
	
	/**
	 * Reads in the memoirs currently stored on a file into the system. Overwrites any memoirs that are currently
	 * saved in the system that are not saved on a file. 
	 * 
	 * @param fileName the file name to read the memoirs in from. 
	 */
	public void loadMemoirsFromFile(String fileName) {
		memoirs = DataReaderIO.readDataMemoirs(fileName);
	}
	
	/**
	 * Reads in the String that are the mandatory words to be randomly selected for the memoirs.
	 * 
	 * @param fileName the file to read the words from. 
	 */
	public void loadWordsFromFile(String fileName) {
		words = DataReaderIO.readDataWords(fileName);
	}
	
	/**
	 * Gets and returns an Array of Memoir objects to be used by the GUI. 
	 * 
	 * @return an array of the Memoir objects currently in the system
	 */
	public Memoir[] getMemoirList() {
		Memoir[] arrayOfMemoirs = new Memoir[memoirs.size()];
		
		for (int i = 0; i < memoirs.size(); i++) {
			arrayOfMemoirs[i] = memoirs.get(i);
		}
		
		return arrayOfMemoirs;
	}
	
	/**
	 * Gets and returns the Memoir object by its passed title. Returns null if the object does not exist. 
	 * 
	 * @param title the title of the Memoir to get
	 * @return the Memoir object with the passed title or null if the Memoir object with the passed title does not exist.
	 */
	public Memoir getMemoirByTitle(String title) {
		Memoir memoirToReturn = null; 
		
		for (int i = 0; i < memoirs.size(); i++) {
			
			if (memoirs.get(i).getTitle().equals(title)) {
				memoirToReturn = memoirs.get(i);
			}
			
		}
		
		return memoirToReturn;
	}
	
	
}
