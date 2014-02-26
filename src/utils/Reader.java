package utils;

import java.util.Scanner;

public class Reader {
	static Scanner reader;
	static {
		reader = new Scanner(System.in);
	}
	public static String readNextLine(){
		System.out.print("Enter: ");
		return reader.nextLine();
	}
}
