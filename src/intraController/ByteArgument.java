package intraController;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import intraController.picArgs.PicArgument;

public class ByteArgument extends PicArgument {

	private Byte argByte;
	ButtonGroup group;
	JTextField byteText;
	
	public ByteArgument(String name) {
		super(name, "Byte");
		argByte = null;

	}

	@Override
	public JPanel createArgumentInputPanel() {
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(2, 3));
		group = new ButtonGroup();
		
		JRadioButton choice = new JRadioButton("Bin");
		choice.setActionCommand("Bin");
		group.add(choice);
		tempPanel.add(choice);
		
		choice = new JRadioButton("Hex");
		choice.setActionCommand("Hex");
		group.add(choice);
		tempPanel.add(choice);
		
		JLabel byteLabel = new JLabel(this.getName() + " <"+this.getArgumentTypeName()+">: ");
		tempPanel.add(byteLabel);
		
		choice = new JRadioButton("Dez");
		choice.setActionCommand("Dez");
		group.add(choice);
		tempPanel.add(choice);
		
		choice = new JRadioButton("ASCII");
		choice.setActionCommand("ASCII");
		group.add(choice);
		tempPanel.add(choice);

		byteText = new JTextField(6);
		tempPanel.add(byteText);
		
		return tempPanel;
	}

	@Override
	public byte[] getArgumentBytes() throws InvalidArgumentValueException {
		if (argByte == null) {
			throw new InvalidArgumentValueException(
					"This Argument has not yet been parsed correctly");
		}

		return new byte[] { argByte.byteValue() };
	}

	@Override
	public void parseInput(Object o) throws InvalidArgumentValueException {
		ButtonModel selected = group.getSelection();
		System.out.println("Byte:");
		String command = selected.getActionCommand();
		String thisString = byteText.getText();
		byte thisByte;
		System.out.println(command);
		if(command.equals("Bin")){
			if(thisString.length() == 8){
				thisByte = 0;
				for(int i = thisString.length()-1, j = 1; i >= 0; i--, j *= 2){
					if(thisString.charAt(i) == ('1')){
						thisByte += j;
					}
				}
			}
			else {
				throw new InvalidArgumentValueException("Ungültige Einagbe");
			}
		}
		else if(command.equals("Hex") && thisString.length() == 4){
			
		}
		else if(command.equals("Dez") && thisString.length() < 4){
			
		}
		else if(command.equals("ASCII")){
			thisByte = 0;
			
		}
		System.out.println("\n");
		
		try {
			this.argByte = Byte.decode(o.toString());
			System.out.println("decode");
			return;
		} catch (NumberFormatException e) {
			// not decodable as hex octal or decimal could be binary or char;
		}
		if (o.toString().length() == 1) {
			if (o.toString().charAt(0) < 127) {
				this.argByte = (byte) o.toString().charAt(0);
				return;
			}else{
				throw new InvalidArgumentValueException(o.toString() +" is not a valid ascii character");
			}
		}

		if (o.toString().length() == 8) {
			try {
				argByte = Byte.parseByte(o.toString(), 2);
				System.out.println("binary");
				return;
			} catch (NumberFormatException e) {
				throw new InvalidArgumentValueException(
				"the value you gave cannot be parsed!");
				
			}
		}

	}
}
