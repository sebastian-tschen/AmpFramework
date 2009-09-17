package commandCenter;

import java.util.ArrayList;

import intraController.*;
import intraController.picArgs.*;

public class TestCommand2 extends PicCommand {

	ArrayList<PicArgument> arguments;
	
	private static TestCommand2 myInstance=null;
	
	private TestCommand2(){
		super((byte) 56,"TestCommand2");
		arguments = new ArrayList<PicArgument>();
		arguments.add(new ByteArgument("FirstArg"));
		arguments.add(new StringArgument("secondArg"));
		arguments.add(new ByteArgument("thirdArg"));
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
	
	public static TestCommand2 getInstance(){
		if (myInstance==null){
			myInstance = new TestCommand2();
		}
		return myInstance;
	}

}
