package intraController.picArgs;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import intraController.InvalidArgumentValueException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StringArgument extends PicArgument {

	JTextField stringText;
	
	public StringArgument(String name) {
		super(name,"String");
	}

	String stringArg;
	byte[] stringArgBytes = null;

	// TODO nullByte is irgendwie anders glaub ich
	private byte nullByte = 0;

	@Override
	public JPanel createArgumentInputPanel() {
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(2,1));
		JLabel stringLabel = new JLabel(this.getName() + " <"+this.getArgumentTypeName()+">: ");
		tempPanel.add(stringLabel);
		stringText = new JTextField(10);
		tempPanel.add(stringText);
		return tempPanel;
	}

	@Override
	public void parseInput(Object o) throws InvalidArgumentValueException {

		// TODO das waere dann hauptsaechlich deins... bitte auch checken ob
		// alles ascii is und so, und falls irgendwas nicht in ordnung ist, eine
		// InvalidArgumentValueException schmeissen.
		System.out.println("String:");
		System.out.println(stringText.getText());
		System.out.println("\n");
		
		byte[] writtenString = stringText.getText().getBytes();
		
		try {
			stringArgBytes = stringToArrayOfByte(o.toString());
		} catch (NumberFormatException e) {

			throw new InvalidArgumentValueException(
					"This string cannot be converted to ASCII for some reason. Maybe there are non asci characters used in it");
		}
	}

	@Override
	public byte[] getArgumentBytes() throws InvalidArgumentValueException {
		if (stringArgBytes == null) {
			throw new InvalidArgumentValueException(
					"This Argument has not yet been parsed correctly");
		}

		return stringArgBytes;
	}

	private byte[] stringToArrayOfByte(String string)
			throws NumberFormatException {

		// Das is ganz lustig... ein string is in C immer "nullTerminiert". Das
		// heisst, dass er (um das ende ueberhaupt erkennen zu koennen) am ende
		// des strings noch einen zusaetzlichen 'nullByte' char hat. Den wuerde
		// ich gerne hier auch mit reinmachen, da ich dann im controller mit
		// String bibliotheken arbeiten kann.

		byte[] bytes = new byte[string.length() + 1];

		for (int i = 0; i < string.length(); i++) {
			bytes[i] = charToByte(string.charAt(i));
		}

		bytes[string.length()] = nullByte;

		return bytes;

	}

	private byte charToByte(char c) throws NumberFormatException {
		
//		System.out.println(c);
		if (c>127){
			throw new NumberFormatException();
		}
		
		return (byte) c;
	}

}
