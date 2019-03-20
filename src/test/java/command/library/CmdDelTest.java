/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CmdDelTest extends CmdTest {
	

	@Before
	public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();
		// Add all commands which are necessary to execute this unit test
		// Important: Other commands are not available unless added here	
        this.commandInvoker.addCommand(new CmdDel("del", this.drive));
	}

    @Test
    public void CmdDel_DeletesFile()
    {
        // given
        final String delFileName = "FileInRoot1";

        // when
        executeCommand("del " + delFileName);

        // then
        assertEquals(numbersOfFilesBeforeTest - 1, drive.getCurrentDirectory().getNumberOfContainedFiles());
    }

}
