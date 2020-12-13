/**
 * 
 */
package ui;

import java.awt.Container;

import javax.swing.JFrame;

/**
 * The Main GUI component that will be used to launch the program and that will hold the buttons to 
 * access other GUI components. 
 * 
 * @author Zach Haymore
 */
public class MainWindow extends JFrame{

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
