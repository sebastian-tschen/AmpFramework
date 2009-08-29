package gui;



public class start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame myFrame = new MainFrame();
		Thread showerThread = new Thread(myFrame);
		showerThread.start();
		TheList list = new TheList();
		for(int i = 0; i < 128; i++){
			for(int j = 0; j < 128; j++){
				list.add(i, j);
			}
		}
		myFrame.setKoords(list);
	}
}
