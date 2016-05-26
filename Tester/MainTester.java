package Tester;

import java.io.FileReader;

import CaesarCipher.CaesarCipher;
import CaesarCipher.CaesarCracker;
import edu.duke.*;

public class MainTester {
	
	/*
	 * Test class
	 */

	public static void main(String[] args) {
	/*
	 * Test CaesarCipher	
	 */
		String path = "././data/titus-small.txt";
		FileResource resource = new FileResource(path);
		CaesarCipher OBJ  = new CaesarCipher(5);
		String encrypth = OBJ.encrypt(resource.asString());
		System.out.println(encrypth);
		System.out.println(OBJ.decrypt(encrypth));

	/*
	 * Test CaesarCracker	
	 */
		CaesarCracker BREAK = new CaesarCracker();
		int key = BREAK.getKey(encrypth);
		System.out.print(key);
	}

}
