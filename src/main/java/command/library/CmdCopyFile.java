package command.library;

import java.util.ArrayList;
import java.util.Iterator;

import command.framework.Command;
import filesystem.File;
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdCopyFile extends Command {

	public CmdCopyFile(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		String fileName = this.getParameterAt(0);
		ArrayList<FileSystemItem> files = new ArrayList<FileSystemItem>(this.getDrive().getCurrentDirectory().getContent());
		
		for (Iterator<FileSystemItem> iterator = files.iterator(); iterator.hasNext();) {
			File fileSystemItem = (File) iterator.next();
			if (fileSystemItem.getName().equals(fileName)) {
				File copyFile = new File("copy" + fileName, fileSystemItem.getFileContent());
				this.getDrive().getCurrentDirectory().add(copyFile);
			}
		}
	}
}
