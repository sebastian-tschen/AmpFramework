package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import container.TubePicture;
import excpetions.ArraySizeDifferenceException;
import gui.TubeShower;
import inputOutput.InputCollector;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		run();
		
	}
	
	
	public static void run(){


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
			System.out.println(line);
		}

	}

}
