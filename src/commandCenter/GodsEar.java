package commandCenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GodsEar implements ActionListener {

	MainFrame myFrame;
	
	public GodsEar(){
		
	}
	
	
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getActionCommand());
		myFrame.changeFields();
	}

	public void setFrame(MainFrame newFrame){
		myFrame = newFrame;
	}

}
