
public class UserClass {
	public static int USER_LEVEL;
	public static int USER_EXP;
	public static int NEEDED_XP;
	public static String USER_NAME = "User";
	public static String USER_CLASS = "Young Boy";
	//Warrior warrior = new Warrior();
	Warrior warrior = new Warrior();
	Mage mage = new Mage();
	Rogue rogue = new Rogue();
	

	public UserClass(){}
	
	public void UserClass(){}
	
	//Who they want to play, ie, calling what class type
	public void getUserClass(String text){
		this.USER_CLASS = text;
		MainFrame.txtClass.setText(USER_CLASS);
	}
	
	//How much experience does the user have, get/add/sub, which is shown next to needed xp
	public void getUserExp(){
		this.USER_EXP = 0;
		MainFrame.txtXP.setText(USER_EXP+"/"+NEEDED_XP);
	}
	
	//How much experience does the user need before obtaining next level
		public void getNeededXp(){
			this.NEEDED_XP = 30;
			MainFrame.txtXP.setText(USER_EXP+"/"+NEEDED_XP);
		}
	
	//This will get the users name
	public void getUserName(String text){
		this.USER_NAME = text;
		MainFrame.txtUser.setText(USER_NAME);
	}
	
	//This will take in the experience gained or loss to calculate the users level
	public void getUsersLevel(){
		MainFrame.txtLevel.setText(""+USER_LEVEL);
	}
	
	
	
	
	/**
	 * Here I am creating base methods that will call their intended USER_CLASS class until we figure out how to call
	 * the USER_CLASS class without doing so.
	 */
	
	
	//How much health does the user have, get/add/sub
	public void getUserHealth(){
		if(USER_CLASS.equals("WARRIOR")){
			warrior.getUserHealth();
		}
		if(USER_CLASS.equals("MAGE")){
			mage.getUserHealth();
		}
		if(USER_CLASS.equals("ROGUE")){
			rogue.getUserHealth();
		}
		
	}
	//How much con does the user have? This effect how much total health the user has
	public void getUserCon(){
		if(USER_CLASS.equals("WARRIOR")){
			warrior.getUserCon();
		}
		if(USER_CLASS.equals("MAGE")){
			mage.getUserCon();
		}
		if(USER_CLASS.equals("ROGUE")){
			rogue.getUserCon();
		}
	}
	//How much str does the user have? This effect how much the user will hit for
	//This is changed into intel for the mage class but means the same thing
	public void getUserStr(){
		if(USER_CLASS.equals("WARRIOR")){
			warrior.getUserStr();
		}
		if(USER_CLASS.equals("MAGE")){
			mage.getUserStr();
		}
		if(USER_CLASS.equals("ROGUE")){
			rogue.getUserStr();
		}
	}
	//How much dex does the user have? This effects how often and how hard the user gets hit
	public void getUserDex(){
		if(USER_CLASS.equals("WARRIOR")){
			warrior.getUserDex();
		}
		if(USER_CLASS.equals("MAGE")){
			mage.getUserDex();
		}
		if(USER_CLASS.equals("ROGUE")){
			rogue.getUserDex();
		}
	}
	//How much quick does the user have? This effects swing speed of a weapon, or how fast a mage can cast
	public void getUserQuick(){}
	
	
	
}
