package pinSimulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class PinSimulator implements Runnable {

	@Override
	public void run() {

		while (true) {
			runServer();
		}

	}

	private void runServer() {

		try {
			ServerSocket serversocket = new ServerSocket(12346);
			Socket socket = serversocket.accept();

			socket.setKeepAlive(true);
			OutputStream outStream = socket.getOutputStream();

			BufferedReader stdinReader = new BufferedReader(
					new InputStreamReader(System.in));
			String line;
			while ((line = stdinReader.readLine()) != null) {
				byte stat = 0;
				try {
					stat = (byte) (Integer.parseInt(line,2) & 0x000000FFL);
				} catch (NumberFormatException e) {
					System.err.println("could not parse byte. try again");
					continue;
				}

				outStream.write(new byte[] { stat });

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

	}
}
