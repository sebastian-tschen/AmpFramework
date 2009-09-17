package commandCenter;

import intraController.PicCommand;

import java.util.HashSet;

public class start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashSet<PicCommand> commands = new HashSet<PicCommand>();
		commands.add(TestCommand.getInstance());
		commands.add(TestCommand2.getInstance());
		
		GodsEar myEar = new GodsEar();
		MainFrame myFrame = new MainFrame(myEar, commands);
		myEar.setFrame(myFrame);

	}

}
