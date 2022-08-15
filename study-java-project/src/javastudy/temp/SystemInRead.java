package javastudy.temp;

import java.io.IOException;
import java.io.InputStream;

public class SystemInRead {
	public static void main(String[] args) throws IOException {
		byte[] datas = new byte[100];
		
		InputStream is = System.in;
		int nameBytes = is.read(datas);
		String name = new String(datas, 0, nameBytes);
		System.out.println(name);
		for (int i = 0; i < name.length(); i++) {
			int nCode = (int) name.charAt(i);
			System.out.println(nCode);
			System.out.println(Integer.toBinaryString(nCode));
		}
		System.out.println("byte");
		for (int i = 0; i < nameBytes - 2; i++) {
			int nByte = (int)datas[i];
			System.out.println(nByte);
			System.out.println(Integer.toBinaryString(nByte).substring(24));
		}
	}
}
