package fileutils;

import java.util.Iterator;

import filesystem.Directory;
import filesystem.FileSystemItem;

public class FileUtils {
	
	public static boolean fileItemExistsinDir(Directory currentDirectory, String fileName) {
		
		for (Iterator iterator = currentDirectory.getContent().iterator(); iterator.hasNext();) {
			FileSystemItem fileSysItem = (FileSystemItem) iterator.next();
			if (fileSysItem.getName().equalsIgnoreCase(fileName)) {
				return true;
			}
		}
		return false;
	}
}
