package inputOutput;

import gui.MainFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import container.ListContainer;
import container.TheList;

public class InputCollector implements Runnable {

	private Object lastPicture;
	private ListContainer listContainer;

	// private TubeShower tube;
	//
	// public InputCollector(TubeShower tube) {
	// this.tube = tube;
	// }

	public InputCollector(ListContainer listContainer) {

		this.listContainer = listContainer;

	}

	@Override
	public void run() {

		BufferedReader reader = null;
		reader = new BufferedReader(new InputStreamReader(
				System.in));
		while (true) {

			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
			
			if (line == null || line.equals("")) {
				System.err.println("line =="+line);
				continue;
			}
			String[] coords = line.split(";");
			ArrayList<Integer> xArray = new ArrayList<Integer>();
			ArrayList<Integer> yArray = new ArrayList<Integer>();
			try {
				for (String string : coords) {
					if (string != null && !string.equals("")) {
						xArray.add((Integer.parseInt(string.split(" ")[0]))/2);
						yArray
								.add((255 - Integer
										.parseInt(string.split(" ")[1]))/2);
					}
				}

			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
				continue;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println(e.getMessage());
				continue;
			}

			TheList pic=new TheList();
			for (int i = 0; i < xArray.size(); i++) {
				pic.add(xArray.get(i), yArray.get(i));
			}
			
//TODO checken ob bild dasselbe wie vorher;
			
			
			synchronized (this.listContainer) {
				listContainer.setNewList(true);
				listContainer.setList(pic);
				listContainer.notifyAll();
			}
			
			

		}

	}
}
