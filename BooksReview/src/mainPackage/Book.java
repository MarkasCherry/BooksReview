package mainPackage;

import java.util.Scanner;

public class Book {
	
	Scanner in = new Scanner(System.in);

	//Parameters
	private String author;	//Author's full name
	private String title;	//Title of the book
	private int date;	//Date of the book release (ddmmyy)
	private int rating;		//rating of the book
	
	//Constructor
	Book() {
		set("?Author name?", "?book title?", -1, -1);
	}
	
	//Setters
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDate(int date) {
		this.date = date;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void set(String author, String title, int date, int rating) {
		setAuthor(author);
		setTitle(title);
		setDate(date);
		setRating(rating);
	}
	
	//Getters
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getDate() {
		return date;
	}
	
	public int getRating() {
		return rating;
	}
	
	//Inputing (later I will add database)
	public void ask() {
		System.out.println("Enter book's author: ");
		setAuthor(in.nextLine());
		
		System.out.println("Enter the name of a book: ");
		setTitle(in.nextLine());
		
		System.out.println("Enter realese date (ddmmyyyy): ");
		setDate(in.nextInt());
		
		System.out.println("Enter your rating: ");
		setRating(in.nextInt());
	}
	
	//toString method
	public String toString() {
		return author + " " + title + " " + date + " " + rating;
	}
}
