package commandCenter;

import intraController.ByteArgument;
import intraController.CommandIntegrityException;
import intraController.InvalidArgumentValueException;
import intraController.PicCommand;
import intraController.picArgs.PicArgument;
import intraController.picArgs.StringArgument;

import java.util.ArrayList;

public class TestCommand extends PicCommand {

	ArrayList<PicArgument> arguments;
	
	private static TestCommand myInstance=null;
	
	private TestCommand(){
		super((byte) 56,"TestCommand");
		arguments = new ArrayList<PicArgument>();
		arguments.add(new StringArgument("FirstArg"));
		arguments.add(new StringArgument("secondArg"));
		arguments.add(new ByteArgument("thirdArg"));
		arguments.add(new StringArgument("fourthArg"));
	}

	@Override
	public ArrayList<PicArgument> getArguments() {
		// TODO Auto-generated method stub
		return arguments;
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
