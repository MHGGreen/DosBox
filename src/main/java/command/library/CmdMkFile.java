/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import command.framework.Command;
import filesystem.File;
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
		
		File newFile = new File(fileName, fileContent);
		this.getDrive().getCurrentDirectory().add(newFile);
	}
	
	protected boolean checkNumberOfParameters(int numberOfParametersEntered) {
		return this.getParameterCount() > 0;
    }
}
