package biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
	private static int elements = 5;
	
	/**
	 * Function used to display the selection menu
	 */
	private static void show() {
		File menu = new File("src\\menu.txt");
		Scanner menuReader = null;
		if(menu.exists() && menu.isFile()){
			try{
				menuReader = new Scanner(menu);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			while(menuReader.hasNextLine()){
				System.out.println(menuReader.nextLine());
			}
			menuReader.close();
		}
	}
	
	/**
	 * Gets the choice of the user after displaying the menu
	 * 
	 * @return the choice made by the user
	 */
	public static int getChoice() {
		show();
		System.out.print("Enter your choice: ");
		int choice = Input.getInt();
		while(choice<0 || choice>elements) {
			show();
			System.out.print("Enter your choice: ");
			choice = Input.getInt();
		}
		return choice;		
	}
	
}
