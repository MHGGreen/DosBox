package command.library;

import java.util.ArrayList;
import java.util.Iterator;

import command.framework.Command;
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdDel extends Command {

	public CmdDel(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		String fileName = this.getParameterAt(0);
		ArrayList<FileSystemItem> files = new ArrayList<>(this.getDrive().getCurrentDirectory().getContent());
		
		for (Iterator<FileSystemItem> iterator = files.iterator(); iterator.hasNext();) {
			FileSystemItem fileSystemItem = (FileSystemItem) iterator.next();
			if (fileSystemItem.getName().equals(fileName)) {
				this.getDrive().getCurrentDirectory().remove(fileSystemItem);
			}
		}
	}
}