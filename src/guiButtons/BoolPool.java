package guiButtons;

public class BoolPool {

	boolean[] bool;
	
	public BoolPool(){
		bool = new boolean[]{false, false, false, false, false, false, false, false};
	}
	
	public void setBool(boolean newBool, int position){
		int pos = position -1;
		bool[pos] = newBool;
	}
	
	public boolean[] getBool(){
		return bool;
	}
}
