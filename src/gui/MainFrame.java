package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MainFrame extends JFrame {
	
	private Window window;
	private TheList list;
	private int size;
		
	public MainFrame(){
		super("Häupling Falsche Röhre");
		size = 5;
		list = new TheList();
		
		createUI();
		
		window = new Window(128*size, 128*size);
		window.setSize(size);
		
		add(window, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(128*size+11, 128*size+30);
		setVisible(true);
	}
		
	private void createUI(){
		
	}
	
	public void setKoords(TheList newList){
		list = newList;
		window.setList(list);
	}

}
