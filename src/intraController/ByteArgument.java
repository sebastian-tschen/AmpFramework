package intraController;

import javax.swing.JPanel;

import intraController.picArgs.PicArgument;

public class ByteArgument extends PicArgument {

	private Byte argByte;

	public ByteArgument(String name) {
		super(name, "Byte");
		argByte = null;

	}

	@Override
	public JPanel createArgumentInputPanel() {
		// TODO Auto-generated method stub
		return null;
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
