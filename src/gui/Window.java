package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.Box.Filler;

public class Window extends JPanel{

	private int height;
	private int width;
	private TheList list;;
	private int size;
	
	public Window(int newHeight, int newWidth){
		height = newHeight;
		width = newWidth;
		list = new TheList();
	}
	
	public void paintComponent(Graphics gr){
		Graphics2D gr2D = (Graphics2D) gr;
		gr2D.setColor(Color.WHITE);
		gr2D.fillRect(0, 0, width+2, height+2);
		gr2D.setColor(Color.BLACK);
		gr2D.drawOval(0, 0, width+2, height+2);
		list.setSize(size);
		list.paintAll(gr2D);
	}

	public void setSize(int newSize) {
		size = newSize;
	}

	public void setList(TheList newList) {
		list = newList;
		
	}
}
