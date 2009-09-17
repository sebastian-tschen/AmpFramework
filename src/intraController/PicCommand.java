package intraController;

import intraController.picArgs.PicArgument;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface PicCommand.
 */
public abstract class PicCommand {

	private final byte commandByte;
	private final String name;

	protected PicCommand(byte commandByte, String name) {
		this.commandByte = commandByte;
		this.name = name;
	}

	/**
	 * Gets the arguments.
	 * 
	 * @return the arguments
	 */
	public abstract ArrayList<PicArgument> getArguments();

	/**
	 * Gets the command in form of an array of byte this is the exact
	 * representation of the command that is send to the pic.
	 * 
	 * @return the command as bytecode.
	 * 
	 * @throws CommandIntegrityException
	 *             if the command is not ready to use in the current form.
	 * 
	 */
	public byte[] getByteCodeCommand() throws CommandIntegrityException {

//		tryIntegrity();
		
		ArrayList<Byte> charList = new ArrayList<Byte>();

		for (PicArgument arg : this.getArguments()) {
			
			try {
				arg.parseInput();
				for (byte c : arg.getArgumentBytes()) {
					charList.add(c);
				}
			} catch (InvalidArgumentValueException e) {
				throw new CommandIntegrityException(
						"one of the arguments won't parse: " + e.getMessage());
			}
		}
		byte[] bytes = new byte[charList.size()];

		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = charList.get(i);
		}

		return bytes;

	}

	/**
	 * checks whether the command is currently in a usable form, hence, all
	 * necessary arguments are set and the command can be generated. returns if
	 * everything is ok. please use this befor giving me an command. Or i might
	 * not be able to send it at all and you won't even know i didn't send it.
	 * 
	 * @throws CommandIntegrityException
	 *             if the command is not ready to use in the current form.
	 */
	public abstract void tryIntegrity() throws CommandIntegrityException;

	public String getName() {
		return name;
	}

	public String toString() {
		return this.name;
	}
}
