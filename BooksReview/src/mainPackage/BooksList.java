package mainPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFramePropertyChangeListener;

public class BooksList {
	
	ArrayList<Book> books;
	
	//Constructor
	BooksList() {
		books = new ArrayList<Book>();
	}
	
	/* METHODS */
	
	//Read data from file
	public void readFile() {
		try {
			FileReader fr = new FileReader("reviews.txt");
			BufferedReader fin = new BufferedReader(fr);
			
			String read = null;
			int index = 0;
			while ((read = fin.readLine()) != null) {
				Book book = new Book();
				add(book);
				
				String tmp[] = read.split("\t");						//every parameter is split by "\t" into tmp array
				books.get(index).setAuthor(tmp[0]);						//setting an author
				books.get(index).setTitle(tmp[1]);						//setting a title
				books.get(index).setDate(Integer.parseInt(tmp[2]));		//converting a string to int and setting a release year
				books.get(index).setRating(Double.parseDouble(tmp[3]));	//converting a string to double and setting a rating
				
				index++;
			}
			
			fin.close();	//closing a file
		}
		
		catch (IOException e) {
			System.out.print("ERROR: There was an error for reading a file.");
		}
	}
	
	//Writing all data to file (saving)
	public void save() {
		try {
			FileWriter fw =  new FileWriter("reviews.txt");
			PrintWriter fout = new PrintWriter(fw);
		
			for(int i = 0; i < books.size(); i++) {		//splitting all parameters by "\t", to make it easier to read
				fout.println(books.get(i).getAuthor() + "\t" + books.get(i).getTitle() + "\t" + books.get(i).getDate() + "\t" + books.get(i).getRating());
			}
		
			fout.close();	//closing a file
		}
			
			catch (IOException e) {
				System.out.println("ERROR: Data was not saved to the file");
			}
	}
	
	//Add new book to BooksList
	public void add(Book book) {
		books.add(book);
	}
	
	//Removing all books from a BooksList
	public void removeBook() {
		int size = books.size();
		for(int i = 0; i < size; i++) {
			books.remove(0);
		}
	}
	
	//Removing only one book from BooksList by its index
	public void removeBook(int index) {		
		books.remove(index);
	}
	
	//Removing all the books from BooksList with the same title
	public void removeBook(String name) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().equals(name.toUpperCase()) ) {
				books.remove(i);
				i--;
			}
		}
	}
	
	//Print printing all reviews with a frame
	public void printBooks() {
		System.out.println("___________________________________________________________________________________________________________________");	//top border of a frame
	    System.out.println(String.format("%4s %1s %24s %12s %24s %12s %14s %3s %8s %3s", "| No.", "|", "Book's Author", "|", "Book's Title", "|", "Release year",
	    		"|", "Rating", "|"));
	    System.out.println("|-----+-------------------------------------+-------------------------------------+------------------+------------|");
		for(int i = 0; i < books.size(); i++) {
			System.out.printf("%1s %2d %2s", "|", (i+1), " |     ");
			books.get(i).print();
		}
		System.out.println("___________________________________________________________________________________________________________________");	//bottom border of a frame
	}
	
	//SORTING
	public void sortByAuthor() {	//sorting by author [A to Z]
		boolean sorting = true;
		
		while(sorting) {
			sorting = false;
			
			for(int i = 1; i < books.size(); i++) {
				if(books.get(i-1).getAuthor().compareToIgnoreCase(books.get(i).getAuthor()) > 0) {
					Collections.swap(books, i-1, i);
					sorting = true;
				}
			}
		}
	}
	
	public void sortByTitle() {		//sorting by title [A to Z]
			boolean sorting = true;
			
			while(sorting) {
				sorting = false;
				
				for(int i = 1; i < books.size(); i++) {
					if(books.get(i-1).getTitle().compareToIgnoreCase(books.get(i).getTitle()) > 0) {
						Collections.swap(books, i-1, i);
						sorting = true;
					}
				}
			}
	}
	
	public void sortByDate() {		//sorting by release years [Newest to Oldest]
		boolean sorting = true;
		
		while(sorting) {
			sorting = false;
			
			for(int i = 1; i < books.size(); i++) {
				if(books.get(i-1).getDate() < books.get(i).getDate()) {
					Collections.swap(books, i-1, i);
					sorting = true;
				}
			}
		}
	}
	
	public void sortByRating() {	//sorting by rating [Higher to Lower]
		boolean sorting = true;
		
		while(sorting) {
			sorting = false;
			
			for(int i = 1; i < books.size(); i++) {
				if(books.get(i-1).getRating() < books.get(i).getRating()) {
					Collections.swap(books, i-1, i);
					sorting = true;
				}
			}
		}
	}

	
	//Makes container class reachable for every other class
	public Book get(int index) {
		return books.get(index);
	}
	
	//Get ArrayList size
	public int getSize() {
		return books.size();
	}
	
}
