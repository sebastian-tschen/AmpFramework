package main;

import gui.MainFrame;
import inputOutput.InputCollector;
import inputOutput.NetworkInputCollector;

import java.io.IOException;
import java.net.ServerSocket;

import pinSimulator.PinSimulator;

import container.ListContainer;

public class TubeSimulator {
	
	public static void main(String[] args) throws IOException{
		
		
		
		ServerSocket socket = new ServerSocket(12345);
		
		ListContainer container=new ListContainer();
		MainFrame shower= new MainFrame(container);
		Thread showerThread = new Thread(shower);
		showerThread.setName("Shower Thread");
//		Thread ioThread=new Thread(new InputCollector(container));
		Thread ioThread=new Thread(new NetworkInputCollector(container,socket));
		ioThread.setName("I/O Thread");
		
		PinSimulator pin = new PinSimulator();
		Thread pinThread = new Thread(pin);
		pinThread.setName("Pin Thread");
		
		pinThread.start();
		ioThread.start();
		showerThread.start();
		
		
	}

}
