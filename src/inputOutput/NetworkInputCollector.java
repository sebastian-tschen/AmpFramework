package inputOutput;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
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

		Reader reader = null;
		Writer sender = null;

		try {
			Socket socket = serverSocket.accept();
			reader = new InputStreamReader(socket.getInputStream());
			sender = new OutputStreamWriter(socket.getOutputStream());

			while (true) {

				ArrayList<Integer> xArray = new ArrayList<Integer>();
				ArrayList<Integer> yArray = new ArrayList<Integer>();

				char[] buff = new char[3];

				try {

					reader.read(buff);
					while (!Arrays.equals(buff, "eof".toCharArray())) {

						int x = buff[0];
						int y = buff[1];
						if (buff[2] != ';') {
							System.err.println("unexpected chunk: "
									+ buff.toString());
						}
						sender.append('o');
						sender.flush();
						xArray.add(x);
						yArray.add(y);
					}

					sender.append('k');
					sender.flush();

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
}
