package javastudy.temp.crlf;

import java.io.IOException;

public class test2 {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[10];
		int readByteNo = System.in.read(bytes);
		for (int i = 0; i < 10; i++) {
			System.out.println(bytes[i]);
		}
	}
}
