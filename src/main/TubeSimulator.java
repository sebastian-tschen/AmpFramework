package main;

import gui.TubeShower;
import gui.MainFrame;
import inputOutput.InputCollector;

public class TubeSimulator {
	
	public static void main(String[] args){
		
		
		MainFrame shower= new MainFrame();
		Thread ioThread=new Thread(new InputCollector(shower));
		Thread showerThread = new Thread(shower);
		
		ioThread.start();
		showerThread.start();
		
		
	}

}
