package LockedMe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

public static void addFile(String fileToAdd, Scanner sc) {
	FileOperations.directoryifnotexist("Main");
	Path FilePath = Paths.get("./main/" + fileToAdd);
	try {
		Files.createDirectories(FilePath.getParent());
		Files.createFile(FilePath);
		System.out.println(fileToAdd + " successfully created ");

		System.out.println("Do you like to add some content to the file? (Y/N)");
		String choice = sc.next().toLowerCase();

		sc.nextLine();
		if (choice.equals("y")) {
			System.out.println("\n\nInput content and press enter\n");
			String content = sc.nextLine();
			Files.write(FilePath, content.getBytes());
			System.out.println("\nContent written to file " + fileToAdd);
			System.out.println("Content can be read using Notepad or Notepad++");
		}

	} catch (IOException e) {
		System.out.println("Failed to create file " + fileToAdd);
		System.out.println(e.getClass().getName());
	}

}


/*public static void deleteFile()
{
	

}
public static void searchFile()
{
	

}*/

}
