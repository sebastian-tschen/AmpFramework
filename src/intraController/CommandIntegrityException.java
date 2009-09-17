package intraController;

/**
 * The Class CommandIntegrityException.
 * 
 * This exeption should be thrown when the PicCommand is not ready to use in the
 * current form. The reason for this should be given in the getMessage() string.
 */
public class CommandIntegrityException extends Exception {

	public CommandIntegrityException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5059549961703939035L;

}
