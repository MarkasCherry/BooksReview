package mainPackage;

import java.io.*;

public class Test {

	public static void main(String[] args) {
		
		String author;
		String title;
		String date;
		double rate;
		
		/* READING FROM FILE */
		
		
		
		/* WRITING TO FILE */
		
		try {
			FileWriter fw =  new FileWriter("reviews.txt");
			PrintWriter fout = new PrintWriter(fw);
			
			fout.print("Markas Vysniauskas\t" + "PARADISE\t" + "24/11/2018\t" + 7.41);
			
			fout.close();
		}
		
		catch (IOException e) {
			System.out.println("ERROR with writing a file");
		}

	}

}
