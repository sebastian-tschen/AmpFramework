package container;

import java.util.ArrayList;
import java.util.Iterator;

import excpetions.ArraySizeDifferenceException;

public class TubePicture implements Iterable<Coordinate>{
	
	private ArrayList<Integer> yArray;
	private ArrayList<Integer> xArray;
	ArrayList<Coordinate> coords;

	public TubePicture(ArrayList<Integer> xArray,ArrayList<Integer> yArray) throws ArraySizeDifferenceException{
		
		if (xArray.size()!=yArray.size()){
			throw new ArraySizeDifferenceException("the two arrays do not have the same size");
		}
		
		this.xArray=xArray;
		this.yArray=xArray;

		coords= new ArrayList<Coordinate>();
		
		for (int i=0;i<xArray.size();i++){
			coords.add(new Coordinate(xArray.get(i),yArray.get(i)));
		}
		
	}

	@Override
	public Iterator<Coordinate> iterator() {
		
		return coords.iterator();
		
	}
	
	
	
	
	

}
