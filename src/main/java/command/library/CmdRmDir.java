package command.library;

import java.util.ArrayList;
import java.util.Iterator;

import command.framework.Command;
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdRmDir extends Command {

	public CmdRmDir(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		String dirName = this.getParameterAt(0);
		ArrayList<FileSystemItem> files = new ArrayList<FileSystemItem>(this.getDrive().getCurrentDirectory().getContent());
		
		for (Iterator<FileSystemItem> iterator = files.iterator(); iterator.hasNext();) {
			FileSystemItem fileSystemItem = (FileSystemItem) iterator.next();
			if (fileSystemItem.getName().equals(dirName)) {
				try {
					if (fileSystemItem.isDirectory() && fileSystemItem.getContent().size() > 0) {
						outputter.print("Your directory contained " +  fileSystemItem.getContent().size() + " items" );
					}
				} catch (IllegalAccessException e) {
					outputter.printLine(e.getMessage());
				}
				this.getDrive().getCurrentDirectory().remove(fileSystemItem);
			}
		}
	}
}