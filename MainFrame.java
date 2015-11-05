import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.RootPaneContainer;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class MainFrame extends JFrame implements ActionListener { 
	private static JPanel contentPane; //The Frame JPanel
	public static JPanel InputPane; //JPanel for the TextField
	public static TextField InputField; //TextField that reads the users input
	public static JTextField txtUser; //JTextField that displays the users name
	public static JTextField txtLevel;	//JtextField that displays the users level
	public static JTextField txtClass; //JTextField that displays the users class
	public static JTextField txtXP; //JTextField that displays the users experience #/#
	public static JTextField txtHEALTH; //JTextFied that displays the users health ##? or ##/##?
	public static JTextField txtSTR; //JTextField that displays the users str
	public static JTextField txtCON; //JTextField that displays the users con
	public static JTextField txtDEX; //JTextField that displays the users dex
	public static JTextArea textArea;	//JTextArea that displays the story/users input **Needs to be changed for color coding**
	public static JTextPane textPane; //JTextPane can be used to replace the JTextArea, this will allow color changing
	public static int Location = 0; //The Location of the story line, where is the user within the story
	public static String input;	 //The input of the user, used to change variables throughout the game
	public static StyleContext sc = new StyleContext();
	static Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
    static Style userStyle = sc.addStyle("userStyle", defaultStyle);
    static Style npcStyle = sc.addStyle("npcStyle", defaultStyle);
    static Style choiceStyle = sc.addStyle("choiceStyle", defaultStyle);
    static Style errorStyle = sc.addStyle("errorStyle", defaultStyle);
    static Style actionStyle = sc.addStyle("actionStyle", defaultStyle);
    public static DefaultStyledDocument doc = new DefaultStyledDocument(sc);
	Story advent = new Story(); //Constructor of the Story Class, this is the story line
	UserClass userInfo = new UserClass(); //Constructor of the UserClass, this is the information of the user
	Map map = new Map(); //COnstructor that is used to call the Map class to add the map on the map button
	InputListener listen = new InputListener();
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}	

	/**
	 * Create the frame and its content.
	 * @throws BadLocationException 
	 */
	public MainFrame() throws BadLocationException {
		StyleConstants.setLeftIndent(userStyle, 0);
	    StyleConstants.setRightIndent(userStyle, 16);
	    StyleConstants.setFirstLineIndent(userStyle, 16);
	    StyleConstants.setFontFamily(userStyle, "Tahoma");
	    StyleConstants.setFontSize(userStyle, 14);
	    StyleConstants.setForeground(userStyle, Color.white);
	    
	    StyleConstants.setLeftIndent(npcStyle, 0);
	    StyleConstants.setRightIndent(npcStyle, 16);
	    StyleConstants.setFirstLineIndent(npcStyle, 16);
	    StyleConstants.setFontFamily(npcStyle, "Tahoma");
	    StyleConstants.setFontSize(npcStyle, 14);
	    StyleConstants.setForeground(npcStyle, Color.green);
	    
	    StyleConstants.setLeftIndent(errorStyle, 0);
	    StyleConstants.setRightIndent(errorStyle, 16);
	    StyleConstants.setFirstLineIndent(errorStyle, 16);
	    StyleConstants.setFontFamily(errorStyle, "Tahoma");
	    StyleConstants.setFontSize(errorStyle, 14);
	    StyleConstants.setForeground(errorStyle, Color.RED);
	    
	    StyleConstants.setLeftIndent(choiceStyle, 0);
	    StyleConstants.setRightIndent(choiceStyle, 16);
	    StyleConstants.setFirstLineIndent(choiceStyle, 16);
	    StyleConstants.setFontFamily(choiceStyle, "Tahoma");
	    StyleConstants.setFontSize(choiceStyle, 14);
	    StyleConstants.setForeground(choiceStyle, Color.CYAN);
	    
	    StyleConstants.setLeftIndent(actionStyle, 0);
	    StyleConstants.setRightIndent(actionStyle, 16);
	    StyleConstants.setFirstLineIndent(actionStyle, 16);
	    StyleConstants.setFontFamily(actionStyle, "Tahoma");
	    StyleConstants.setFontSize(actionStyle, 14);
	    StyleConstants.setForeground(actionStyle, Color.MAGENTA);
		
		
		/**
		 * Creates frame and the overall frame panel
		 * 
		 * >>>>IF THE MAINFRAME CLOSES, SO DOES EVERYTHING ELSE.
		 */
		setResizable(false);
		setTitle("RPG v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 628);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Create a Panel the TextField.
		 */
		InputPane = new JPanel();
		InputPane.setBackground(Color.ORANGE);
		InputPane.setBounds(10, 544, 666, 44);
		contentPane.add(InputPane);
		InputPane.setLayout(null);		
		
		/**
		 * Create the TextArea, this will show the text of questions and user output.
		 */
		textPane = new JTextPane(doc);
		textPane.setBounds(10, 69, 666, 477);		
		textPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.YELLOW, Color.BLUE));
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.BLACK);
		textPane.setEditable(false);
		
		/**
		 * Create the ScrollPane for the TextArea, this will allow automatic scrollable text.
		 */
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 69, 666, 477);
		contentPane.add(scrollPane);
		
		/**
		 * Create a Panel for Users Name/Class/Level/Experience.
		 */
		JPanel topInfoPane = new JPanel();
		topInfoPane.setBorder(null);
		topInfoPane.setBackground(Color.ORANGE);
		topInfoPane.setBounds(10, 0, 666, 70);
		contentPane.add(topInfoPane);
		topInfoPane.setLayout(null);
		
		/**
		 * Create the Label for Users name.
		 */
		JLabel lblCharacterName = new JLabel("Character Name:");
		lblCharacterName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCharacterName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCharacterName.setBounds(0, 22, 150, 25);
		topInfoPane.add(lblCharacterName);
		
		/**
		 * Create the TextField for Users name.
		 */
		txtUser = new JTextField();
		txtUser.setBorder(null);
		txtUser.setMargin(new Insets(0, 0, 0, 0));
		txtUser.setHorizontalAlignment(SwingConstants.LEFT);
		txtUser.setEditable(false);
		txtUser.setForeground(Color.BLUE);
		txtUser.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtUser.setText("User");
		txtUser.setBackground(Color.ORANGE);
		txtUser.setBounds(145, 25, 100, 25);
		topInfoPane.add(txtUser);
		txtUser.setColumns(10);
		
		/**
		 * Create the Label for Users Class.
		 */
		JLabel userClass = new JLabel("Class:");
		userClass.setFont(new Font("Tahoma", Font.BOLD, 17));
		userClass.setVerticalAlignment(SwingConstants.BOTTOM);
		userClass.setBounds(250, 22, 50, 25);
		topInfoPane.add(userClass);
		
		/**
		 * Create the TextField for Users Class.
		 */
		txtClass = new JTextField();
		txtClass.setEditable(false);
		txtClass.setHorizontalAlignment(SwingConstants.LEFT);
		txtClass.setMargin(new Insets(0, 0, 0, 0));
		txtClass.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtClass.setForeground(Color.BLUE);
		txtClass.setText(userInfo.USER_CLASS);
		txtClass.setBorder(null);
		txtClass.setBackground(Color.ORANGE);
		txtClass.setBounds(305, 25, 100, 25);
		topInfoPane.add(txtClass);
		txtClass.setColumns(10);
		
		/**
		 * Create the Label for Users level.
		 */
		JLabel userLevel = new JLabel("Level:");
		userLevel.setFont(new Font("Tahoma", Font.BOLD, 17));
		userLevel.setVerticalAlignment(SwingConstants.BOTTOM);
		userLevel.setBounds(450, 22, 57, 25);
		topInfoPane.add(userLevel);
		
		/**
		 * Create the TextField for Users Level.
		 */
		txtLevel = new JTextField();
		txtLevel.setEditable(false);
		txtLevel.setHorizontalAlignment(SwingConstants.LEFT);
		txtLevel.setMargin(new Insets(0, 0, 0, 0));
		txtLevel.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtLevel.setForeground(Color.BLUE);
		txtLevel.setText("1");
		txtLevel.setBorder(null);
		txtLevel.setBackground(Color.ORANGE);
		txtLevel.setBounds(505, 25, 30, 25);
		topInfoPane.add(txtLevel);
		txtLevel.setColumns(10);
		
		/**
		 * JLabel for the users experience
		 */
		JLabel userXP = new JLabel("Exp:");
		userXP.setFont(new Font("Tahoma", Font.BOLD, 17));
		userXP.setVerticalAlignment(SwingConstants.BOTTOM);
		userXP.setBounds(550, 22, 37, 25);
		topInfoPane.add(userXP);		
		
		/**
		 * JTextField that will show how much experience the user has and how much is needed before obtaining a new level
		 */
		txtXP = new JTextField();
		txtXP.setEditable(false);
		txtXP.setHorizontalAlignment(SwingConstants.LEFT);
		txtXP.setMargin(new Insets(0,0,0,0));
		txtXP.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtXP.setForeground(Color.BLUE);
		txtXP.setText(userInfo.USER_EXP+"/"+userInfo.NEEDED_XP);
		txtXP.setBorder(null);
		txtXP.setBackground(Color.ORANGE);
		txtXP.setBounds(590, 25, 76, 25);
		topInfoPane.add(txtXP);
		
		/**
		 * Create a panel for the Map.
		 * Map isn't implemented yet
		 */
		JPanel mapPane = new JPanel();
		mapPane.setBackground(Color.RED);
		mapPane.setBounds(678, 0, 182, 169);
		contentPane.add(mapPane);
		mapPane.setLayout(null);
		
		/**
		 * Creates the button that will display the map. The map will be able to close without closing other things.
		 */
		JButton mapTest = new JButton();
		mapTest.setText("Map");
		mapTest.setBounds(0, 0, 182, 169);
		mapTest.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
	            JFrame frame2 = new JFrame ();
	            JLabel maping = new JLabel(new ImageIcon(map.getImage()));
	            frame2.setVisible(true);
	            frame2.setResizable(false);
	            frame2.setTitle("Map");
	            frame2.setDefaultCloseOperation(frame2.DISPOSE_ON_CLOSE);
	            frame2.setBounds(100, 100, 800, 800);
	            frame2.add(maping);
	            maping.setVisible(true);
	        }
	    });
		mapPane.add(mapTest);
		
		/**
		 * Create a panel for the User's Stats.
		 * Stats in general are not yet implemented
		 */		
		JPanel statsPane = new JPanel();
		statsPane.setBackground(Color.ORANGE);
		statsPane.setBounds(678, 170, 182, 418);
		contentPane.add(statsPane);
		statsPane.setLayout(null);
		
		/**
		 * Creates the Label for Health
		 */	
		JLabel statsHP = new JLabel("Health");
		statsHP.setFont(new Font("Tahoma", Font.BOLD, 17));
		statsHP.setVerticalAlignment(SwingConstants.BOTTOM);
		statsHP.setBounds(73, 0, 60, 25);
		statsPane.add(statsHP);
		
		/**
		 * Creates the JTextField for the users health.
		 */	
		txtHEALTH = new JTextField();
		txtHEALTH.setEditable(false);
		txtHEALTH.setHorizontalAlignment(SwingConstants.LEFT);
		txtHEALTH.setMargin(new Insets(0,0,0,0));
		txtHEALTH.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtHEALTH.setForeground(Color.BLUE);
		txtHEALTH.setText("0");
		txtHEALTH.setBorder(null);
		txtHEALTH.setBackground(Color.ORANGE);
		txtHEALTH.setBounds(83, 25, 84, 25);
		statsPane.add(txtHEALTH);
		
		/**
		 * Creates the Label for Str
		 */	
		JLabel statsSTR = new JLabel("Str");
		statsSTR.setFont(new Font("Tahoma", Font.BOLD, 17));
		statsSTR.setVerticalAlignment(SwingConstants.BOTTOM);
		statsSTR.setBounds(73, 100, 60, 25);
		statsPane.add(statsSTR);
		
		/**
		 * Creates the JTextField for the users str.
		 */	
		txtSTR = new JTextField();
		txtSTR.setEditable(false);
		txtSTR.setHorizontalAlignment(SwingConstants.LEFT);
		txtSTR.setMargin(new Insets(0,0,0,0));
		txtSTR.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtSTR.setForeground(Color.BLUE);
		txtSTR.setText("0");
		txtSTR.setBorder(null);
		txtSTR.setBackground(Color.ORANGE);
		txtSTR.setBounds(83, 125, 84, 25);
		statsPane.add(txtSTR);
		
		/**
		 * Creates the Label for Con
		 */	
		JLabel statsCON = new JLabel("Con");
		statsCON.setFont(new Font("Tahoma", Font.BOLD, 17));
		statsCON.setVerticalAlignment(SwingConstants.BOTTOM);
		statsCON.setBounds(73, 200, 60, 25);
		statsPane.add(statsCON);
		
		/**
		 * Creates the JTextField for the users con.
		 */	
		txtCON = new JTextField();
		txtCON.setEditable(false);
		txtCON.setHorizontalAlignment(SwingConstants.LEFT);
		txtCON.setMargin(new Insets(0,0,0,0));
		txtCON.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtCON.setForeground(Color.BLUE);
		txtCON.setText("0");
		txtCON.setBorder(null);
		txtCON.setBackground(Color.ORANGE);
		txtCON.setBounds(83, 225, 84, 25);
		statsPane.add(txtCON);
		
		/**
		 * Creates the Label for Dex
		 */	
		JLabel statsDEX = new JLabel("Dex");
		statsDEX.setFont(new Font("Tahoma", Font.BOLD, 17));
		statsDEX.setVerticalAlignment(SwingConstants.BOTTOM);
		statsDEX.setBounds(73, 300, 60, 25);
		statsPane.add(statsDEX);
		
		/**
		 * Creates the JTextField for the users Dex.
		 */	
		txtDEX = new JTextField();
		txtDEX.setEditable(false);
		txtDEX.setHorizontalAlignment(SwingConstants.LEFT);
		txtDEX.setMargin(new Insets(0,0,0,0));
		txtDEX.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtDEX.setForeground(Color.BLUE);
		txtDEX.setText("0");
		txtDEX.setBorder(null);
		txtDEX.setBackground(Color.ORANGE);
		txtDEX.setBounds(83, 325, 84, 25);
		statsPane.add(txtDEX);
		
		/**
		 * Create a JTextField for User's Input.
		 */
		InputField = new TextField();
		InputField.setBounds(0, 5, 666, 27);
		InputPane.add(InputField);
		InputField.setForeground(Color.BLACK);
		InputField.setBackground(Color.LIGHT_GRAY);
		if(Location == 0){		
		  /**This will be the first thing that the user will see on the screen.
			*Reason for location is for bugging purposes.
			*If for some reason this class gets called sometime during gameplay, this won't be appended
			*on the TextArea
			*/
			doc.insertString(doc.getLength(), "Type HELP to see list of helpful commands.\n", null);
			doc.insertString(doc.getLength(), "Stranger: Brave adventurer. What do they call you?\n", npcStyle);
			}
		
		/**
		 *This is where to InputField is calling the action listener to get the users input
		 */
		InputField.addActionListener(this);
		
	}
	
	/**
	 * This is where the input of the user is scanned and the story is called.
	 */
	public void actionPerformed(ActionEvent evt){			
		String text = InputField.getText();
		MainFrame.input = text;
		
		try {
			doc.insertString(doc.getLength(),"> " + userInfo.USER_NAME+": "+text+"\n", userStyle);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		if(text.equals("HELP"))
			helpCommands();
		else if(text.equals("EXIT"))
			exit();			
		else if(text.equals("MAP"))
			showMap();
		else if(text.equals("RENAME"))
			renameUser();
		//else if(text.equals("REPORT"))
		//	reportBug();
		else if(!text.equals("EXIT") && !text.equals("HELP") && !text.equals("MAP") && !text.equals("RENAME"))
	    	gotoStory(text);
		
		InputField.setText("");	    
	}	
	
	/**
	 * This method is called when the user answers the story questions
	 */
	public void gotoStory(String text){
		try {
			advent.Story(Location);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is called when the user input is "EXIT"
	 * It then brings up a yes or no question to make sure they are sure.
	 */
	public void exit(){			
		if (JOptionPane.showConfirmDialog(null, "Noble " + userInfo.USER_NAME + ", do you really wish to abandon us?", "Exit Game",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(1); 
		} else {
			
		}
	}
	
	/**
	 * This method is called when the user input is "RENAME"
	 * It will ask the user what their new name it and set a new String to USER_NAME
	 */
	public void renameUser(){
		String ans1 = JOptionPane.showInputDialog(userInfo.USER_NAME+", what would you like your new name to be?");		
		try {
			doc.insertString(doc.getLength(), userInfo.USER_NAME+", you have changed your name. Your new name is ", npcStyle);
			doc.insertString(doc.getLength(), ans1, userStyle);
			doc.insertString(doc.getLength(), ". You may continue where you left off.\n", npcStyle);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		userInfo.getUserName(ans1);
	}
	
	/**
	 * This method is called when the user input is "MAP"
	 * It will bring up the user's map instead of pressing the button
	 */
	public void showMap(){
		JFrame mapFrame = new JFrame ();
        JLabel maping = new JLabel(new ImageIcon(map.getImage()));
        mapFrame.setVisible(true);
        mapFrame.setResizable(false);
        mapFrame.setTitle("Map");
        mapFrame.setDefaultCloseOperation(mapFrame.DISPOSE_ON_CLOSE);
        mapFrame.setBounds(100, 100, 800, 800);
        mapFrame.add(maping);
        maping.setVisible(true);
	}
	
	/**
	 * This method allows the user to send feedback or report a bug/error directly
	 * from the interface. It uses the SendEmail class to send the message via a 
	 * SMTP server to a designated email address
	 */
	
// 	public void reportBug() {	
// 			  JPanel myPanel = new JPanel();
// 		      JTextField email = new JTextField(5);
// 		      JTextField bug = new JTextField(50);

// 		      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
// 		      myPanel.add(new JLabel("Email Address: "));
// 		      myPanel.add(email);
// 		      myPanel.add(new JLabel("Please briefly state the bug/error/feedback: \n"));
// 		      myPanel.add(bug);		      
		      

// 		      int result = JOptionPane.showConfirmDialog(null, myPanel, 
// 		               "Report Bug/Error/Feedback", JOptionPane.OK_CANCEL_OPTION);
		      
// 		      if (result == JOptionPane.OK_OPTION) {
// 		    	  SendEmail.sendEmailMethod(bug.getText(), email.getText());
// 		      }
	
// }
	
	/**
	 * This method is called when the user input is "HELP"
	 * It will bring up a new frame that shows a list of help commands
	 */
	public void helpCommands(){
		JFrame helpFrame = new JFrame ();
        JTextArea textAreaC = new JTextArea();
        textAreaC.setEditable(false); 
        textAreaC.setBackground(Color.WHITE);
        textAreaC.setForeground(Color.BLACK);
        textAreaC.setFont(new Font("Tahoma", 14, 14));
        textAreaC.setBounds(300,300,400,400);
        helpFrame.setVisible(true);
        helpFrame.setResizable(false);
        helpFrame.setTitle("Help Commands");
        helpFrame.setDefaultCloseOperation(helpFrame.DISPOSE_ON_CLOSE);
        helpFrame.setBounds(300, 300, 400, 400);
        helpFrame.add(textAreaC);
		
        textAreaC.append("Type EXIT to quit.\n");
        textAreaC.append("Type MAP to bring out your map.\n");
        textAreaC.append("Type REPORT to report a bug/error or provide feedback.\n");
        textAreaC.append("Type RENAME to change your name.\n");
	}	
}
