/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import helpers.TestHelper;
import filesystem.File;

public class CmdCopyFileTest extends CmdTest {

	@Before
	public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();
		
		// Add all commands which are necessary to execute this unit test
		// Important: Other commands are not available unless added here.
		this.commandInvoker.addCommand(new CmdCopyFile("copyfile", this.drive));
	}

    @Test
    public void CmdCopyFile_CreatesNewFile()
    {
        // given
        final String newFileName = "testFile";
        final String copyFileName = "testFileCopy";

        // when
        executeCommand("copyfile " + newFileName);

        // then
        assertEquals(numbersOfFilesBeforeTest + 1, drive.getCurrentDirectory().getNumberOfContainedFiles());
        TestHelper.assertOutputIsEmpty(testOutput);
        File copyFile = TestHelper.getFile(drive, drive.getCurrentDirectory().getPath(), copyFileName);
        assertNotNull(copyFile);
    }
/*
    @Test
    public void CmdMkFile_WithoutContent_CreatesEmptyFile()
    {
        // given
        final String newFileName = "testFile";

        // when
        executeCommand("mkfile " + newFileName);

        // then
        File createdFile = TestHelper.getFile(drive, drive.getCurrentDirectory().getPath(), newFileName);
        assertEquals("", createdFile.getFileContent());
    }

    @Test
    public void CmdMkFile_WithContent_CreatesFileWithContent()
    {
        // given
        final String newFileName = "testFile";
        final String newFileContent = "ThisIsTheContent";

        // when
        executeCommand("mkfile " + newFileName + " " + newFileContent);

        // then
        assertEquals(numbersOfFilesBeforeTest + 1, drive.getCurrentDirectory().getNumberOfContainedFiles());
        TestHelper.assertOutputIsEmpty(testOutput);
        File createdFile = TestHelper.getFile(drive, drive.getCurrentDirectory().getPath(), newFileName);
        assertEquals(newFileContent, createdFile.getFileContent());
    }

    @Test
    public void CmdMkFile_NoParameters_ReportsError()
    {
        executeCommand("mkfile");
        assertEquals(numbersOfFilesBeforeTest, drive.getCurrentDirectory().getNumberOfContainedFiles());
        TestHelper.assertContains("syntax of the command is incorrect", testOutput.toString());
    }
*/
}
