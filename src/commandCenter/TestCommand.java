package commandCenter;

import java.util.ArrayList;

import intraController.*;
import intraController.picArgs.*;

public class TestCommand implements PicCommand {

	private final String name;
	ArrayList<PicArgument> arguments;
	
	public TestCommand(String newName){
		name = newName;
		arguments = new ArrayList<PicArgument>();
		arguments.add(new StringArgument());
		arguments.add(new StringArgument());
	}

	@Override
	public ArrayList<PicArgument> getArguments() {
		// TODO Auto-generated method stub
		return arguments;
	}

	@Override
	public byte[] getByteCodeCommand() throws CommandIntegrityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void tryIntegrity() throws CommandIntegrityException {
		// TODO Auto-generated method stub
		
	}

}
