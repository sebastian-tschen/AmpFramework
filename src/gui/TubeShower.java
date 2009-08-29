package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import container.Coordinate;
import container.TubePicture;

public class TubeShower implements Runnable{
	
	private TubeCanvas canvas;
	
	@Override
	public void run() {
		
		TubePicture blank = null;
		try {
			blank = new TubePicture(new ArrayList<Integer>(), new ArrayList<Integer>());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}

		JFrame mainFrame=new JFrame("TubeSimulator");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(400,400);
		canvas = new TubeCanvas(blank);
		mainFrame.getContentPane().add(canvas);
		
		mainFrame.setVisible(true);
		
	}
	
	public void setPicture(TubePicture pic){
		if (this.canvas!=null){
			this.canvas.setPicture(pic);
		}
	}
	
	class TubeCanvas extends Canvas{
		
		private TubePicture picture;
		
		

		public TubeCanvas(TubePicture blank) {
			this.picture=blank;
		}

		public void paint(Graphics graphics){

			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, 256, 256);
			graphics.setColor(Color.red);
			graphics.drawArc(0, 0, 256, 256,0,360);
			graphics.setColor(Color.green);
			for (Coordinate coord : picture) {
				System.out.println(coord.getX()+" "+coord.getY()+" ;");
				graphics.drawArc(coord.getX(), coord.getY(), 3, 3, 0, 360);
				graphics.fillArc(coord.getX(), coord.getY(), 3, 3, 0, 360);
			}
			
			
		}
		
		public void setPicture(TubePicture pic){
			
			this.picture=pic;
			this.repaint();
			
		}
		
	
	}

	
	
	
	
}
