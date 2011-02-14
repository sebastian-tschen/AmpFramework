package inputOutput;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import container.ListContainer;
import container.TheList;

public class NetworkInputCollector extends InputCollector {

	private ServerSocket serverSocket;
//	private long sleeptime=1;
//	private int counter;

	public NetworkInputCollector(ListContainer listContainer,
			ServerSocket serverSocket) {
		super(listContainer);
		this.serverSocket = serverSocket;
		// TODO Auto-generated constructor stub
	}

	public void run() {

		while (true) {
			runServer();
		}

	}

	private void runServer() {
		InputStream reader = null;

		try {
			Socket socket = serverSocket.accept();

			reader = socket.getInputStream();
			// sender = socket.getOutputStream();

			while (true) {

				ArrayList<Integer> xArray = new ArrayList<Integer>();
				ArrayList<Integer> yArray = new ArrayList<Integer>();

				byte[] buff = new byte[3];

				try {

					if (saveAndTimedReading(reader,buff) < 0) {
						socket.close();
						return;
					}
					byte[] eoc = new byte[] { 'e', 'o', 'c' };
					while (!Arrays.equals(buff, eoc)) {
						//
						// int x = buff[0];
						// int y = buff[1];

						int x = unsignedByteToInt(buff[0]);
						int y = unsignedByteToInt(buff[1]);
						x = x / 2;
						y = 255 - y;
						y = y / 2;

						// System.out.println("" + buff[0] + " " + buff[1] +
						// " - "
						// + x + " " + y);

						if (buff[2] != ';') {
							System.err.println("unexpected chunk: " + buff[0]
									+ buff[1] + buff[2]);
							// socket.close();

							recover(reader);

							continue;
						}

						xArray.add(x);
						yArray.add(y);
						if (saveAndTimedReading(reader, buff)<3){
							socket.close();
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
//						System.out.println(counter);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					socket.close();
					return;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}

	private void recover(InputStream reader) throws IOException {

		byte buff[] = new byte[3];
		byte[] eoc = new byte[] { 'e', 'o', 'c' };
		while (!Arrays.equals(buff, eoc)) {

			buff[0] = buff[1];
			buff[1] = buff[2];
			buff[2] = (byte) reader.read();

		}

	}

	private int unsignedByteToInt(byte b) {
		return (int) b & 0xFF;
	}
	
	private int saveAndTimedReading(InputStream reader,byte[] buff) throws IOException{
	
		int max = buff.length;
		int n = 0;
		while (n < max) {

			int x = reader.read(buff, n, max - n);

			if (x < 0) {
				System.err.println("error reading from stream");
				return x;
			}

			if (x == 0) {

				System.out.println("EOF");
				return x;
			}

			n += x;

		}
		
		return n;
	}
}
