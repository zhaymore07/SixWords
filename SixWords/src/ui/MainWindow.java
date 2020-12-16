/**
 * 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.manager.SixWordsManager;


/**
 * The Main GUI component that will be used to launch the program and that will hold the buttons to 
 * access other GUI components. 
 * 
 * @author Zach Haymore
 */
public class MainWindow extends JFrame implements ActionListener{
	
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
		
		btnStartNewMemoirs.addActionListener(this);
		btnLoadMemoirsFromFile.addActionListener(this);
		
		btnPanel.add(btnStartNewMemoirs);
		btnPanel.add(btnLoadMemoirsFromFile);
		
		
	
		
		c.add(btnPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	/**
	 * Action performed method that gets called when an action is registered from the buttons. If 
	 * the ActionEvent has the action command of "Create New Stories," then the program loads an empty
	 * system, where new stories can be created, else then a FileChooser option loads and a file needs
	 * to be selected with the memoirs that need to be loaded. The SixWordsManager is then loaded with 
	 * the information from the file, and a new window will be launched. Closes the MainWindow after the 
	 * action had been called and new Window has been loaded. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if  (e.getActionCommand().equals("Create New Stories")) {
			
			//TODO: Update with code to launch new window once the window has been created
		
		} else {
			
			try {
				SixWordsManager.getInstance().resetSystem();
				
				JFileChooser chooser = new JFileChooser("./");
				FileNameExtensionFilter filterExt = new FileNameExtensionFilter("Memoirs (txt)", "txt");
				chooser.setFileFilter(filterExt);
				chooser.setMultiSelectionEnabled(false);
				int resultAction = chooser.showOpenDialog(this);
				
				if (resultAction == JFileChooser.APPROVE_OPTION) {
					String fileName = chooser.getSelectedFile().getAbsolutePath();
					
					SixWordsManager.getInstance().loadMemoirsFromFile(fileName);
				}
			} catch (Exception f) {
				JOptionPane.showMessageDialog(this, "Error opening file.", "Opening Error", JOptionPane.ERROR_MESSAGE);
			}
			
			//TODO: Update with code to launch new window once the window has been created
			
		}
		
		 JComponent comp = (JComponent) e.getSource();
		  Window win = SwingUtilities.getWindowAncestor(comp);
		  win.dispose();
	}
	
	/**
	 * Starts the program by launching the MainWindow
	 * @param args not used
	 */
	public static void main(String[] args) {
		new MainWindow();
	}

	
}
