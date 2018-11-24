package mainPackage;

import java.io.*;
import java.util.ArrayList;

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
				
				String tmp[] = read.split("\t");
				books.get(index).setAuthor(tmp[0]);
				books.get(index).setTitle(tmp[1]);
				books.get(index).setDate(tmp[2]);
				books.get(index).setRating(Double.parseDouble(tmp[3]));
				
				index++;
			}
		}
		
		catch (IOException e) {
			System.out.println("ERROR: \"reviews.txt\" file was not found");
		}
	}
	
	//Writing all data to file (saving)
	public void save() {
		
		try {
			FileWriter fw =  new FileWriter("reviews.txt");
			PrintWriter fout = new PrintWriter(fw);
		
			for(int i = 0; i < books.size(); i++) {
			
				fout.println(books.get(i).getAuthor() + "\t" + books.get(i).getTitle() + "\t" + books.get(i).getDate() + "\t" + books.get(i).getRating());
				
			}
		
			fout.close();
		}
			
			catch (IOException e) {
				System.out.println("ERROR with writing a file");
			}
	}
	
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
			System.out.print((i+1) + " book: ");
			books.get(i).print();
		}
	}
	
	public Book get(int index) {
		return books.get(index);
	}
	
	//Get ArrayList size
	public int getSize() {
		return books.size();
	}
	
}
