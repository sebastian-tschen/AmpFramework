package intraController.picArgs;

import intraController.InvalidArgumentValueException;

import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class PicArgument.
 */
abstract public class PicArgument {

	/**
	 * Gets the argument input panal which can be placed directly on the window.
	 * Ich hoffe JPanel is hier die richtige rueckgabeklasse... ich dachte halt
	 * an irgendwas, dass man immer auf das hauptfenster packen kann. Nach
	 * beduerfnissen auch einfach aendern!
	 * 
	 * @return the argument input panal
	 */
	public abstract JPanel createArgumentInputPanel();

	/**
	 * Parses the input from the panel it previously gave. Vielleicht muss man
	 * ihm garnix geben, und er versucht die infos aus dem panel object zu
	 * holden das er ja sowieso schon hat. ich glaub das is besser... kannst du
	 * mal aendern dass die methode keine argumente hat.
	 * 
	 * @param o
	 *            the Object that it might need to parse the data. Vielleicht
	 *            braucht es das nicht... siehe oben
	 * 
	 * @throws InvalidArgumentValueException
	 *             if the input is not what the object expects or needs.
	 *             (klassischerweise, wenn ein string im feld steht wo er einen
	 *             char oder eine zahl erwartet, oder aber das feld ganz lehr
	 *             is)
	 */
	abstract void parseInput(Object o) throws InvalidArgumentValueException;

	/**
	 * Gets the argument bytes.
	 * 
	 * @return the argument in form of an array of byte.
	 * 
	 * @throws InvalidArgumentValueException
	 *             when the internal state of this object does not suffice to
	 *             create the argument (yet?)
	 */
	abstract byte[] getArgumentBytes() throws InvalidArgumentValueException;

}
