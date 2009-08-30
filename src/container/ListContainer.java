package container;

public class ListContainer {
	
	boolean newList=false;
	
	public boolean isNewList() {
		return newList;
	}

	public TheList getList() {
		return list;
	}

	public void setNewList(boolean newList) {
		this.newList = newList;
	}

	public void setList(TheList list) {
		this.list = list;
	}

	TheList list=null;
	

}
