/**
 * 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.manager.SixWordsManager;
import model.memoir.Memoir;

/**
 * HomeWindow is the Java class that launches the home screen for the SixWords app. This screen holds the 
 * list of current Memoirs in the system and provides the option to add, remove, and edit the memoirs that
 * are currently loaded into the system. 
 * 
 * @author Zach Haymore
 */
public class HomeWindow extends JFrame implements ActionListener, ListSelectionListener {
	
	/**
	 * A JList for the memoirs
	 */
	private JList<String> listMemoirs;
	
	/**
	 * The array of Memoir objects in the system
	 */
	private Memoir[] memoirs;
	
	/**JPanel to hold the list of Memoirs and buttons*/
	private JPanel pnlMemoir; 
	
	/**Text Area to Display the Story portion of the Memoir*/
	private JTextArea txtAreaMemoir; 
	
	/**JPanel to hold the action buttons*/
	private JPanel pnlButtons;
	
	/**JButton to create stories*/
	private JButton btnCreate;
	
	/**JButton to remove story*/
	private JButton btnRemove;
	
	/**JButton to edit the story*/
	private JButton btnEdit;
	
	
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
		
		//Creates the JPanel and JList to hold the Memoir objects to be selected
		pnlMemoir = new JPanel();
		listMemoirs = new JList<String>(); //data has type Object[]
		listMemoirs.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listMemoirs.setLayoutOrientation(JList.VERTICAL_WRAP);
		listMemoirs.setVisibleRowCount(-1);
		listMemoirs.addListSelectionListener(this);
		JScrollPane listScroller = new JScrollPane();
		listScroller.setPreferredSize(new Dimension(250, 80));
		listScroller.setViewportView(listMemoirs);
		pnlMemoir.add(listScroller);
		
		//Creates the TextArea that will display the story of the selected Memoir from the list
		txtAreaMemoir = new JTextArea(4, 10);
		txtAreaMemoir.setEditable(false);
		c.add(pnlMemoir, BorderLayout.CENTER);
		c.add(txtAreaMemoir, BorderLayout.NORTH);
		
		//Creates the panel and buttons for the actions that will be performed on the selected Memoirs
		pnlButtons = new JPanel();
		btnCreate = new JButton("Create a New Story");
		btnRemove = new JButton("Delete the Selected Story");
		btnEdit = new JButton("Edit the Selected Story");
		btnCreate.addActionListener(this);
		btnRemove.addActionListener(this);
		btnEdit.addActionListener(this);
		pnlButtons.add(btnCreate);
		pnlButtons.add(btnRemove);
		pnlButtons.add(btnEdit);
		c.add(pnlButtons, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		refreshMemoirs();
	}
	
	/**
	 * ActionPerfomed method needed for the ActionListener interface. Performs the required action,
	 * corresponding to the event that was triggered by the specific button pressed. Add button launches a prompt
	 * to create a new Memoir, Delete button deletes the selected memoir object from the list and refreshes the JList, and Edit
	 * opens a prompt to edit the selected memoir.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create a New Story")) {
			//TODO: Once Edit Dialog window is set up create it here
			System.out.println("Create button pressed");
			
		} else if (e.getActionCommand().equals("Delete the Selected Story")) {
			
			String selectedTitle = listMemoirs.getSelectedValue();
			
			if (selectedTitle != null) {
				
				SixWordsManager.getInstance().removeMemoir(SixWordsManager.getInstance().getMemoirByTitle(selectedTitle));
				refreshMemoirs();
			} 
			
			System.out.println("Delete button pressed");
		} else if (e.getActionCommand().equals("Edit the Selected Story")) {
			//TODO: Once Edit dialog window is created link it here.
			System.out.println("Edit button pressed");
		}
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
		
		for (Memoir memoir : memoirs) {
			dlmOrders.addElement(memoir.getTitle());
		}
		listMemoirs.setModel(dlmOrders);
	}
	
	/**
	 * The valueChanged() that performs the action for the ListListener. 
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			txtAreaMemoir.setText(memoirs[e.getFirstIndex()].getStory());
	    }
	}

}
