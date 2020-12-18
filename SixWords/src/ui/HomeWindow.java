/**
 * 
 */
package ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * HomeWindow is the Java class that launches the home screen for the SixWords app. This screen holds the 
 * list of current Memoirs in the system and provides the option to add, remove, and edit the memoirs that
 * are currently loaded into the system. 
 * 
 * @author Zach Haymore
 */
public class HomeWindow extends JFrame implements ActionListener{

	/**
	 * UID needed for JFrame
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs the HomeWindo object and its components
	 */
	public HomeWindow() {
		Container c = getContentPane();
		setTitle("Home");
		setLocation(200, 200);
		setSize(600, 600);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
