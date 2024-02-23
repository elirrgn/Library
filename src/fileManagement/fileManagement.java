package fileManagement;

import biblioteca.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class fileManagement {
    
    private static String pathFile =  "src\\fileManagement\\biblioteca.csv";
    private static File f = new File(pathFile);

    /**
     * Loads the books in the file "biblioteca.csv" into a Vector 
     * 
     * @return the Vector of books
     **/
    public static Vector<Book> initialize() {
        Vector<Book> list = new Vector<Book>(10, 2);
        Scanner inputFile = null;
        if(f.exists() && f.isFile()) {
            try {
                inputFile = new Scanner(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else return list;

        while(inputFile.hasNextLine()){
            String temp = inputFile.nextLine();
            String[] record = temp.split(",");
            if(record.length == 4) {
                String ISBN = record[0].trim();
                String title = record[1].trim();
                String author = record[2].trim();
                double cost = Double.parseDouble(record[3]);
                list.add(new Book(ISBN, title, author, cost));
            }
        }
        inputFile.close();
        return list;
    }

    /**
     * Updates the file with the changes in the list
     * 
     * @param list Vector of Books
     */
    public static void writeOnFile(Vector<Book> list) {
        FileWriter out = null;
        try {
            out = new FileWriter(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter print = new PrintWriter(out);
        for(Book b: list){
            print.println(b.getISBN() + "," + b.getTitle() + "," + b.getAuthor() + "," + b.getCost());
        }
        print.close();
    }

    

}
