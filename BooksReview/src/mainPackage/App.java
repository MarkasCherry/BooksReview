package mainPackage;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.print("Do you want to rate a book? (yes/no): ");
			String answer = in.next();
			
			if(answer.toLowerCase().equals("no")) {
				System.out.println("Thank you for using \"Books review\" app! See you soon!");
				break;
			}
			
			Book book = new Book();
			book.ask();
			
		}
		
	}

}
