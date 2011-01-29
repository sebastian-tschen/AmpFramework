package tests;

import intraController.InvalidArgumentValueException;
import intraController.picArgs.PicArgument;

import java.util.ArrayList;

import commandCenter.TestCommand;

import gui.MainFrame;
import container.TheList;
import container.ListContainer;

public class start {

	/**
	 * @param args
	 */
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// MainFrame myFrame = new MainFrame(new ListContainer());
	// Thread showerThread = new Thread(myFrame);
	// showerThread.start();
	// TheList list = new TheList();
	// for(int i = 0; i < 128; i++){
	// for(int j = 0; j < 128; j++){
	// list.add(i, j);
	// }
	// }
	// myFrame.setKoords(list);
	// }

	public static void main(String[] args) {

		
		
		TestCommand comm = TestCommand.getInstance();

		ArrayList<PicArgument> commArgs = comm.getArguments();
		for (int i = 0; i < args.length; i++) {

			try {
//				commArgs.get(i).parseInput(args[i]);
				commArgs.get(i).parseInput();
				for (byte b : commArgs.get(i).getArgumentBytes()) {
					char x = new Character((char) new Byte(b).intValue());
					System.out.print(x);
				}
				System.out.println();
			} catch (InvalidArgumentValueException e) {
				e.printStackTrace();
			}

		}
		
		
		

	}
}
