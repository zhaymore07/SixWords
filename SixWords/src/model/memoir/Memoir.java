/*
 * Comprises the model/ information of the program for the Memoir
 */
package model.memoir;

import java.util.Date;

/**
 * In the SixWords system, the Memoir class encapsulates the state and behavior of a Memoir object. A Memoir object
 * contains the six-worded String that makes up the story aspect of the memoir, contains the word that must be used
 * in the story (if selected), the title of the memoir, and the date and time of the creation of the Memoir object. 
 * The Memoir object is a POJO can get the information that it contains. A Memoir represents a single six worded story
 * in the SixWords system. 
 * 
 * @author Zach Haymore
 */
public class Memoir {
	
	/**The 6 worded story of the memoir*/
	private String story;
	
	/**The name of the memoir*/
	private String title;
	
	/**The word that must be included in the story of the memoir (if selected)*/
	private String mandatoryWord;
	
	/**The date of creation of the Memoir*/
	private Date currentDate;
	
	/**
	 * Constructs a Memoir object by passing a title and the story. If the memoir title is left blank or null, then the 
	 * title is set to the currentDate String by default. If the passed story contains no words or more than six individual words 
	 * (separated by white space), then an IllegalArgumentException is thrown. If the mandoryWord is a non-null or empty value, then
	 * an IllegalArgumentException is thrown if the story does not contain the word. 
	 * 
	 * @param title the title of the memoir
	 * @param story the story portion of the memoir that cannot be less than 0 or more than 6 words.
	 * @param mandatoryWord the word that must be included in the story (if its non-empty or null)
	 */
	public Memoir(String title, String story, String mandatoryWord) {
		setCurrentDate();
		setTitle(title);
		setMandatoryWord(mandatoryWord);
		setStory(story);
	}
	
	/**
	 * Sets the current date of the Memoir by getting the current system time and constructing the date object.
	 */
	private void setCurrentDate() {
		currentDate = new Date(System.currentTimeMillis());
	}
	
	/**
	 * Sets the title of the memoir to the passed value. If the value is empty or null, then the current date is set for 
	 * the title. 
	 * 
	 * @param title the title of the memoir to set. 
	 */
	public void setTitle(String title) {
		if (title == null || "".equals(title)) {
			
			this.title = currentDate.toString();
			
		} else {
			
			this.title = title;
		}
	}
	
	/**
	 * Sets the mandatory word that must be included in the memoir. If no mandatory word is selected, then the value is 
	 * set to null. 
	 * 
	 * @param mandatoryWord the mandatory word to set that must be included in the memoir. If no word was selected, then 
	 * the mandatory word is set to null. 
	 */
	private void setMandatoryWord(String mandatoryWord) {
		if (mandatoryWord == null || "".equals(mandatoryWord)) {
			
			this.mandatoryWord = null;
		
		} else {
			this.mandatoryWord = mandatoryWord;
		}
	}
	
	/**
	 * Sets the story value for the memoir. If the story does not contain any words or if it is null, 
	 * then an IllegalArgumentException is thrown. If the story contains more than 6 words or less than 1 word, then 
	 * an IllegalArgumentException is thrown. If a mandatory generated word was selected, then an IllegalArgumentException
	 * is thrown if the word is not included in the story. 
	 * 
	 * @param story the story to set for the memoir. 
	 * @throws IllegalArgumentException if the story does not contain any words or if it is null.
	 * @throws IllegalArgumentException if the story contains more than 6 words or less than 1 word
	 * @throws IllegalArgumentException if the mandatory word is not in the story. 
	 */
	public void setStory(String story) {
		if (story == null || "".equals(story)) {
			throw new IllegalArgumentException("A memoir must contain at least 1 word");
		}
		
		String[] wordsInStory = story.split("//s+");
		
		if (wordsInStory.length > 6 || wordsInStory.length < 1) {
			throw new IllegalArgumentException("A memoir must contain between 1 and 6  words");
		}
		
		if (mandatoryWord != null && !(story.toLowerCase().contains(mandatoryWord.toLowerCase()))) {
			
			throw new IllegalArgumentException("The generated word must be included in the story");
		}
		
		this.story = story; 
	}

	/**
	 * Gets the story of the memoir
	 * @return the story
	 */
	public String getStory() {
		return story;
	}

	/**
	 * Gets the title of the memoir
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the mandatory word of the memoir
	 * @return the mandatoryWord
	 */
	public String getMandatoryWord() {
		return mandatoryWord;
	}

	/**
	 * Gets the current date the memoir was created. 
	 * @return the currentDate
	 */
	public Date getCurrentDate() {
		return currentDate;
	}
	
	/**
	 * Gets and returns the String representation of the object to print to files.
	 * @return a String representation of the Memoir object. 
	 */
	public String toString() {
		return "-" + title + "," + story + "," + mandatoryWord;
	}
	
}
