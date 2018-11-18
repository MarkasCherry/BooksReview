package mainPackage;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		BooksList books = new BooksList();
		
		while(true) {
			System.out.print("\nDo you want to rate a book? (yes/no): ");
			String answer = in.next();
			
			if(answer.toLowerCase().equals("no")) {
				System.out.println("\nThank you for using \"Books review\" app! See you soon!\n");
				break;
			}
			
			Book book = new Book();
			book.ask();
			books.addBook(book);
			
		}
		
		books.printBooks();
		
	}

}
