package main;

import gui.TubeShower;
import inputOutput.InputCollector;

public class TubeSimulator {
	
	public static void main(String[] args){
		
		
		TubeShower shower= new TubeShower();
		Thread ioThread=new Thread(new InputCollector(shower));
		Thread showerThread = new Thread(shower);
		
		ioThread.start();
		showerThread.start();
		
		
	}

}
