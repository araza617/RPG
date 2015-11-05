
public class Rogue{

	public Rogue(){}
	
	//How much health does the user have, get/add/sub
			public void getUserHealth(){
				MainFrame.txtHEALTH.setText(""+25);
			}
			//How much con does the user have? This effect how much total health the user has
			public void getUserCon(){
				
				MainFrame.txtCON.setText(""+5);
			}
			//How much str does the user have? This effect how much the user will hit for
			//This is changed into intel for the mage class but means the same thing
			public void getUserStr(){
				MainFrame.txtSTR.setText(""+4);
			}
			//How much dex does the user have? This effects how often and how hard the user gets hit
			public void getUserDex(){
				MainFrame.txtDEX.setText(""+6);
			}
			//How much quick does the user have? This effects swing speed of a weapon, or how fast a mage can cast
			public void getUserQuick(){}
	
}
