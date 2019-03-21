/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CmdRmDirTest extends CmdTest {
	

	@Before
	public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();
		// Add all commands which are necessary to execute this unit test
		// Important: Other commands are not available unless added here	
        this.commandInvoker.addCommand(new CmdRmDir("rmdir", this.drive));
	}

    @Test
    public void CmdDel_DeleteDirWithoutFiles()
    {
        // given
        final String delDirName = "subDir2";

        // when
        executeCommand("rmdir " + delDirName);

        // then
        assertEquals(numbersOfDirectoriesBeforeTest - 1, drive.getCurrentDirectory().getNumberOfContainedDirectories());
    }
    
    @Test
    public void CmdDel_DeleteDirWithFiles()
    {
        // given
        final String delDirName = "subDir1";

        // when
        executeCommand("rmdir " + delDirName);

        // then
        assertEquals(numbersOfDirectoriesBeforeTest - 1, drive.getCurrentDirectory().getNumberOfContainedDirectories());
    }

}
