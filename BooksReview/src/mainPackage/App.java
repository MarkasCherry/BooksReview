package mainPackage;

import java.util.Scanner;

/* I have finished this app on 12/01/2019
 * This was my assignment for Java programming class (1st year)
 * Made by Markas Vysniauskas
 * Student ID: 21372173
 */

public class App {
	
	public static void clearScreen() {	//clears screen
	    for(int i = 0; i < 50; i++) {
	    	System.out.println("\n");
	    }
	}
	
	public static void removeBook(BooksList books) {	//removes review
		Scanner in = new Scanner(System.in);
		
		System.out.println("Choose one from below: \n1) Enter list number (removes one review)"
				+ "\n2) Enter name of the book (removes all reviews of this book)"
				+ "\n3) Remove all existing reviews\nStop) Cancel removing");
		String cmd = in.nextLine();
		
		try {
			switch(cmd) {
			case "1":	//removes one book by list number
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
				
			case "2":	//removes all books with same title
				System.out.print("Enter name of the book: ");
				String name = in.nextLine();
				
				books.removeBook(name.toUpperCase());
				System.out.println("All reviews of this book has been remove!");
				break;
				
			case "3":	//removes all books
				books.removeBook();
				System.out.println("All reviews have been removed!");
				break;
				
			default:
				System.out.println("You canceled book removing.");
			}
		} catch (Exception e) {
			System.out.println("ERROR: Please make sure you have input correct information.");
		}
	}

	public static void editBook(BooksList books) {	//edits review info
		Scanner in = new Scanner(System.in);
		
		try {	
			books.printBooks();	
			System.out.print("\nEnter list No. of the book: ");
			int index = in.nextInt();
			in.nextLine();
			
			if(index <= books.getSize() && index > 0) {
				System.out.println("Choose what part of the book you want to edit:"
						+ "\n1) Author\n2) Title\n3) Release year\n4) Rating\nStop) Cancel editing");
				String cmd = in.nextLine();
	
				switch(cmd) {
				case "1":	//edits author
					books.get(index - 1).askAuthor();
					break;
				
				case "2":	//edits title
					books.get(index - 1).askTitle();
					break;
					
				case "3":	//edits release year
					books.get(index - 1).askDate();
					break;
					
				case "4":	//edits rating
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
		
		} catch (Exception e) {
			System.out.println("ERROR: Please make sure that you have input correct information.");
			return;
		}
		
	}
	
	public static void sort(BooksList books) {	//sorting
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Choose one from below:"
				+ "\n1) Sort by authors\n2) Sort by titles\n3) Sort by release years\n4) Sort by ratings"
				+ "\nStop) Cancel sorting");
		
		String cmd = in.nextLine();
		
		switch(cmd) {
		case "1":	//sorts by authors
			System.out.println("Reviews were sorted by authors!");
			books.sortByAuthor();
			break;
			
		case "2":	//sorts by titles
			System.out.println("Reviews were sorted by titles!");
			books.sortByTitle();
			break;
			
		case "3":	//sorts by release years
			System.out.println("Reviews were sorted by release years!");
			books.sortByDate();
			break;
			
		case "4":	//sorts by ratings
			System.out.println("Reviews were sorted by ratings!");
			books.sortByRating();
			break;
			
		default:
			System.out.println("Sorting was cancelled.");
		}
		
	}
	
	//Main_______________________________________________________________________________________________________________________

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);                                                       
		
		BooksList books = new BooksList();
		books.readFile();	//reads info from a file
		
		System.out.println("\n\n\n");
		System.out.println("\t#############################################################");
		System.out.println("\t#                                                           #");
		System.out.println("\t#     Welcome to  B O O K S   R E V I E W   Application     #");
		System.out.println("\t#                                                           #");
		System.out.println("\t#                  Made by Markas Vysniauskas               #");
		System.out.println("\t#                     Student ID: 21372173                  #");
		System.out.println("\t#                                                           #");
		System.out.println("\t#############################################################");
		
		
		
		boolean app_on = true;
		while(app_on) {
			System.out.println("\n\t Review   Print   Remove   Edit   Sort   Save   Clear   Quit");	//menu
			String cmd = in.nextLine();
			
			switch(cmd.toUpperCase()) {
			case "REVIEW":	//adds new review
				try {
					Book book = new Book();
					book.ask();
					books.add(book);
					System.out.println("\nA new review has been created!");
					break;
				} catch (Exception e) {
					System.out.println("ERROR: Please make sure that you have input correct information.");
					break;
				}

				
			case "PRINT":	//prints out reviews
				if(books.getSize() == 0) {
					System.out.println("There is no reviewed books");
				}
				else {
					books.printBooks();			
				}
				break;
				
			case "REMOVE":	//removes review
				if(books.getSize() == 0) {
					System.out.println("There is no reviewed books");
				}
				else {
					removeBook(books);		
				}
				break;
				
			case "EDIT":	//edits review
				if(books.getSize() == 0) {
					System.out.println("There is no reviewed books");
				}
				else {
					editBook(books);			
				}
				break;
				
			case "SORT":	//sorts books
				if (books.getSize() == 0) {
					System.out.println("There is no reviewed books");
				}
				else {
					sort(books);
				}
				break;
				
			case "CLEAR":	//clears screen
				clearScreen();
				break;
				
			case "SAVE":	//saves reviews
				books.save();
				System.out.println("All reviews have been saved!");
				break;
				
			case "QUIT":	//exits app
				clearScreen();
				
				System.out.println("Do you want to save before closing app? [yes/no]");
				cmd = in.nextLine();
				
				if (cmd.equalsIgnoreCase("YES")) {
					books.save();
				}
				
				clearScreen();
				System.out.println("Thank you for using \"Books review!\" app! See you soon!");
				app_on = false;
				break;
			
			default:
				System.out.println("Invalid command");
			}
		}
		
	}

}
