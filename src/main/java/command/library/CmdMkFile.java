/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import java.util.Iterator;

import command.framework.Command;
import filesystem.Directory;
import filesystem.File;
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

class CmdMkFile extends Command {

	public CmdMkFile(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		
		String fileName = this.getParameterAt(0);
		String fileContent = null;
		if (this.getParameterCount() == 1) {
			fileContent = "";
		} else {
			fileContent = this.getParameterAt(1);
		}
		if (fileItemExistsinDir(this.getDrive().getCurrentDirectory(), fileName)) {
			outputter.printLine("The file with the same name already exist");
			return;
		}
		
		File newFile = new File(fileName, fileContent);
		this.getDrive().getCurrentDirectory().add(newFile);	
	}
	
	private boolean fileItemExistsinDir(Directory currentDirectory, String fileName) {
		
		for (Iterator iterator = currentDirectory.getContent().iterator(); iterator.hasNext();) {
			FileSystemItem fileSysItem = (FileSystemItem) iterator.next();
			if (fileSysItem.getName().equalsIgnoreCase(fileName)) {
				return true;
			}
		}
		return false;
	}

	protected boolean checkNumberOfParameters(int numberOfParametersEntered) {
		return this.getParameterCount() > 0;
    }
}
