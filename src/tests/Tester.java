package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import picIntegration.PicThread;

public class Tester {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {


		
		PicThread p =new PicThread(new File(args[0]));
		

		BufferedReader reader= new BufferedReader(new InputStreamReader(p.getInputStream()));
		while(true){
			Thread.sleep(1000);
			String line=null;
			while ((line = reader.readLine())!=null){
				System.out.println(line);
			}
		}
//		run();
		
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
