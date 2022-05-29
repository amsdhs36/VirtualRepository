package LockedMe;

public class WelcomeScreenMenu {
	public static void WelcomeScreen(String appName, String developerName) {
		String Details = String.format("* Welcome to world of %s.com. \n" + "*Developed by %s .\n",
				                          appName, developerName);
		String appFunction = "Hello User ,you can use this application to\n"
				+ "Retrieve all file names in the \"Main\" folder\n";
		System.out.println(Details);

		System.out.println(appFunction);
	}
	public static void displayMenu() {
		String menu = "\n\n****** Select any option number from below and press Enter ******\n\n"
				+ "1) Retrieve all files inside \"main\" folder\n" 
				+ "2) Exit program\n";
		System.out.println(menu);

	}

}
