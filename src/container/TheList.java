package container;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class TheList {
	
	ArrayList<Koord> koords;
	public int size;
	
	public TheList(){
		koords = new ArrayList<Koord>();
		size = 3;
	}
	
	public void add(int x, int y){
		koords.add(new Koord(x, y));
	}
	
	public void setSize(int newSize){
		size = newSize;
	}
	
	public void paintAll(Graphics2D gr2D){
		for(Koord temp : koords){
			if(outOfRange(temp)){
				gr2D.setColor(Color.RED);
			}
			else{
				gr2D.setColor(Color.GREEN);
			}
			gr2D.fillOval(temp.x*size+1, temp.y*size+1, size, size);
		}
	}
	
	public boolean outOfRange(Koord koord){
		int middle = (128*size)/2;
		double x = middle - size/2 - koord.x*size;
		double y = middle - size/2 - koord.y*size;
		double eins = Math.pow(x, 2);
		double zwei = Math.pow(y, 2);
		int test = (int) Math.sqrt(eins+zwei);
		if(middle <= test){
			return true;
		}
		return false;
	}
}
