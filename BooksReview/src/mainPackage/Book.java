package mainPackage;

import java.util.Scanner;

public class Book {
	
	Scanner in = new Scanner(System.in);

	//Parameters
	private String author;	//Author's full name
	private String title;	//Title of the book
	private String date;	//Date of the book release
	private int rating;		//rating of the book
	
	//Constructor
	Book() {
		set("?Author name?", "?book title?", "?date?", -1);
	}
	
	//Setters
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void set(String author, String title, String date, int rating) {
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
	
	public String getDate() {
		return date;
	}
	
	public int getRating() {
		return rating;
	}
	
	//Inputing
	public void ask() {
		askAuthor();
		askTitle();
		askDate();
		askRating()	;
	}
	
	public void askAuthor() {
		System.out.print("\nEnter book's author: ");
		setAuthor(in.nextLine());
	}
	
	public void askTitle() {
		System.out.print("Enter the name of a book: ");
		setTitle(in.nextLine().toUpperCase());
	}
	
	public void askDate() {
		System.out.print("Enter realese date (dd/mm/yyyy): ");
		setDate(in.next());
	}
	
	public void askRating() {
		System.out.print("Enter your rating: ");
		setRating(in.nextInt());
	}
	
	
	//Printing out
	public void print() {
		System.out.println(author + " \"" + title + "\" | Release date: " + date + " | | Rating: " + rating + "/10 |");
	}
	
	//toString method
	public String toString() {
		return author + " " + title + " " + date + " " + rating;
	}
}
