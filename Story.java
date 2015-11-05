/**
 * Here is the story breakdown, giving a brief description of each Location
 * 
 * 1: Getting the user name. 
 * 			Should we limit name to a length of 1 or x amount of chars? if not, name will not fit at top bar, but will fit in textarea
 * 2: Getting the user class. This has an error check to make sure they only pick Warrior, Mage, Rouge.
 * 			Should we worry about lower/uppercase? Should we give them an option of typing name or number association?
 * 3: 
 * 
 * 4: 
 * 
 * 5: 
 */


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;


public class Story extends JPanel{
	InputListener listen = new InputListener(); //Constructor to take the users input if they had an invalid response
	UserClass userInfo = new UserClass(); //Constructor to get the users information, name, class, lvl, exp, str, hp...
	public static String TEXT; //This stores the MainFrame users input and uses this to append to the textArea
	public static int Location; //Stores the location from the MainFrame to take the user to the portion of the story
	public static JTextArea textArea; //textArea shows the story line and output of the user
	public static TextField InputField; //This is what the user inputs their answers in and we store this into the TEXT string
	public static JTextPane textPane;
	
	
	public Story(){
		this.textArea = MainFrame.textArea;
		this.InputField = MainFrame.InputField;
		this.textPane = MainFrame.textPane;
		
	}
	
	//This is where the story is, each location is a part of the story	
	public void Story(int location) throws BadLocationException{	
		this.Location = MainFrame.Location;
		this.TEXT = MainFrame.input;
		
		if(Location==0){	
			userInfo.getUserName(TEXT);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nStranger: What a noble name you have, "+userInfo.USER_NAME+".\n\n", MainFrame.npcStyle);
			
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "Stranger: Before we begin, I would like to introduce myself. My name is Rigorrif, son of Rendell. I", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), " come from a lineage of kings. My family used to live in a masssive kingdom named Enthridal", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), " until fourteen years ago, when a fleet of dragons took over our city. It is now my life's", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), " goal to reclaim my rightful kindgom and together, we'll bring order and happiness back to", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), " Enthridal.\n\n", MainFrame.npcStyle);

			MainFrame.doc.insertString(MainFrame.doc.getLength(), "Rigorrif: Now, which path would you like to embark on? You may choose ", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Warrior)", MainFrame.choiceStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), ", ", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Mage)", MainFrame.choiceStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), ", or ", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Rogue)", MainFrame.choiceStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), ".\n", MainFrame.npcStyle);
			MainFrame.Location++;
		}	
		
		
		if(Location==1){			
			userInfo.USER_CLASS = MainFrame.input.toUpperCase();	
				if(!MainFrame.input.toUpperCase().equals("WARRIOR") && !MainFrame.input.toUpperCase().equals("MAGE") && !MainFrame.input.toUpperCase().equals("ROGUE")){
					MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nRigorrif: Hmm, not sure what you mean by that, "+userInfo.USER_NAME+". It is my forefather's wishes", MainFrame.errorStyle);
					MainFrame.doc.insertString(MainFrame.doc.getLength(), " to have you serve as either a ", MainFrame.errorStyle);
					MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Warrior)", MainFrame.choiceStyle);
					MainFrame.doc.insertString(MainFrame.doc.getLength(), ", ", MainFrame.errorStyle);
					MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Mage)", MainFrame.choiceStyle);
					MainFrame.doc.insertString(MainFrame.doc.getLength(), ", or ", MainFrame.errorStyle);
					MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Rogue)", MainFrame.choiceStyle);
					MainFrame.doc.insertString(MainFrame.doc.getLength(), ".\n", MainFrame.errorStyle);
					MainFrame.InputField.setText("");
					listen.InputListener(textArea, InputField, textPane);
				}			
			userInfo.getUserClass(TEXT.toUpperCase());	
			userInfo.getUserExp();
			userInfo.getNeededXp();
			userInfo.getUserHealth();
			userInfo.getUserStr();
			userInfo.getUserCon();
			userInfo.getUserDex();
			if(MainFrame.input.toUpperCase().equals("WARRIOR")) {
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nRigorrif: Ah, a warrior. I sense a brave heart and ambition, " + userInfo.USER_NAME + ". As they say, the pen is mighter than the sword, except when the sword is sharp.\n", MainFrame.npcStyle);
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "Rigorrif hands you a sharpened, steel sword with a broad shield.\n", MainFrame.actionStyle);
			}
			else if(MainFrame.input.toUpperCase().equals("MAGE")) {
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nRigorrif: A wizard, huh? Holding the power of the universe infused with nature's will is no joke. I pray you use it for good alone, " + userInfo.USER_NAME + ".\n", MainFrame.npcStyle);
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "Rigorrif hands you a wooden staff, blue robes, and a wizard's hat.\n", MainFrame.actionStyle);
			}
			else if(MainFrame.input.toUpperCase().equals("ROGUE")) {
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nRigorrif: Ah, a rogue. As many before you, " + userInfo.USER_NAME + ", I see you also hold the desire to move swiftly amongst the shadows of the world, which lurk not far behind.", MainFrame.npcStyle);
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nRigorrif hands you a bronze rapier and a leather tunic.\n", MainFrame.actionStyle);
			}
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nPress Enter to continue...\n", MainFrame.npcStyle);	
			MainFrame.Location++;
		}	
		

			if(Location==2) {	
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "\n" + userInfo.USER_NAME + ", it is a three day journey to Enthridal by horse. We must travel light and quick. This is Nightangle; you", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), " will ride her along side with me.\n", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "Rigorrif hands you the reigns to a large horse with beautiful, black fur and hazlenut eyes.\n", MainFrame.actionStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nWhat would you like to do? ", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Mount) ", MainFrame.choiceStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "Nightangle or ", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Feed) ", MainFrame.choiceStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "Nightangle a carrot.\n", MainFrame.npcStyle);
			MainFrame.Location++;
		}
			
		if(Location==3) {
	        String mountOrFeed = MainFrame.input.toUpperCase();
	        switch(mountOrFeed) {
            case "FEED": 
            MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nYou offer Nightangle a brittled but tasty carrot. She munches it gracefully.", MainFrame.actionStyle);
            MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nRigorrif: Hurry now, " + userInfo.USER_NAME + ". We do not have much time to spare.\n", MainFrame.npcStyle);

            case "MOUNT": 
            MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nYou mount carefully on Nightangle. She gives a slight neigh and begins to slowly trotter.", MainFrame.actionStyle);
            break;

            default:
            MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nRigorrif: Hmm. Not sure what you mean, " + userInfo.USER_NAME + ". Quick now. We do not have much time to spare", MainFrame.npcStyle);
            MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nYou heed Rigorrif's advice and quickly mount on Nightangle. She gives a slight neigh and begins to slowly trotter.\n", MainFrame.actionStyle);
        }
	        
		MainFrame.doc.insertString(MainFrame.doc.getLength(), "\n\nPress Enter to continue...\n", MainFrame.npcStyle);	
		MainFrame.Location++;
		}
			
		if(Location==4) {
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nYou ride through the grassy plains with Rigorrif leading up ahead. As night falls, an overwhelming feeling of hunger and sleep travels through your body.", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "Do you want to ask Rigorrif to ", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Rest) ", MainFrame.choiceStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "or ", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Continue) ", MainFrame.choiceStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "riding?\n", MainFrame.npcStyle);
			MainFrame.Location++;
		}
		
		if(Location==5) {
	        String restOrCont = MainFrame.input.toUpperCase();
	        if(restOrCont.equals("REST")) {
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nRigorrif: There is no time to rest, " + userInfo.USER_NAME + ". We must continue to ride out the night.", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nYou feel a sudden urge of anger intermigled with your hunger and sleep.", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), " Would you like to  ", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Urge) ", MainFrame.choiceStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "Rigorrif to stop or ", MainFrame.npcStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "(Continue) ", MainFrame.choiceStyle);
			MainFrame.doc.insertString(MainFrame.doc.getLength(), "riding?\n", MainFrame.npcStyle);
			
			
			// This is the part where I can't get it to detect the urgeOrCont variable
			listen.InputListener(textArea, InputField, textPane);
			String urgeOrCont = MainFrame.input.toUpperCase();
			if(urgeOrCont.equals("URGE")) {
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nRigorrif: I have already told you once, " + userInfo.USER_NAME + ". We must ride out the night.", MainFrame.npcStyle);
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nYou continue to ride through the night, as the stars align up ahead. You fear Rigorrif may be right: hunger and sleep may soon be the least of your worries.\n", MainFrame.actionStyle);
			} else if(urgeOrCont.equals("CONTINUE")) 
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "\n(Inside)You continue to ride through the night, as the stars align up ahead. You fear hunger and sleep may soon be the least of your worries.\n", MainFrame.actionStyle);
			else 
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "\n The sleep seems to have impaired your responsiveness. You continue to ride through the night, as the stars align up ahead. You fear hunger and sleep may soon be the least of your worries.\n", MainFrame.actionStyle);
			
			
	        }
	   		
	       else if(restOrCont.equals("CONTINUE")) {
				MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nYou continue to ride through the night, as the stars align up ahead. You fear Rigorrif may be right: hunger and sleep may soon be the least of your worries.\n", MainFrame.actionStyle);
	       } else {
		   MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nThe sleep seems to have impaired your responsiveness. You continue to ride through the night, as the stars align up ahead. You fear hunger and sleep may soon be the least of your worries.\n", MainFrame.actionStyle);
	       }
		MainFrame.doc.insertString(MainFrame.doc.getLength(), "\nPress Enter to continue...\n", MainFrame.npcStyle);	
	    MainFrame.Location++;
		}
	
	
	  if(Location==6) {
		
	  }
		
	}
}

	
	
	

