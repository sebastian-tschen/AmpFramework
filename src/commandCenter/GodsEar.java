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
		String command = event.getActionCommand();
		System.out.println(command);
	
		if(command.equals("comboBoxChanged")){
			myFrame.changeFields();
		}
		else{
			String test = "0010";
			for(int i = 0; i < test.length(); i++){
				if(test.charAt(i) == '1'){
					System.out.println(true);
				}
				else{
					System.out.println(false);
				}
			}
			//myFrame.sendBytes();
		}
	}

	public void setFrame(MainFrame newFrame){
		myFrame = newFrame;
	}

}
