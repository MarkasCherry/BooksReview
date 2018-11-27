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
	
	//Removing books
	public void removeBook() {		//removes all books
		int size = books.size();
		for(int i = 0; i < size; i++) {
			books.remove(0);
		}
	}
	
	public void removeBook(int index) {		//removes specific book by it's index
		books.remove(index);
	}
	
	public void removeBook(String name) {	//removes all books with same title
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
	
	//SORTING
	
	public void sortByTitle() {
			boolean sorting = true;
			
			while(sorting) {
				sorting = false;
				
				for(int i = 1; i < books.size(); i++) {
					if(books.get(i-1).getTitle().compareToIgnoreCase(books.get(i).getTitle()) > 0) {
						Collections.swap(books, i-1, 1);
						sorting = true;
					}
				}
			}
	}
	
	public void sortByDate() {
		boolean sorting = true;
		
		while(sorting) {
			sorting = false;
			
			for(int i = 1; i < books.size(); i++) {
				if(Integer.parseInt((books.get(i-1).getDate().substring(6))) < Integer.parseInt((books.get(i).getDate().substring(6)))) {
					Collections.swap(books, i-1, i);
					sorting = true;
				}
				else {
					if(Integer.parseInt((books.get(i-1).getDate().substring(6))) == Integer.parseInt((books.get(i).getDate().substring(6)))) {
						if(Integer.parseInt((books.get(i-1).getDate().substring(3,5))) < Integer.parseInt((books.get(i).getDate().substring(3,5)))) {
							Collections.swap(books, i-1, i);
							sorting = true;
						}
						else {
							if(Integer.parseInt((books.get(i-1).getDate().substring(3,5))) == Integer.parseInt((books.get(i).getDate().substring(3,5)))) {
								if(Integer.parseInt((books.get(i-1).getDate().substring(0,2))) < Integer.parseInt((books.get(i).getDate().substring(0,2)))) {
									Collections.swap(books, i-1, i);
									sorting = true;
								}
							}
						}
					}
				}
				
			}
		}
	}
	
	public void sortByRating() {	//sorts by rating
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

	
	//Allows to reach container in main class
	public Book get(int index) {
		return books.get(index);
	}
	
	//Get ArrayList size
	public int getSize() {
		return books.size();
	}
	
}
