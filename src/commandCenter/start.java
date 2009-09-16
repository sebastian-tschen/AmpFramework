package commandCenter;

import intraController.PicCommand;

import java.util.ArrayList;

public class start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<PicCommand> commands = new ArrayList<PicCommand>();
		commands.add(new TestCommand("Command 1"));
		commands.add(new TestCommand("Command 2"));
		commands.add(new TestCommand("Command 3"));
		
		GodsEar myEar = new GodsEar();
		MainFrame myFrame = new MainFrame(myEar, commands);
		myEar.setFrame(myFrame);

	}

}
