/*
 * @author frederic und sebastian
 */
package intraController;

/**
 * The Class InvalidArgumentValueException.
 * 
 * This Exception should be thrown when the input for an Argument cannot be
 * parsed or is in any way unvalid.
 * 
 * @author frederic und sebastian
 */
public class InvalidArgumentValueException extends Exception {

	public InvalidArgumentValueException(String string) {
		super(string);
	}

}
