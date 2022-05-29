package LockedMe;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileOperations {
	
	public static void directoryifnotexist(String folderName) {
		File file = new File(folderName);

		// If directory not exist, create the Main folder
		if (!file.exists()) {
			file.mkdirs();
					}
		}

		public static void displayAllFiles(String path) {
			FileOperations.directoryifnotexist("Main");
			// All required files and folders inside "main" folder relative to current folder
			System.out.println("Displaying all files form the directory structure\n");

			// listFilesInDirectory displays files along with folder structure
			List<String> filesListNames = FileOperations.listDirectoryFiles(path, 0, new ArrayList<String>());

			System.out.println("Displaying all files in ascending order\n");
			Collections.sort(filesListNames);

			filesListNames.stream().forEach(System.out::println);
		}
	
	public static List<String> listDirectoryFiles(String dirName,int Count,List<String> fileListNames)
	{
		FileOperations.directoryifnotexist("Main");
		File dir = new File(dirName);
		File[] files = dir.listFiles();
			List<File> filesList = Arrays.asList(files);

			Collections.sort(filesList);

			if (files != null && files.length > 0) {
				for (File file : filesList) {

					System.out.print(" ".repeat(Count * 2));

					if (file.isDirectory()) {
						System.out.println("`-- " + file.getName());

						// Recursively indent and display the files
						fileListNames.add(file.getName());
						listDirectoryFiles(file.getAbsolutePath(), Count + 1, fileListNames);
					} else {
						System.out.println("|-- " + file.getName());
						fileListNames.add(file.getName());
					}
				}
			} else {
				System.out.print(" ".repeat(Count * 2));
				System.out.println("|-- Empty Directory");
			}
			System.out.println();
			return fileListNames;
	}
	
	

}
