package guiButtons;

import java.awt.event.*;

public class ButtonListener implements ActionListener{
	
	public ButtonListener(){
		
	}

	public void actionPerformed(ActionEvent event) {
		String buttonNo = event.getActionCommand();

		if(buttonNo.equals("one")){
			buttonOne();
		}
		else if(buttonNo.equals("two")){
			buttonTwo();
		}
		else if(buttonNo.equals("three")){
			buttonThree();
		}
		else if(buttonNo.equals("four")){
			buttonFour();
		}
		else if(buttonNo.equals("five")){
			buttonFive();
		}
		else if(buttonNo.equals("six")){
			buttonSix();
		}
	}

	private void buttonOne() {
		System.out.println("Button one pressed");
		
	}

	private void buttonTwo() {
		System.out.println("Button two pressed");
		
	}

	private void buttonThree() {
		System.out.println("Button three pressed");
		
	}

	private void buttonFour() {
		System.out.println("Button four pressed");
		
	}

	private void buttonFive() {
		System.out.println("Button five pressed");
		
	}

	private void buttonSix() {
		System.out.println("Button six pressed");
		
	}
}
