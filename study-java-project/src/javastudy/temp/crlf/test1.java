package javastudy.temp.crlf;

import java.io.IOException;

public class test1 {
	public static void main(String[] args) throws IOException {
		int letter = 0;
		System.out.print("Type a letter and press Enter: ");

//		while ((letter = System.in.read()) != 10) { // loops throw whole inputStream until there is a new Line Feed
		while ((letter = System.in.read()) != 0) { // loops throw whole inputStream until there is a new Line Feed
			System.out.println("You typed: " + letter);
			System.out.println((char) letter);
		}
	}
}
