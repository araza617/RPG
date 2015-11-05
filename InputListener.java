import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

public class InputListener implements ActionListener {
	public static TextField InputField;
    public static JTextArea textArea;
    public static JTextPane textPane;

      public InputListener(){}
      
      public void InputListener(JTextArea tArea, TextField iField, JTextPane tPane){
          this.textArea = tArea;
          this.InputField = iField;
          this.textPane = tPane;
          InputField.addActionListener(this);
       }
      

      @Override
      public void actionPerformed(ActionEvent evt){			
  		String text = InputField.getText();
  		MainFrame.input = text;
  		try {
			MainFrame.doc.insertString(MainFrame.doc.getLength(), UserClass.USER_NAME+"> "+text+"\n", MainFrame.userStyle);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
  		InputField.setText("");
  	}	
      
}