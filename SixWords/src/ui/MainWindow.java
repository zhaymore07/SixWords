/**
 * 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Main GUI component that will be used to launch the program and that will hold the buttons to 
 * access other GUI components. 
 * 
 * @author Zach Haymore
 */
public class MainWindow extends JFrame{
	
	/**Button to start creating new memoirs*/
	private JButton btnStartNewMemoirs;
	
	/**Button to load a file chooser*/
	private JButton btnLoadMemoirsFromFile;
	
	/**Panel to hold the buttons*/
	private JPanel btnPanel;
	
	/**SixWords logo*/
	private BufferedImage logo; 
	
	/**Label for the logo*/
	private JLabel logoLabel;
	
	/**
	 * For the Swing JFrame
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Initializes the Window
	 */
	public MainWindow() {
		Container c = getContentPane();
		setTitle("SixWords");
		setLocation(200, 200);
		setSize(600, 600);
		c.setBackground(Color.decode("#9aa6a3"));
		
		//Adds the logo
		try {                
	          logo = ImageIO.read(new File("images/SixWords.png"));
	       } catch (IOException ex) {
	            throw new IllegalArgumentException("Can't read file");
	       }
		
		logoLabel = new JLabel(new ImageIcon(logo));
		c.add(logoLabel);
		
		//Adds and styles the Buttons
		btnPanel = new JPanel();
		btnPanel.setBackground(Color.decode("#9aa6a3"));
		btnStartNewMemoirs = new JButton("Create New Stories");
		Font raleway = new Font("Raleway", Font.PLAIN, 14); 
		btnStartNewMemoirs.setFont(raleway);
		btnLoadMemoirsFromFile = new JButton("Load Stories From File");
		btnLoadMemoirsFromFile.setFont(raleway);
		btnStartNewMemoirs.setForeground(Color.WHITE);
		btnLoadMemoirsFromFile.setForeground(Color.WHITE);
		btnStartNewMemoirs.setOpaque(false);
		btnLoadMemoirsFromFile.setOpaque(false);
		btnPanel.add(btnStartNewMemoirs);
		btnPanel.add(btnLoadMemoirsFromFile);
		c.add(btnPanel, BorderLayout.SOUTH);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	/**
	 * Starts the program by launching the MainWindow
	 * @param args not used
	 */
	public static void main(String[] args) {
		new MainWindow();
	}
	
	
}
