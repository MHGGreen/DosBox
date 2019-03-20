package command.library;

import command.framework.Command;
import filesystem.File;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdCopyFile extends Command {

	public CmdCopyFile(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		String fileName = this.getParameterAt(0);
		String fileContent = this.getParameterAt(1);
		File newFile = new File(fileName, fileContent);
		File copyFile = new File("copy" + fileName, fileContent);
		this.getDrive().getCurrentDirectory().add(newFile);
		this.getDrive().getCurrentDirectory().add(copyFile);
	}
}
