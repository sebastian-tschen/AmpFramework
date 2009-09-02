package guiButtons;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LED_Button extends JButton{

	private ImageIcon trueImage;
	private ImageIcon falseImage;
	private boolean buttonEnabled;
	
	public LED_Button(ImageIcon trueImage, ImageIcon falseImage, String actionCommand){
		super(falseImage);
		super.setActionCommand(actionCommand);
	}
	
	public void changeIcon(){
		super.setIcon(trueImage);
	}
}
