package mainPackage;

import java.io.IOException;
import java.util.Scanner;

public class App {
	
	public static void clearScreen() {  
	    for(int i = 0; i < 50; i++) {
	    	System.out.println("\n");
	    }
	}

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		BooksList books = new BooksList();
		
		boolean app_on = true;
		while(app_on) {
			System.out.println("\nNew_book  Print\t Remove\t Clear\t Quit");
			String cmd = in.next();
			
			switch(cmd.toUpperCase()) {
			case "NEW_BOOK":
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
				System.out.println("Chose one from below how to remove: \n1) Enter list No.\n2) Enter name of the book\nStop) Cancel removing:");
				cmd = in.next();
				 
				switch(cmd) {
				case "1":
					System.out.print("Enter list number: ");
					books.remove(in.nextInt() - 1);
					System.out.println("The book has been removed!");
					break;
					
				case "2":
					System.out.print("Enter name of the book: ");
					books.remove(in.nextLine().toUpperCase());
					System.out.println("All review of this book has been removed!");
					break;
					
				default:
					System.out.println("You canceled book removing.");
				}
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
