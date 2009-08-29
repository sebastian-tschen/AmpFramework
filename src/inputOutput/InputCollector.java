package inputOutput;

import excpetions.ArraySizeDifferenceException;
import gui.TubeShower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import container.TubePicture;

public class InputCollector implements Runnable {

	private TubeShower shower;
	private Object lastPicture;

	// private TubeShower tube;
	//
	// public InputCollector(TubeShower tube) {
	// this.tube = tube;
	// }

	public InputCollector(TubeShower shower) {

		this.shower = shower;

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
						xArray.add(Integer.parseInt(string.split(" ")[0]));
						yArray
								.add(255 - Integer
										.parseInt(string.split(" ")[1]));
					}
				}

			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
				continue;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println(e.getMessage());
				continue;
			}
			TubePicture pic = null;
			try {
				pic = new TubePicture(xArray, yArray);
			} catch (ArraySizeDifferenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
			
			if (!pic.equals(this.lastPicture)){
				lastPicture=pic;
				shower.setPicture(pic);
			}

		}

	}
}
