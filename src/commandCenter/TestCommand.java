package commandCenter;

import java.util.ArrayList;

import intraController.*;
import intraController.picArgs.*;

public class TestCommand extends PicCommand {

	ArrayList<PicArgument> arguments;
	
	private static TestCommand myInstance=null;
	
	private TestCommand(){
		super((byte) 56,"TestCommand");
		arguments = new ArrayList<PicArgument>();
		arguments.add(new StringArgument("FirstArg"));
		arguments.add(new StringArgument("secondArg"));
		arguments.add(new ByteArgument("third"));
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
	public void tryIntegrity() throws CommandIntegrityException {
		// TODO Auto-generated method stub
		
	}
	
	public static TestCommand getInstance(){
		if (myInstance==null){
			myInstance = new TestCommand();
		}
		return myInstance;
	}

}
