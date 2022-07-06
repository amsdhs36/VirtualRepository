package LockedMe;

import java.io.File;
//import java.io.FilenameFilter;
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

		
	} catch (IOException e) {
		System.out.println("Failed,file not created " + fileToAdd);
		System.out.println(e.getClass().getName());
	}

}


public static void deleteFile(String fileToDel)
{
   FileOperations.directoryifnotexist("Main");
   Path Filepath=Paths.get("./main/"+fileToDel);
   try
   {  
     Files.delete(Filepath);
     System.out.println(fileToDel+" deleted successfully");
   }
   catch (IOException e)
   {
	   System.out.println("Failed, filed not deleted"+ fileToDel);
	   System.out.println(e.getClass().getName());
	   
   }
}

public static void searchFile(String fileToSearch)
{
	File directory=new File("main/");
	String[] fileList=directory.list();
	
	int flag=0;
	if(fileList==null)
	{
		System.out.println("Empty Directory");
	}
	else
		for(int i=0;i<fileList.length;i++)
		{
			String filename=fileList[i];
			if(filename.equalsIgnoreCase(fileToSearch))
			{
				System.out.println(filename+" file found in main folder");
				flag=1;
				
				Path currentRelativePath=Paths.get(directory.getAbsolutePath());
				String s=currentRelativePath.toAbsolutePath().toString();
				System.out.println("main is located at "+s);
				
			}
		}
	if(flag==0)
	{
		System.out.println("File not found");	
	}
	
 
	

	}

	
}

	



