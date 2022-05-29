package LockedMe;

import java.util.Scanner;

public class UserChoice {
	public static  void gotoUserChoice() {
		boolean running = true;
		
		Scanner sc = new Scanner(System.in);
		do {
			try {
			
				WelcomeScreenMenu.displayMenu();
				System.out.println("Please enter your choice:");
				int input = sc.nextInt();
				switch (input) {
				case 1:
					FileOperations.displayAllFiles("Main");
					break;
				case 2:
					UserChoice.gotoUserSubMenuChoice();
					break;
				case 3: 
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please enter valid choice from the menu");
				      }
			}catch (Exception e) {
				System.out.println(e.getClass().getName());
				gotoUserChoice();
			
			 }
		} while (running == true);
	
		

	}
	public static void gotoUserSubMenuChoice() {
		
		boolean running=true;
		Scanner sc=new Scanner(System.in);
		do {
			try {
				WelcomeScreenMenu.displaySubMenu();
				System.out.println("Please enter your choice:");
				int userinput=sc.nextInt();
				switch(userinput) {
				case 1:
					System.out.println("Enter the name of the file to be added to the Main folder");
					String fileToAdd = sc.next();
					FileOperations.addFile(fileToAdd, sc);
					
					break;
		/*     	case 2:
					System.out.println("Enter the name fo the file to be deleted from the Main folder");
					String fileToDelete=sc.next();
					FileOperations.deleteFile();
					break;
				case 3:
					FileOperations.searchFile();
					break;*/
				case 4:
					return;
				case 5:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please enter valid choice from the Sub-menu");
				}
			}catch (Exception e) {
				System.out.println(e.getClass().getName());
				gotoUserSubMenuChoice();
				} 
		}while (running==true);
	}

}