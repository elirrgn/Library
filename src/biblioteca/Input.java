package biblioteca;
import java.util.Scanner;

public class Input {
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * Gets a string until it's convertible into an Integer
	 * 
	 * @return the integer value
	 */
	public static int getInt() {
		int num = 0;
		boolean flag = true;
		while(flag) {
			System.out.print("Insert an integer value: ");
			String temp = in.next();
			try {
				num = Integer.parseInt(temp);
				flag = false;
			} catch(Exception e) {
				System.out.println("Error! Not an integer");
			}
		}
		return num;
	}

	/**
	 * Gets a string until it's convertible into an Double value
	 * 
	 * @return the Double value
	 */
	public static double getDouble() {
		double num = 0;
		boolean flag = true;
		while(flag) {
			System.out.print("Insert a double value: ");
			String temp = in.next();
			try {
				num = Double.parseDouble(temp);
				flag = false;
			} catch(Exception e) {
				System.out.println("Error! Not a double");
			}
		}
		return num;
	}
	
	/**
	 * Gets a string
	 * 
	 * @return the string
	 */
	public static String getString() {
		System.out.print("Insert a string: ");
		String s = in.nextLine();
		return s;
	}
	
	/**
	 * Gets a string to empty the buffer or to simulate the "System("pause")" in C++
	 */
	public static void emptyBufferPause() {
		in.nextLine();
	}
}
