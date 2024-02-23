package biblioteca;

public class Book implements Comparable<Book> {
	private String ISBN;
	private String title;
	private String author;
	private double cost;

	/**
	 * Constructor of the object Book
	 * 
	 * @param ISBN unifique code of the book
	 * @param title title of the book
	 * @param author author of the book
	 * @param cost cost of the book
	 */
	public Book(String ISBN, String title, String author, double cost) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.cost = cost;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		String s = "\nBook: " + this.title + "\n";
		s += "\nAuthor: "+ this.author;
		s += "\nCost: "+ this.cost;
		s += "\nISBN: "+ this.ISBN;
		return s+"\n";
	}

	@Override
	public int compareTo(Book b){
		int comp = this.title.compareToIgnoreCase(b.getTitle());
		if(comp<0) {
			return -1;
		} else if(comp==0){
			return 0;
		} else {
			return +1;
		}
	}
}