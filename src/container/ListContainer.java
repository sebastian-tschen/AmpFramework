package container;

public class ListContainer {
	

	private TheList list=null;
	
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

	

}
