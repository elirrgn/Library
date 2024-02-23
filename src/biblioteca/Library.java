package biblioteca;

import java.util.Collections;
import java.util.Vector;

import fileManagement.fileManagement;

public class Library {
	private Vector<Book> b;
	
	public Library() {
		b = fileManagement.initialize();
	}


	/**
	 * Method toString of the object Library
	 * 
	 * @return the string that describes the object
	 */
	public String toString() {
		String s = "Books in the library: " + b.size();
		for(int i = 0; i < b.size(); i++) {
			s += "\n";
			s += b.get(i).toString();
		}
		return s;
	}
	
	/**
	 * Adds a book to the array if it's not full and the book doesn't already exists
	 * 
	 * @param book the book to add to the array
	 * @return false if the book already exists and if the array is full, otherwise true
	 */
	public boolean addBook(Book book) {
		for(Book x: this.b){
			if(book.getISBN().compareToIgnoreCase(x.getISBN()) == 0) {
				return false;
			}
		}
		b.add(book);
		return true;
	}
	
	/**
	 * Removes a book given the title
	 * 
	 * @param tit title of the book to remove
	 * @return false if the book doesn't exist, true if the book is correctly removed
	 */
	public boolean removeBook(String tit) {
		for(Book book: b){
			if(book.getTitle().compareTo(tit) == 0) b.remove(book);
			return true;
		}
		return false;
	}

	/**
	 * Updates the file of the library
	 * 
	 */
	public void updateFile() {
		fileManagement.writeOnFile(b);
	}

	/**
	 * Sorts the library lexicographically
	 * 
	 */
	public void sortLib(){
		Collections.sort(b);
	}
}