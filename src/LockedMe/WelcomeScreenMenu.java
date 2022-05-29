package LockedMe;

public class WelcomeScreenMenu {
	//Display application name and developer name
	public static void WelcomeScreen(String appName, String developerName) {
		String Details = String.format("* Welcome to world of %s.com. \n" + "*Developed by %s .\n",
				                          appName, developerName);
		String appFunction = "Hello User ,you can use this application to\n"
				+ "Retrieve all file names in the \"Main\" folder\n";
		System.out.println(Details);

		System.out.println(appFunction);
	}
	//Display the menu
	public static void displayMenu() {
		String menu = "\n\nSelect any option number from below and press Enter \n\n"
				+ "1) Retrieve all files inside \"main\" folder\n"
				+ "2) Display the File SubMenu\n"
				+ "3) Exit program\n";
		System.out.println(menu);

	}
	//Display the sub menu: add, delete and search file
	public static void displaySubMenu() {
		String menu2="\n\nSelect any option from Submenu and press Enter\n\n"
				+ "1. Add the file\n"
				+ "2. Delete the file\n"
				+ "3. Search the file\n"
				+ "4. Return to the main menu\n"
				+ "5. Exit program\n";
		System.out.println(menu2);
		
	}

}
