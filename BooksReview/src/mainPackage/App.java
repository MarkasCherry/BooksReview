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
		
		System.out.println("Choose one from below how to remove: \n1) Enter list No. (removes spacific review)"
				+ "\n2) Enter name of the book (removes all reviews of this book)"
				+ "\n3) Removes all existing reviews\nStop) Cancel removing");
		String cmd = in.next();
		
		switch(cmd) {
		case "1":
			books.printBooks();	
			System.out.print("\nEnter list number: ");
			int index = in.nextInt();
			in.nextLine();
			
			if(index <= books.getSize() && index > 0) {
				books.removeBook(index - 1);
				System.out.println("The book has been removed!");
			}
			else {
				System.out.println("The book does not exist");
			}
			break;
			
		case "2":
			in.nextLine();
			System.out.print("Enter name of the book: ");
			String name = in.nextLine();
			
			books.removeBook(name.toUpperCase());
			System.out.println("All reviews of this book has been remove!");
			break;
			
		case "3":
			books.removeBook();
			System.out.println("All reviews have been removed!");
			break;
			
		default:
			System.out.println("You canceled book removing.");
		}
	}

	public static void editBook(BooksList books) {
		Scanner in = new Scanner(System.in);
		
		books.printBooks();	
		System.out.println("\nEnter list No. of the book:	");
		int index = in.nextInt();
		in.nextLine();
		
		if(index <= books.getSize() && index > 0) {
			System.out.println("Choose what part of the book you want to edit:\n1) Author\n2) Title\n3) Release year\n4) Rating\nStop) Cancel editing");
			String cmd = in.next();
			
			switch(cmd) {
			case "1":
				books.get(index - 1).askAuthor();
				break;
			
			case "2":
				books.get(index - 1).askTitle();
				break;
				
			case "3":
				books.get(index - 1).askDate();
				break;
				
			case "4":
				books.get(index - 1).askRating();
				break;
				
			default:
				System.out.println("The editing of book was cancelled.");
				return;
			}
			
			System.out.println("Your book review was edited!");
		}
		else {
			System.out.println("The book does not exist");
		}
		
	}
	
	public static void sort(BooksList books) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Choose one from below:\n1) Sort by authors\n2) Sort by title\n3) Sort by date\n4) Sort by rating"
				+ "\nStop) Cancel sorting");
		
		String cmd = in.next();
		
		switch(cmd) {
		case "1":
			System.out.println("Reviews was sorted by authors!");
			//call method
			break;
			
		case "2":
			System.out.println("Reviews was sorted by titles!");
			books.sortByTitle();
			break;
			
		case "3":
			System.out.println("Reviews was sorted by dates!");
			books.sortByDate();
			break;
			
		case "4":
			System.out.println("Reviews was sorted by ratings!");
			books.sortByRating();
			break;
			
		default:
			System.out.println("Sorting was cancelled.");
		}
		
	}
	
	//Main________________________________________________________________________________________________________________________

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		BooksList books = new BooksList();
		books.readFile();
		
		boolean app_on = true;
		while(app_on) {
			System.out.println("\n\t Review\t Print\t Remove\t Edit\t Sort\t Save\t Clear\t Quit");
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
				if(books.getSize() == 0) {
					System.out.println("There is no reviewed books");
				}
				else {
					removeBook(books);		
				}
				break;
				
			case "EDIT":
				if(books.getSize() == 0) {
					System.out.println("There is no reviewed books");
				}
				else {
					editBook(books);			
				}
				break;
				
			case "SORT":
				System.out.println("SORTING NOT WORKING");	//reminder for me
				sort(books);
				break;
				
			case "CLEAR":
				clearScreen();
				break;
				
			case "SAVE":
				books.save();
				System.out.println("All reviews have been saved!");
				break;
				
			case "QUIT":
				books.save();
				clearScreen();
				System.out.println("Thank you for using \"Books review!\" app! See you soon!");
				app_on = false;
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		
	}

}
