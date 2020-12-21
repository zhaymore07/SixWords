/**
 * 
 */
package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import model.manager.SixWordsManager;
import model.memoir.Memoir;

/**
 * HomeWindow is the Java class that launches the home screen for the SixWords app. This screen holds the 
 * list of current Memoirs in the system and provides the option to add, remove, and edit the memoirs that
 * are currently loaded into the system. 
 * 
 * @author Zach Haymore
 */
public class HomeWindow extends JFrame implements ActionListener{
	
	/**
	 * A JList for the memoirs
	 */
	private JList<String> listMemoirs;
	
	/**
	 * The array of Memoir objects in the system
	 */
	private Memoir[] memoirs;
	
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
		
		listMemoirs = new JList<String>(); //data has type Object[]
		listMemoirs.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listMemoirs.setLayoutOrientation(JList.VERTICAL_WRAP);
		listMemoirs.setVisibleRowCount(-1);
		
		JScrollPane listScroller = new JScrollPane();
		listScroller.setPreferredSize(new Dimension(250, 80));
		listScroller.setViewportView(listMemoirs);
		
		c.add(listScroller);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		refreshMemoirs();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Refreshes the orders.
	 */
	private void refreshMemoirs() {
		listMemoirs.clearSelection();
		DefaultListModel<String> dlmOrders = new DefaultListModel<String>();
		
		if (listMemoirs.isSelectionEmpty()) {
			memoirs = SixWordsManager.getInstance().getMemoirList();
		}
		
		for(Memoir memoir : memoirs) {
			dlmOrders.addElement(memoir.getTitle());
		}
		listMemoirs.setModel(dlmOrders);
	}

}
