package mainPackage;

import java.util.ArrayList;

public class BooksList {
	
	ArrayList<Book> books;
	
	//Constructor
	BooksList() {
		books = new ArrayList<Book>();
	}
	
	/* METHODS */
	
	//Add book
	public void addBook(Book book) {
		books.add(book);
	}
	
	//Print ArrayList
	public void printBooks() {
		for(int i = 0; i < books.size(); i++) {
			System.out.println((i+1) + " book: " + books.get(i));
		}
	}
	
	//Get ArrayList size
	public int getSize() {
		return books.size();
	}
	
}
