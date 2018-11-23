package mainPackage;

import java.util.Scanner;

public class App {
	
	public static void clearScreen() {  
	    for(int i = 0; i < 50; i++) {
	    	System.out.println("\n");
	    }
	}
	
	public static void removeBook(BooksList books) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Choose one from below how to remove: \n1) Enter list No.\n2) Enter name of the book\nStop) Cancel removing");
		int x = in.nextInt();
		
		switch(x) {
		case 1:
			System.out.print("Enter list number: ");
			books.remove(in.nextInt() - 1);
			System.out.println("The book has been removed!");
			break;
			
		case 2:
			in.nextLine();
			System.out.print("Enter name of the book: ");
			String name = in.nextLine();
			
			books.remove(name.toUpperCase());
			System.out.println("All reviews of this book has been removed!");
			break;
			
		default:
			System.out.println("You canceled book removing.");
		}
	}

	public static void editBook(BooksList books) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter list No. of the book:	");
		int index = in.nextInt() - 1;
		
		System.out.println("Choose what part of the book you want to edit:\n1) Author\n2) Title\n3) Release year\n4) Rating\n5) All");
		int x = in.nextInt();
		
		switch(x) {
		case 1:
			books.get(index).askAuthor();
			break;
		
		case 2:
			books.get(index).askTitle();
			break;
			
		case 3:
			books.get(index).askDate();
			break;
			
		case 4:
			books.get(index).askRating();
			break;
			
		case 5:
			books.get(index).ask();
			break;
		default:
			System.out.println("Invalid input");
		}
		
		System.out.println("Your book review was edited!");
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		BooksList books = new BooksList();
		
		boolean app_on = true;
		while(app_on) {
			System.out.println("\n\t Review\t Print\t Remove\t Edit\t Clear\t Quit");
			String cmd = in.next();
			
			switch(cmd.toUpperCase()) {
			case "REVIEW":
				Book book = new Book();
				book.ask();
				books.add(book);
				break;
				
			case "PRINT":
				if(books.getSize() == 0) {
					System.out.println("There is no reviewed books");
				}
				else {
					books.printBooks();			
				}
				break;
				
			case "REMOVE":
				removeBook(books);
				break;
				
			case "EDIT":
				editBook(books);
				break;
				
			case "CLEAR":
				clearScreen();
				break;
				
			case "QUIT":
				System.out.println("Thank you for using \"Books review!\" app! See you soon!");
				app_on = false;
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		
	}

}
