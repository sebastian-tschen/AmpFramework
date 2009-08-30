package main;

import gui.MainFrame;
import inputOutput.InputCollector;
import container.ListContainer;

public class TubeSimulator {
	
	public static void main(String[] args){
		
		
		
		ListContainer container=new ListContainer();
		MainFrame shower= new MainFrame(container);
		Thread showerThread = new Thread(shower);
		showerThread.setName("Shower Thread");
		Thread ioThread=new Thread(new InputCollector(container));
		ioThread.setName("I/O Thread");
		
		ioThread.start();
		showerThread.start();
		
		
	}

}
