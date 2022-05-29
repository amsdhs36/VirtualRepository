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
}
