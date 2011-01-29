package inputOutput;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import container.ListContainer;
import container.TheList;

public class NetworkInputCollector extends InputCollector {

	private ServerSocket serverSocket;

	public NetworkInputCollector(ListContainer listContainer,
			ServerSocket serverSocket) {
		super(listContainer);
		this.serverSocket = serverSocket;
		// TODO Auto-generated constructor stub
	}

	public void run() {

	
		while(true){
			runServer();
		}
		
	}

	
	private void runServer(){
		InputStream reader = null;

		try {
			Socket socket = serverSocket.accept();

			reader = new BufferedInputStream(socket.getInputStream());
			// sender = socket.getOutputStream();

			while (true) {

				ArrayList<Integer> xArray = new ArrayList<Integer>();
				ArrayList<Integer> yArray = new ArrayList<Integer>();

				byte[] buff = new byte[3];

				try {

					if (reader.read(buff) < 0) {
						return;
					}
					byte[] eoc = new byte[] { 'e', 'o', 'c' };
					while (!Arrays.equals(buff, eoc)) {
//
//						int x = buff[0];
//						int y = buff[1];

						int x = unsignedByteToInt(buff[0]);
						int y = unsignedByteToInt(buff[1]);
						 x = x/2;
						 y=255-y;
						 y=y/2;

//						System.out.println("" + buff[0] + " " + buff[1] + " - "
//								+ x + " " + y);

						if (buff[2] != ';') {
							System.err.println("unexpected chunk: " + buff[0]
									+ buff[1] + buff[2]);
							return;
						}

						xArray.add(x);
						yArray.add(y);
						if (reader.read(buff) < 0) {
							return;
						}
					}

					TheList pic = new TheList();
					for (int i = 0; i < xArray.size(); i++) {
						pic.add(xArray.get(i), yArray.get(i));
					}

					// TODO checken ob bild dasselbe wie vorher;

					synchronized (this.listContainer) {
						listContainer.setNewList(true);
						listContainer.setList(pic);
						listContainer.notifyAll();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}
	
	private int unsignedByteToInt(byte b) {
		return (int) b & 0xFF;
	}
}
