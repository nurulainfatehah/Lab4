import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ClientWordCounterFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
	private JLabel lblStatusValue;
	
	private JLabel lblIntro;
	private JLabel lblWordCount;
	private JLabel lblWord;
	public JTextField txtSentence;
	public JButton bttnClick;
	
	public ClientWordCounterFrame(){
		
		
		this.setLayout(new BorderLayout());
		this.setTitle("Word Counter: Client Side");
		this.setSize(600,300);
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label
		lblStatusValue = new JLabel("-");
		lblIntro = new JLabel("Write down a sentence and we will return the number of words in it.");
		lblWordCount = new JLabel("0 words");
		lblWord = new JLabel();
		bttnClick = new JButton("COUNT");
		
		
		
		 

		
		
		txtSentence = new JTextField("Write Here");
		txtSentence.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	txtSentence.setText("");
	        	
	        }

			@Override
			public void focusLost(FocusEvent e) {
			}
	    });
		txtSentence.setPreferredSize(new Dimension(200, 24));
		
		
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	
	
	private JPanel getConnectionStatusPanel() {
		
		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel ("Connection status: ");

		// Style the component
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);

		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);
		

		return panel;
		
	}
	
	
	private JPanel displayIntro()
	{
		JPanel panel = new JPanel();
		panel.add(lblIntro);
		lblWord.setFont(new Font("Serif", Font.PLAIN, 45));
	
		panel.add(lblWord);
		
		return panel;
	}
	
	private JPanel displayCountPanel() {
		
		JPanel panel = new JPanel();
		lblWordCount.setFont( new Font("Sans Serif", Font.PLAIN, 19));
		lblWordCount.setForeground(Color.MAGENTA);
		panel.add(lblWordCount);
				
		return panel;
		
	}
	
	private JPanel displayButton() {
		
		JPanel panel = new JPanel();
		panel.add(txtSentence);
		panel.add(bttnClick);
		return panel;
	}
	
	private JPanel displaySentence() {
		
		JPanel panel = new JPanel();
		panel.add(lblWord);
		
		
		return panel;
	}
	
	
	public void updateWord(String word) {
		
		this.lblWord.setText(word);
		
	}
	
	public void updateCount(int count) {
		
		this.lblWordCount.setText(String.valueOf(count) + " Words");
	}
	
	
	
	
	/**
	 * This method update the status of connection to the server.
	 * 
	 * @param connStatus: Connection status (true/false)
	 */
	public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		
				
		// Update the status on frame
		this.lblStatusValue.setText(status);
	}
	
	
	private void loadComponent() {
		
		JPanel northPanel = this.getConnectionStatusPanel();		
		this.add(northPanel, BorderLayout.NORTH);
		
		JPanel northPanelA = this.displayIntro();
		this.add(northPanelA, BorderLayout.CENTER);
		
		
		
		

				
		JPanel southPanelA = this.displayCountPanel();		
		this.add(southPanelA, BorderLayout.BEFORE_FIRST_LINE);
		
		JPanel southPanelB = this.displayButton();		
		this.add(southPanelB, BorderLayout.AFTER_LAST_LINE);
		
	}
	
	
	
}
