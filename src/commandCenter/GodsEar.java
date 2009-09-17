package commandCenter;

import intraController.CommandIntegrityException;
import intraController.PicCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GodsEar implements ActionListener {

	MainFrame myFrame;
	
	public GodsEar(){
		
	}
	
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
//		System.out.println(command);
	
		if(command.equals("comboBoxChanged")){
			myFrame.changeFields();
		}
		
		try {
			String s = new String(((PicCommand)myFrame.combo.getSelectedItem()).getByteCodeCommand());
			System.out.println(s);
		} catch (CommandIntegrityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		((PicCommand)myFrame.combo.getSelectedItem())command.
		
	}

	public void setFrame(MainFrame newFrame){
		myFrame = newFrame;
	}

}
