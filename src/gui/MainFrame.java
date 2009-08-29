package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MainFrame extends JFrame implements Runnable{
	
	private Window window;
	private TheList list;
	private int size;
	private final int PIXEL = 128;
		
	public MainFrame(){
		super("Häuptling Falsche Röhre");
		size = 5;
		list = new TheList();
		
		createUI();
		
		window = new Window(PIXEL);
		window.setSize(size);
		
		add(window, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(PIXEL*size+11, PIXEL*size+30);
		setVisible(true);
	}
		
	private void createUI(){
		
	}
	
	public void setKoords(TheList newList){
		list = newList;
	}

	public void run() {
		while(true){
			reSize(window.getSize());
			window.setSize(size);
			window.setList(list);
			window.repaint();
		}
	}

	private void reSize(Dimension bounds) {
		int x = bounds.height;
		int y = bounds.width;
		double square;
		if(x < y){
			square = x;
		}
		else{
			square = y;
		}
		size = (int)square / PIXEL;
		if(size < 2){
			size = 2;
		}
		System.err.println(size);
	}

}
