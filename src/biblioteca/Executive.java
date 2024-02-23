package biblioteca;

public class Executive {
	public static void main(String[] args) {
		Library b = new Library();
		int choice = 1;
		while(choice != 0) {
			choice = Menu.getChoice();
			Input.emptyBufferPause();
			switch(choice) {
				case 1: System.out.println(b.toString());
						pause();
						break;
				case 2: System.out.print("Enter the title: ");
						String title = Input.getString();
						title = title.trim().toLowerCase();
						System.out.print("Enter the author (empty if unknown): ");
						String author = Input.getString();
						author = author.trim().toLowerCase();
						if(author.isEmpty()) author = "unknown";
						System.out.print("Enter the ISBN: ");
						String ISBN = Input.getString();
						System.out.print("Enter the cost: ");
						double cost = Input.getDouble();
						Input.emptyBufferPause();
						b.addBook(new Book(ISBN, title, author, cost));
						System.out.println("Book added successfully!");
						break;
				case 3: System.out.print("Enter the title of the book you want to remove: ");
						String s = Input.getString();
						if(b.removeBook(s.trim().toLowerCase())) System.out.println("Book removed!");
						else System.out.println("The book doesn't exist!");
						pause();
						break;
				case 4: b.sortLib();
						System.out.println("Library successfully sorted!");
						pause();
						break;
				case 5: b.updateFile();
						System.out.println("Library file updated!");
						pause();
						break;
			}
		}
		String save;
		do {
			System.out.println("Save changes? (y/n)");
			save = Input.getString();
		}while(save.compareToIgnoreCase("Y") != 0 && save.compareToIgnoreCase("N")!=0);
		if(save.compareToIgnoreCase("Y") == 0){
			b.updateFile();
			System.out.println("Changes saved!");
		}else {
			System.out.println("Changes not saved!");
		}
	}
	
	/**
	 * Simulates the "System("pause")" in C++
	 * 
	 */
	public static void pause() {
		System.out.print("Press enter to continue...");
		Input.emptyBufferPause();
	}
	
	
}
