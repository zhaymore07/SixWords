package model.memoir.rng;

import java.util.Random;

import model.util.LinkedList;

/**
 * WordGenerator generates and returns a random word for the random word selector portion of the SixWord program. 
 * A WordGenerator object uses its generatWord() method to select and return a random String from a LinkedList of String objects. 
 * 
 * @author Zach Haymore
 */
public class WordGenerator {
	
	/**
	 * Returns a randomly selected word from a LinkedList of String objects through using a Random object
	 * and generating a number between 0 and the size of the list, and then returning the String at the index
	 * of the list. 
	 * 
	 * @param words the LinkedList of Strings that contain the words to select
	 * @return the String at the randomly selected index.
	 */
	public String generateWord(LinkedList<String> words) {
		Random randomNumberGenerator = new Random();
		
		int randomIndex = randomNumberGenerator.nextInt(words.size());
		
		
		return words.get(randomIndex); 
		
	}
	
}
