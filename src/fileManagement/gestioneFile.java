package fileManagement;

import biblioteca.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class gestioneFile {
    
    private static String pathFile =  "src\\fileManagement\\biblioteca.csv";
    private static File f = new File(pathFile);

    public static Vector<Book> inizializza(Vector<Book> elenco) {
        Scanner inputFile = null;
        if(f.exists() && f.isFile()) {
            try {
                inputFile = new Scanner(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else return elenco;

        while(inputFile.hasNextLine()){
            String temp = inputFile.nextLine();
            String[] record = temp.split(",");
            if(record.length == 4) {
                String ISBN = record[0];
                String title = record[1];
                String author = record[2];
                double cost = Double.parseDouble(record[3]);
                elenco.add(new Book(ISBN, title, author, cost));
            }
        }
        inputFile.close();
        return elenco;
    }

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
