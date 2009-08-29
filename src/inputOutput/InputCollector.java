package inputOutput;

import excpetions.ArraySizeDifferenceException;
import gui.TubeShower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import container.TubePicture;

public class InputCollector implements Runnable {

	private TubeShower shower;

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
		while (true) {

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));

			int line = null;
			try {
				line = reader.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
			if (line == null || line.equals("")) {
				if (line == null) {
					System.out.println("null");
				} else {
					System.out.println("nothing");
				}
				continue;
			}
			System.out.println("found some");
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
				// number format?? better use next line
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

			// shower.setPicture(pic);

		}

	}
}
