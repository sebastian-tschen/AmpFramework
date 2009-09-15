package intraController.picArgs;

import intraController.InvalidArgumentValueException;

import javax.swing.JPanel;

public class StringArgument extends PicArgument {

	String stringArg;
	byte[] stringArgBytes = null;

	// TODO nullByte is irgendwie anders glaub ich
	private byte nullByte = 0;

	@Override
	JPanel getArgumentInputPanal() {

//		hier darfst du froehlich das panel bauen...
		
		return null;
	}

	@Override
	void parseInput(Object o) throws InvalidArgumentValueException {

		// TODO das waere dann hauptsaechlich deins... bitte auch checken ob
		// alles ascii is und so, und falls irgendwas nicht in ordnung ist, eine
		// InvalidArgumentValueException schmeissen.

	}

	@Override
	byte[] getArgumentBytes() throws InvalidArgumentValueException {
		if (stringArgBytes == null) {
			throw new InvalidArgumentValueException(
					"This Argument has not yet been parsed correctly");
		}

		return stringArgBytes;
	}

	private byte[] stringToArrayOfByte(String string) {

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

	private byte charToByte(char c) {
		// TODO ka wie das geht grade...
		return 1;
	}

}
