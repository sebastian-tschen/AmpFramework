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
		
		
		JLabel byteLabel = new JLabel(this.getName() + " <"+this.getArgumentTypeName()+">: ");
		tempPanel.add(byteLabel);
		
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
	public void parseInput() throws InvalidArgumentValueException {
		
		try {
			this.argByte = Byte.decode(byteText.getText());
			System.out.println("decode");
			return;
		} catch (NumberFormatException e) {
			// not decodable as hex octal or decimal could be binary or char;
		}
		if (byteText.getText().toString().length() == 1) {
			if (byteText.getText().toString().charAt(0) < 127) {
				this.argByte = (byte) byteText.getText().charAt(0);
				return;
			}else{
				throw new InvalidArgumentValueException(byteText.getText() +" is not a valid ascii character");
			}
		}

		if (byteText.getText().length() == 8) {
			try {
				argByte = Byte.parseByte(byteText.getText(), 2);
				System.out.println("binary");
				return;
			} catch (NumberFormatException e) {
				throw new InvalidArgumentValueException(
				"the value you gave cannot be parsed!");
				
			}
		}

	}
}
