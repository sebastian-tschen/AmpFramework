package tests;

import gui.TubeShower;
import inputOutput.InputCollector;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TubeShower shower= new TubeShower();
		Thread ioThread=new Thread(new InputCollector(shower));
		Thread showerThread = new Thread(shower);
		
		ioThread.start();
		
		showerThread.start();
		
		System.out.println("started InputCollector");
		
		
		
	}

}
