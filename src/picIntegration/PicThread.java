package picIntegration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PicThread implements Runnable {

	private Process picProcess;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	
	public PicThread(File executable) throws IOException {

		if (!executable.isFile()) {
			throw new FileNotFoundException(executable.getAbsolutePath());
		}

		picProcess = Runtime.getRuntime().exec(executable.getAbsolutePath());
		inputStream=picProcess.getInputStream();
		outputStream=picProcess.getOutputStream();
		
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	@Override
	public void run() {
		

	}

	public InputStream getInputStream() {
		return inputStream;
	}
	
	
}
