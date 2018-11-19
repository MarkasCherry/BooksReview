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
	public void add(Book book) {
		books.add(book);
	}
	
	//Remove book
	public void remove(int index) {
		books.remove(index);
	}
	
	public void remove(String name) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().equals(name.toUpperCase()) ) {
				books.remove(i);
			}
		}
	}
	
	//Print ArrayList
	public void printBooks() {
		for(int i = 0; i < books.size(); i++) {
			books.get(i).print();
		}
	}
	
	//Get ArrayList size
	public int getSize() {
		return books.size();
	}
	
}
