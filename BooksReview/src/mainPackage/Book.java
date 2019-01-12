package mainPackage;

import java.util.Scanner;

public class Book {
	
	Scanner in = new Scanner(System.in);

	//Parameters
	private String author;	//Author's full name
	private String title;	//Title of the book
	private int date;		//book's release year
	private double rating;	//rating of the book
	
	//Constructors
	Book(String author, String title, int date, int rating) {
		setAuthor(author);
		setTitle(title);
		setDate(date);
		setRating(rating);
	}
	
	Book() {
		set("?Author name?", "?book title?", -1, -1);
	}
	
	//Setters
	public void setAuthor(String author) {	//sets author
		this.author = author;
	}
	
	public void setTitle(String title) {	//sets title
		this.title = title;
	}
	
	public void setDate(int date) {			//sets release year
		this.date = date;
	}
	
	public void setRating(double rating) {	//sets rating
		this.rating = rating;
	}
	
	public void set(String author, String title, int date, double rating) {		//sets all parameters
		setAuthor(author);
		setTitle(title);
		setDate(date);
		setRating(rating);
	}
	
	//Getters
	public String getAuthor() {		//gets author
		return author;
	}
	
	public String getTitle() {		//gets title
		return title;
	}
	
	public int getDate() {			//gets release year
		return date;
	}
	
	public double getRating() {		//gets rating
		return rating;
	}
	
	//Inputing
	public void ask() {				//asks to input all elements
		askAuthor();
		askTitle();
		askDate();
		askRating()	;
	}
	
	public void askAuthor() {		//asks to input author
		System.out.print("\nEnter book's author: ");
		setAuthor(in.nextLine());
	}
	
	public void askTitle() {		//asks to input title
		System.out.print("Enter the name of a book: ");
		setTitle(in.nextLine().toUpperCase());
	}
	
	public void askDate() {			//asks to input release year
		System.out.print("Enter release year: ");
		setDate(in.nextInt());
		in.nextLine();

	}
	
	public void askRating() {		//asks to input rating
		System.out.print("Enter your rating: ");
		setRating(in.nextDouble());
		in.nextLine();
	}
	
	//Printing out
	public void print() {		//prints out reviews list in a table
		System.out.printf("%-31s %1s %-29s %1s %10d %7s %4.1f %4s %2s", author, "|      ", title, "|", date, "|", rating, "/ 10", "|");
		System.out.println();
	}
	
	//toString method
	public String toString() {
		return author + " " + title + " " + date + " " + rating;
	}
}
